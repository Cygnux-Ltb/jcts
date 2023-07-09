package io.cygnuxltb.jcts.core.pool;

import io.horizon.market.instrument.Instrument;
import io.horizon.market.instrument.Symbol;
import io.horizon.market.instrument.attr.TradablePeriod;
import io.mercury.common.collections.MutableMaps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalTime;

import static io.mercury.common.lang.Asserter.requiredLength;

@ThreadSafe
public final class TradablePeriodPool {

    private TradablePeriodPool() {
    }

    // Map<symbolId, ImmutableList<TradablePeriod>>
    private static ImmutableIntObjectMap<ImmutableList<TradablePeriod>> Pool;

    public synchronized static void register(Symbol[] symbols) {
        requiredLength(symbols, 1, "symbols");
        var map = MutableMaps.<ImmutableList<TradablePeriod>>newIntObjectHashMap();
        if (Pool != null)
            Pool.forEachKeyValue(map::put);
        for (var symbol : symbols) {
            if (!map.containsKey(symbol.getSymbolId()))
                map.put(symbol.getSymbolId(), symbol.getTradablePeriods());
        }
        Pool = map.toImmutable();
    }

    /**
     * 获取指定Instrument的交易周期
     *
     * @param instrument Instrument
     * @return ImmutableList<TradablePeriod>
     */
    public static synchronized ImmutableList<TradablePeriod> getTradingPeriods(Instrument instrument) {
        return Pool.get(instrument.getSymbol().getSymbolId());
    }

    /**
     * 获取指定Symbol的交易周期
     *
     * @param symbol Symbol
     * @return ImmutableList<TradablePeriod>
     */
    public static synchronized ImmutableList<TradablePeriod> getTradingPeriods(Symbol symbol) {
        return Pool.get(symbol.getSymbolId());
    }

    /**
     * @param instrument Instrument
     * @param time       LocalTime
     * @return TradablePeriod
     */
    public static synchronized TradablePeriod nextTradingPeriod(Instrument instrument, LocalTime time) {
        return nextTradingPeriod(instrument.getSymbol(), time);
    }

    /**
     * 获取下一个交易时段
     *
     * @param symbol Symbol
     * @param time   LocalTime
     * @return TradablePeriod
     */
    public static synchronized TradablePeriod nextTradingPeriod(Symbol symbol, LocalTime time) {
        var tradingPeriods = getTradingPeriods(symbol);
        TradablePeriod result = null;
        int baseTime = time.toSecondOfDay();
        int baseDiff = Integer.MAX_VALUE;
        for (var period : tradingPeriods) {
            int start = period.getStart().toSecondOfDay();
            int diff = Math.abs(start - baseTime);
            if (diff < baseDiff) {
                baseDiff = diff;
                result = period;
            }
        }
        return result;
    }

}
