package io.horizon.trader.order.enums;

import io.horizon.trader.order.TdxProvider;
import io.horizon.trader.serialization.avro.enums.AvroOrdType;

public enum OrdType implements TdxProvider<AvroOrdType> {

    Invalid(OrdTypeCode.INVALID, AvroOrdType.INVALID),

    Limited(OrdTypeCode.LIMITED, AvroOrdType.LIMITED),

    Market(OrdTypeCode.MARKET, AvroOrdType.MARKET),

    /**
     * Limited Stop, 在目前的市场价格达到指定的止损价格时, 被激活成为限价单的报单.
     */
    LimitedStop(OrdTypeCode.LIMITED_STOP, AvroOrdType.LIMITED_STOP),

    /**
     * Market Stop, 在目前的市场价格达到指定的止损价格时, 被激活成为市价单的报单.
     */
    MarketStop(OrdTypeCode.MARKET_STOP, AvroOrdType.MARKET_STOP),

    /**
     * Market To Limited, 按照市价报单的方式成交, 不能成交的部分保留在报单队列中, 变成限价单的报单.
     */
    MarketToLimited(OrdTypeCode.MTL, AvroOrdType.MTL),

    /**
     * Best Price, 不带有价格限定, 按照市场中存在的最好价格买入或者卖出的报单.
     */
    BestPrice(OrdTypeCode.BP, AvroOrdType.BP),

    /**
     * Average Price, 限定最终成交平均价格的报单.
     */
    AveragePrice(OrdTypeCode.AP, AvroOrdType.AP),

    /**
     * Fill Or Kill, 表示要求立即全部成交, 否则就全部取消的报单.
     */
    FillOrKill(OrdTypeCode.FOK, AvroOrdType.FOK),

    /**
     * Fill And Kill, 表示要求立即成交, 对于无法满足的部分予以取消的报单.
     */
    FillAndKill(OrdTypeCode.FAK, AvroOrdType.FAK),

    /**
     * Minimum Volume, 要求满足成交量达到这个最小成交量, 否则就取消的报单.
     */
    MinimumVolume(OrdTypeCode.MV, AvroOrdType.MV),

    ;

    private final char code;

    private final AvroOrdType tdxValue;

    OrdType(char code, AvroOrdType tdxValue) {
        this.code = code;
        this.tdxValue = tdxValue;
    }

    public char getCode() {
        return code;
    }

    /**
     * @return OrdType.Limited
     */
    public static OrdType defaultType() {
        return OrdType.Limited;
    }

    @Override
    public AvroOrdType getTdxValue() {
        return tdxValue;
    }

    /**
     * @author yellow013
     */
    public interface OrdTypeCode {

        char INVALID = 'I';

        char LIMITED = 'L';

        char MARKET = 'M';
        /**
         * Limited Stop, 在目前的市场价格达到指定的止损价格时, 被激活成为限价单的报单.
         */
        char LIMITED_STOP = 'S';
        /**
         * Market Stop, 在目前的市场价格达到指定的止损价格时, 被激活成为市价单的报单.
         */
        char MARKET_STOP = 'P';
        /**
         * Market To Limited, 按照市价报单的方式成交, 不能成交的部分保留在报单队列中, 变成限价单的报单.
         */
        char MTL = 'K';
        /**
         * Best Price, 不带有价格限定, 按照市场中存在的最好价格买入或者卖出的报单.
         */
        char BP = 'B';
        /**
         * Average Price, 限定最终成交平均价格的报单.
         */
        char AP = 'V';
        /**
         * Fill Or Kill, 表示要求立即全部成交, 否则就全部取消的报单.
         */
        char FOK = 'O';
        /**
         * Fill And Kill, 表示要求立即成交, 对于无法满足的部分予以取消的报单.
         */
        char FAK = 'A';
        /**
         * Minimum Volume, 要求满足成交量达到这个最小成交量, 否则就取消的报单.
         */
        char MV = 'M';
    }

}
