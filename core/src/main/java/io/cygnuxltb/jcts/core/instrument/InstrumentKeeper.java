package io.cygnuxltb.jcts.core.instrument;

import io.cygnuxltb.jcts.core.instrument.futures.ChinaFutures;
import io.horizon.market.instrument.Instrument;
import io.horizon.market.instrument.Symbol;
import io.mercury.common.collections.MutableLists;
import io.mercury.common.collections.MutableMaps;
import io.mercury.common.lang.Asserter;
import io.mercury.common.log4j2.Log4j2LoggerFactory;
import io.mercury.serialization.json.JsonWrapper;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
 * 管理全局Instrument状态
 *
 * @author yellow013
 */
@ThreadSafe
public final class InstrumentKeeper {

    // Logger
    private static final Logger log = Log4j2LoggerFactory.getLogger(InstrumentKeeper.class);

    /**
     * 存储instrument, 以instrumentId索引
     */
    private static final MutableIntObjectMap<io.horizon.market.instrument.Instrument> InstrumentById = MutableMaps.newIntObjectHashMap();

    /**
     * 存储instrument, 以instrumentCode索引
     */
    private static final MutableMap<String, io.horizon.market.instrument.Instrument> InstrumentByCode = MutableMaps.newUnifiedMap();

    /**
     * 初始化标识
     */
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    private static ImmutableList<io.horizon.market.instrument.Instrument> instruments;

    private InstrumentKeeper() {
    }


    private static void initialize() {
        if (isInitialized.compareAndSet(false, true)) {
            try {
                Stream.of(ChinaFutures.ChinaFuturesSymbol.values()).forEach(InstrumentKeeper::putInstrument);
                InstrumentKeeper.instruments = InstrumentById.toList().toImmutable();
                log.info("InstrumentKeeper is initialized");
            } catch (Exception e) {
                var re = new RuntimeException("InstrumentManager initialization failed", e);
                log.error("InstrumentManager initialization failed", re);
                throw re;
            }
        } else {
            log.error("InstrumentManager already initialized");
        }
    }

    private static void putInstrument(Symbol symbol) {
        symbol.getInstruments().each(instrument -> {
            log.info("Put instrument, instrumentId==[{}], instrumentCode==[{}], instrument -> {}",
                    instrument.getInstrumentId(), instrument.getInstrumentCode(), instrument);
            InstrumentById.put(instrument.getInstrumentId(), instrument);
            InstrumentByCode.put(instrument.getInstrumentCode(), instrument);
            setTradable(instrument);
        });
    }

    public static boolean isInitialized() {
        return isInitialized.get();
    }

    /**
     * @param instrument Instrument
     */
    public static io.horizon.market.instrument.Instrument setTradable(@Nonnull io.horizon.market.instrument.Instrument instrument) {
        return setTradable(instrument.getInstrumentId());
    }

    /**
     * @param instrumentId int
     */
    public static io.horizon.market.instrument.Instrument setTradable(int instrumentId) {
        var instrument = getInstrument(instrumentId);
        instrument.enable();
        log.info("Instrument enable, instrumentId==[{}], instrument -> {}", instrumentId, instrument);
        return instrument;
    }

    /**
     * @param instrument Instrument
     * @return Instrument
     */
    public static io.horizon.market.instrument.Instrument setNotTradable(io.horizon.market.instrument.Instrument instrument) {
        return setNotTradable(instrument.getInstrumentId());
    }

    /**
     * @param instrumentId int
     * @return Instrument
     */
    public static io.horizon.market.instrument.Instrument setNotTradable(int instrumentId) {
        var instrument = getInstrument(instrumentId);
        instrument.disable();
        log.info("Instrument disable, instrumentId==[{}], instrument -> {}", instrumentId, instrument);
        return instrument;
    }

    /**
     * @param instrument Instrument
     * @return boolean
     */
    public static boolean isTradable(io.horizon.market.instrument.Instrument instrument) {
        return isTradable(instrument.getInstrumentId());
    }

    /**
     * @param instrumentId int
     * @return boolean
     */
    public static boolean isTradable(int instrumentId) {
        return getInstrument(instrumentId).isEnabled();
    }

    /**
     * @return ImmutableList
     */
    public static ImmutableList<io.horizon.market.instrument.Instrument> getInstruments() {
        return instruments;
    }

    /**
     * @param instrumentId int
     * @return Instrument
     */
    public static io.horizon.market.instrument.Instrument getInstrument(int instrumentId) {
        var instrument = InstrumentById.get(instrumentId);
        if (instrument == null)
            throw new IllegalArgumentException("Instrument is not find, by instrumentId : " + instrumentId);
        return instrument;
    }

    /**
     * @param instrumentCodes String[]
     * @return Instrument[]
     */
    public static io.horizon.market.instrument.Instrument[] getInstrument(String[] instrumentCodes) {
        if (isInitialized()) {
            Asserter.requiredLength(instrumentCodes, 1, "instrumentCodes");
            var list = MutableLists.<io.horizon.market.instrument.Instrument>newFastList();
            for (String instrumentCode : instrumentCodes) {
                io.horizon.market.instrument.Instrument instrument = null;
                try {
                    instrument = getInstrument(instrumentCode);
                } catch (IllegalArgumentException e) {
                    log.error("Exception message -> {}", e.getMessage(), e);
                }
                if (instrument != null) {
                    log.info("Found instrument -> {}", instrument);
                    list.add(instrument);
                } else {
                    log.error("Not found instrument, with instrument code -> {}", instrumentCode);
                }
            }
            return list.toArray(new io.horizon.market.instrument.Instrument[list.size()]);
        } else {
            initialize();
            return getInstrument(instrumentCodes);
        }
    }

    /**
     * @param instrumentCode String
     * @return Instrument
     */
    public static Instrument getInstrument(String instrumentCode) throws IllegalArgumentException {
        var instrument = InstrumentByCode.get(instrumentCode.toUpperCase());
        if (instrument == null)
            instrument = InstrumentByCode.get(instrumentCode.toLowerCase());
        if (instrument == null)
            throw new IllegalArgumentException("Instrument is not find, by instrument code : " + instrumentCode);
        return instrument;
    }

    /**
     * @return Pretty Json String
     */
    public static String showStatus() {
        var map = new HashMap<>();
        map.put("isInitialized", isInitialized);
        map.put("instruments", getInstruments());
        return JsonWrapper.toPrettyJson(map);
    }

}
