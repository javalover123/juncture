/*
 * Copyright (C) 2021 盈宝信息科技（广州）有限公司
 * All Rights Reserved.
 */

package com.paritytrading.juncture.nasdaq.nls30;

import static com.paritytrading.juncture.nasdaq.nls30.NLS30.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * NLS PLUS 3.0 handler
 *
 * @author javalover123
 * @date 2021/7/5
 */
public class NLS30Source implements NLS30Listener {

    protected static final Map<String, AtomicLong> TYPE_COUNT_MAP = new ConcurrentHashMap<>();

    public NLS30Source() {
    }

    @Override
    public void systemEvent(SystemEvent message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeReportForNonNextShares(TradeReportForNonNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeReportForNonNextShares(LongFormTradeReportForNonNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeReportForNextShares(TradeReportForNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeCancelErrorForNonNextShares(TradeCancelErrorForNonNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeCancelErrorForNonNextShares(LongFormTradeCancelErrorForNonNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeCancelErrorForNextShares(TradeCancelErrorForNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeCorrectionForNonNextShares(TradeCorrectionForNonNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeCorrectionForNonNextShares(LongFormTradeCorrectionForNonNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void tradeCorrectionForNextShares(TradeCorrectionForNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void stockTradingAction(StockTradingAction message) throws IOException {
        handle(message);
    }

    @Override
    public void stockDirectory(StockDirectory message) throws IOException {
        handle(message);
    }

    @Override
    public void regSHORestriction(RegSHORestriction message) throws IOException {
        handle(message);
    }

    @Override
    public void adjustedClosingPrice(AdjustedClosingPrice message) throws IOException {
        handle(message);
    }

    @Override
    public void adjustedClosingPrice(LongFormAdjustedClosingPrice message) throws IOException {
        handle(message);
    }

    @Override
    public void endOfDayTradeSummary(EndOfDayTradeSummary message) throws IOException {
        handle(message);
    }

    @Override
    public void endOfDayTradeSummary(LongFormEndOfDayTradeSummary message) throws IOException {
        handle(message);
    }

    @Override
    public void endOfDayTradeSummaryNextShares(EndOfDayTradeSummaryNextShares message) throws IOException {
        handle(message);
    }

    @Override
    public void ipoInformation(IPOInformation message) throws IOException {
        handle(message);
    }

    @Override
    public void mwcbDeclineLevel(MWCBDeclineLevel message) throws IOException {
        handle(message);
    }

    @Override
    public void mwcbStatus(MWCBStatus message) throws IOException {
        handle(message);
    }

    @Override
    public void ipoQuotingPeriodUpdate(IPOQuotingPeriodUpdate message) throws IOException {
        handle(message);
    }

    @Override
    public void operationalHalt(OperationalHalt message) throws IOException {
        handle(message);
    }

    protected void handle(Message message) {
        String topic = "us.nlsp_" + message.getClass().getSimpleName();
        log(message, topic);
    }

    protected void log(Message message, String topic) {
        AtomicLong count = TYPE_COUNT_MAP.get(topic);
        if (count == null) {
            count = new AtomicLong(0);
            TYPE_COUNT_MAP.put(topic, count);
        }
        if (count.incrementAndGet() % logPerNum() == 0) {
            TYPE_COUNT_MAP.put(topic, count);
            System.out.println(topic + "|" + count);
        }
    }

    protected int logPerNum() {
        return 1000;
    }

}
