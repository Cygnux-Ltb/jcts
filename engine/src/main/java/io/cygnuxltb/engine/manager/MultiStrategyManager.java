package io.cygnuxltb.engine.manager;

import io.horizon.market.data.MarketData;
import io.horizon.market.instrument.Instrument;
import io.horizon.trader.strategy.Strategy;
import io.mercury.common.annotation.AbstractFunction;
import io.mercury.common.collections.MutableSets;
import io.mercury.common.log4j2.Log4j2LoggerFactory;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.slf4j.Logger;

import java.io.IOException;

import static io.mercury.common.collections.MutableMaps.newIntObjectHashMap;
import static org.apache.commons.io.IOUtils.closeQuietly;

public abstract class MultiStrategyManager<M extends MarketData>
        implements StrategyManager<M> {

    /**
     * Logger
     */
    private static final Logger log = Log4j2LoggerFactory.getLogger(MultiStrategyManager.class);

    /**
     * 策略列表
     */
    protected final MutableIntObjectMap<Strategy<M>> strategyMap = newIntObjectHashMap();

    /**
     * 订阅合约的策略列表 <br>
     * instrumentId -> Set::[Strategy]
     */
    protected final MutableIntObjectMap<MutableSet<Strategy<M>>> subscribedMap = newIntObjectHashMap();

    @Override
    public StrategyManager<M> addStrategy(Strategy<M> strategy) {
        log.info("Add strategy -> strategyId==[{}], strategyName==[{}], subAccount==[{}]",
                strategy.getId(), strategy.getName(), strategy.getSubAccount());
        strategyMap.put(strategy.getId(), strategy);
        strategy.getInstruments().each(instrument -> subscribeInstrument(instrument, strategy));
        strategy.enable();
        return this;
    }

    private void subscribeInstrument(Instrument instrument, Strategy<M> strategy) {
        subscribedMap.getIfAbsentPut(instrument.getInstrumentId(), MutableSets::newUnifiedSet).add(strategy);
        log.info("Add subscribe instrument, strategyId==[{}], instrumentId==[{}]", strategy.getId(),
                instrument.getInstrumentId());
    }

    @AbstractFunction
    protected abstract void close0() throws IOException;

    @Override
    public void close() throws IOException {
        strategyMap.each(strategy ->
                closeQuietly(strategy, e ->
                        log.error("strategy -> {} close exception!",
                                strategy.getName(), e)));
        close0();
    }

}
