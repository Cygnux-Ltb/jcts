package io.cygnuxltb.jcts.engine.manager;

import io.cygnuxltb.jcts.core.mkd.MarketData;
import io.cygnuxltb.jcts.core.mkd.MarketDataKeeper;
import io.cygnuxltb.jcts.core.order.ChildOrder;
import io.cygnuxltb.jcts.core.serialization.avro.event.AvAdaptorEvent;
import io.cygnuxltb.jcts.core.serialization.avro.event.AvOrderEvent;
import io.cygnuxltb.jcts.engine.trader.OrderKeeper;
import io.mercury.common.collections.Capacity;
import io.mercury.common.collections.queue.Queue;
import io.mercury.common.log4j2.Log4j2LoggerFactory;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

import static io.mercury.common.concurrent.queue.ScQueueWithJCT.spscQueue;

/**
 * @author yellow013
 * <p>
 * 策略执行引擎与整体框架分离
 */
public final class AsyncMultiStrategyManager<M extends MarketData> extends MultiStrategyManager<M> {

    private static final Logger log = Log4j2LoggerFactory.getLogger(AsyncMultiStrategyManager.class);

    private final Queue<QueueMsg> queue;

    private static final int MarketData = 0;
    private static final int OrderReport = 1;
    private static final int AdaptorEvent = 2;

    public AsyncMultiStrategyManager(Capacity capacity) {
        this.queue = spscQueue("AsyncMultiStrategyScheduler-Queue")
                .capacity(capacity.value()).spinStrategy().process(msg -> {
                    switch (msg.getMark()) {
                        case MarketData -> {
                            M marketData = msg.getMarketData();
                            MarketDataKeeper.onMarketDate(marketData);
                            subscribedMap.get(marketData.getInstrumentId()).each(strategy -> {
                                if (strategy.isEnabled()) {
                                    strategy.onMarketData(marketData);
                                }
                            });
                        }
                        case OrderReport -> {
                            var event = msg.getOrderEvent();
                            log.info("Handle OrderEvent, brokerUniqueId==[{}], ordSysId==[{}]", event.getBrokerOrdSysId(),
                                    event.getOrdSysId());
                            ChildOrder order = OrderKeeper.handleOrderReport(event);
                            log.info(
                                    "Search Order OK. brokerSysId==[{}], strategyId==[{}], instrumentCode==[{}], ordSysId==[{}]",
                                    event.getBrokerOrdSysId(), order.getStrategyId(),
                                    order.getInstrument().getInstrumentCode(), event.getOrdSysId());
                            strategyMap.get(order.getStrategyId()).onOrder(order);
                        }
                        case AdaptorEvent -> {
                            AvAdaptorEvent adaptorReport = msg.getAdaptorEvent();
                            String adaptorId = adaptorReport.getAdaptorId();
                            log.info("Recv AdaptorEvent -> {}", adaptorReport);
                        }
                        default -> throw new IllegalStateException("scheduler mark illegal");
                    }
                });
    }

    // TODO add pools
    @Override
    public void onMarketData(@Nonnull M marketData) {
        queue.enqueue(new QueueMsg(marketData));
    }

    // TODO add pools
    @Override
    public void onOrderEvent(@Nonnull AvOrderEvent event) {
        queue.enqueue(new QueueMsg(event));
    }

    // TODO add pools
    @Override
    public void onAdaptorEvent(@Nonnull AvAdaptorEvent report) {
        queue.enqueue(new QueueMsg(report));
    }

    private class QueueMsg {

        private final int mark;

        private M marketData;

        private AvOrderEvent orderEvent;

        private AvAdaptorEvent adaptorEvent;

        private QueueMsg(M marketData) {
            this.mark = MarketData;
            this.marketData = marketData;
        }

        private QueueMsg(AvOrderEvent orderEvent) {
            this.mark = OrderReport;
            this.orderEvent = orderEvent;
        }

        private QueueMsg(AvAdaptorEvent adaptorEvent) {
            this.mark = AdaptorEvent;
            this.adaptorEvent = adaptorEvent;
        }

        public int getMark() {
            return mark;
        }

        public M getMarketData() {
            return marketData;
        }

        public AvOrderEvent getOrderEvent() {
            return orderEvent;
        }

        public AvAdaptorEvent getAdaptorEvent() {
            return adaptorEvent;
        }

    }

    @Override
    protected void close0() {
        // TODO Auto-generated method stub

    }

}
