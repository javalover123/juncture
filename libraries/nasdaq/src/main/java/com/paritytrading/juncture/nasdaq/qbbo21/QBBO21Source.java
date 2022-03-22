/*
 * Copyright (C) 2021 盈宝信息科技（广州）有限公司
 * All Rights Reserved.
 */

package com.paritytrading.juncture.nasdaq.qbbo21;

import static com.paritytrading.juncture.nasdaq.qbbo21.QBBO21.Message;
import static com.paritytrading.juncture.nasdaq.qbbo21.QBBO21.NextSharesQuotation;
import static com.paritytrading.juncture.nasdaq.qbbo21.QBBO21.OperationalHalt;
import static com.paritytrading.juncture.nasdaq.qbbo21.QBBO21.Quotation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * QBBO 2.1 handler
 *
 * @author javalover123
 * @date 2021/7/5
 */
public class QBBO21Source implements QBBO21Listener {

    protected static final Map<String, AtomicLong> TYPE_COUNT_MAP = new ConcurrentHashMap<>();

    public QBBO21Source() {
    }

    @Override
    public void systemEvent(QBBO21.SystemEvent message) {
        handle(message);
    }

    @Override
    public void stockDirectory(QBBO21.StockDirectory message) {
        handle(message);
    }

    @Override
    public void stockTradingAction(QBBO21.StockTradingAction message) {
        handle(message);
    }

    @Override
    public void regSHORestriction(QBBO21.RegSHORestriction message) {
        handle(message);
    }

    @Override
    public void mwcbDeclineLevel(QBBO21.MWCBDeclineLevel message) {
        handle(message);
    }

    @Override
    public void mwcbStatus(QBBO21.MWCBStatus message) {
        handle(message);
    }

    @Override
    public void ipoQuotingPeriodUpdate(QBBO21.IPOQuotingPeriodUpdate message) {
        handle(message);
    }

    @Override
    public void operationalHalt(OperationalHalt message) {
        handle(message);
    }

    @Override
    public void nextSharesQuotation(NextSharesQuotation message) {
        handle(message);
    }

    @Override
    public void quotation(Quotation message) {
        handle(message);
    }

    @Override
    public void rpii(QBBO21.RPII message) {
        handle(message);
    }

    protected void handle(Message message) {
        String topic = "us.qbbo_" + message.getClass().getSimpleName();
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
