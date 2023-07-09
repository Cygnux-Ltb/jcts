package io.cygnuxltb.console.persistence.entity;

import io.mercury.persistence.rdb.ColumnDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static io.cygnuxltb.console.persistence.CommonConst.Column.INSTRUMENT_CODE;
import static io.cygnuxltb.console.persistence.CommonConst.Column.STRATEGY_ID;
import static io.cygnuxltb.console.persistence.CommonConst.Column.TRADING_DAY;

/**
 * 盈亏表
 * Pnl Entity
 *
 * @author yellow013
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "TBL_T_PNL")
public final class TblTPnl {

    @Id
    @Column(name = ColumnDefinition.UID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    /**
     * strategyId
     */
    @Column(name = STRATEGY_ID)
    private int strategyId;

    /**
     * instrumentCode
     */
    @Column(name = INSTRUMENT_CODE)
    private String instrumentCode;

    /**
     * tradingDay
     */
    @Column(name = TRADING_DAY)
    private int tradingDay;

    /**
     * avgBuyPrice
     */
    @Column(name = "AVG_BUY_PRICE")
    private double avgBuyPrice;

    /**
     * avgSellPrice
     */
    @Column(name = "AVG_SELL_PRICE")
    private double avgSellPrice;

    /**
     * buyQuantity
     */
    @Column(name = "BUY_QUANTITY")
    private int buyQuantity;

    /**
     * sellQuantity
     */
    @Column(name = "SELL_QUANTITY")
    private int sellQuantity;

    /**
     * todayLong
     */
    @Column(name = "TODAY_LONG")
    private int todayLong;

    /**
     * todayShort
     */
    @Column(name = "TODAY_SHORT")
    private int todayShort;

    /**
     * yesterdayLong
     */
    @Column(name = "YESTERDAY_LONG")
    private int yesterdayLong;

    /**
     * yesterdayShort
     */
    @Column(name = "YESTERDAY_SHORT")
    private int yesterdayShort;

    /**
     * netPosition
     */
    @Column(name = "NET_POSITION")
    private int netPosition;

    /**
     * aggregatedFee
     */
    @Column(name = "AGGREGATED_FEE")
    private double aggregatedFee;

    /**
     * approved
     */
    @Column(name = "APPROVED")
    private int approved;

    /**
     * turnover
     */
    @Column(name = "TURNOVER")
    private int turnover;

}
