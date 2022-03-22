/*
 * Copyright 2015 Juncture authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.juncture.nasdaq.nls30;

import static com.paritytrading.juncture.nasdaq.nls30.NLS30.*;

import com.paritytrading.nassau.MessageListener;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A parser for inbound messages.
 *
 * @author javalover123
 */
public class NLS30Parser implements MessageListener {

    private SystemEvent               systemEvent;
    private TradeReportForNonNextShares tradeReportForNonNextShares;
    private LongFormTradeReportForNonNextShares longFormTradeReportForNonNextShares;
    private TradeReportForNextShares    tradeReportForNextShares;
    private TradeCancelErrorForNonNextShares tradeCancelErrorForNonNextShares;
    private LongFormTradeCancelErrorForNonNextShares longFormTradeCancelErrorForNonNextShares;
    private TradeCancelErrorForNextShares tradeCancelErrorForNextShares;
    private TradeCorrectionForNonNextShares tradeCorrectionForNonNextShares;
    private LongFormTradeCorrectionForNonNextShares longFormTradeCorrectionForNonNextShares;
    private TradeCorrectionForNextShares tradeCorrectionForNextShares;
    private StockDirectory            stockDirectory;
    private StockTradingAction        stockTradingAction;
    private RegSHORestriction         regSHORestriction;
    private AdjustedClosingPrice      adjustedClosingPrice;
    private LongFormAdjustedClosingPrice      longFormAdjustedClosingPrice;
    private EndOfDayTradeSummary endOfDayTradeSummary;
    private LongFormEndOfDayTradeSummary longFormEndOfDayTradeSummary;
    private EndOfDayTradeSummaryNextShares endOfDayTradeSummaryNextShares;
    private IPOInformation            ipoInformation;
    private MWCBDeclineLevel          mwcbDeclineLevel;
    private MWCBStatus                mwcbStatus;
    private IPOQuotingPeriodUpdate    ipoQuotingPeriodUpdate;
    private OperationalHalt           operationalHalt;

    private NLS30Listener listener;

    /**
     * Create a parser for inbound messages.
     *
     * @param listener the message listener
     */
    public NLS30Parser(NLS30Listener listener) {
        this.systemEvent               = new SystemEvent();
        this.tradeReportForNonNextShares               = new TradeReportForNonNextShares();
        this.longFormTradeReportForNonNextShares               = new LongFormTradeReportForNonNextShares();
        this.tradeReportForNextShares               = new TradeReportForNextShares();
        this.tradeCancelErrorForNonNextShares               = new TradeCancelErrorForNonNextShares();
        this.longFormTradeCancelErrorForNonNextShares               = new LongFormTradeCancelErrorForNonNextShares();
        this.tradeCancelErrorForNextShares               = new TradeCancelErrorForNextShares();
        this.tradeCorrectionForNonNextShares               = new TradeCorrectionForNonNextShares();
        this.longFormTradeCorrectionForNonNextShares               = new LongFormTradeCorrectionForNonNextShares();
        this.tradeCorrectionForNextShares               = new TradeCorrectionForNextShares();
        this.stockDirectory            = new StockDirectory();
        this.stockTradingAction        = new StockTradingAction();
        this.regSHORestriction         = new RegSHORestriction();
        this.adjustedClosingPrice               = new AdjustedClosingPrice();
        this.longFormAdjustedClosingPrice               = new LongFormAdjustedClosingPrice();
        this.endOfDayTradeSummary               = new EndOfDayTradeSummary();
        this.longFormEndOfDayTradeSummary               = new LongFormEndOfDayTradeSummary();
        this.endOfDayTradeSummaryNextShares               = new EndOfDayTradeSummaryNextShares();
        this.ipoInformation            = new IPOInformation();
        this.mwcbDeclineLevel          = new MWCBDeclineLevel();
        this.mwcbStatus                = new MWCBStatus();
        this.ipoQuotingPeriodUpdate    = new IPOQuotingPeriodUpdate();
        this.operationalHalt           = new OperationalHalt();

        this.listener = listener;
    }

    @Override
    public void message(ByteBuffer buffer) throws IOException {
        byte messageType = buffer.get();

        switch (messageType) {
        case MESSAGE_TYPE_SYSTEM_EVENT:
            systemEvent.get(buffer);
            listener.systemEvent(systemEvent);
            break;
        case MESSAGE_TYPE_TRADE_REPORT_FOR_NON_NEXT_SHARES:
            tradeReportForNonNextShares.get(buffer);
            listener.tradeReportForNonNextShares(tradeReportForNonNextShares);
            break;
        case MESSAGE_TYPE_LONG_FORM_TRADE_REPORT_FOR_NON_NEXT_SHARES:
            longFormTradeReportForNonNextShares.get(buffer);
            listener.tradeReportForNonNextShares(longFormTradeReportForNonNextShares);
            break;
        case MESSAGE_TYPE_TRADE_REPORT_FOR_NEXT_SHARES:
            tradeReportForNextShares.get(buffer);
            listener.tradeReportForNextShares(tradeReportForNextShares);
            break;
        case MESSAGE_TYPE_TRADE_CANCEL_ERROR_FOR_NON_NEXT_SHARES:
            tradeCancelErrorForNonNextShares.get(buffer);
            listener.tradeCancelErrorForNonNextShares(tradeCancelErrorForNonNextShares);
            break;
        case MESSAGE_TYPE_LONG_FORM_TRADE_CANCEL_ERROR_FOR_NON_NEXT_SHARES:
            longFormTradeCancelErrorForNonNextShares.get(buffer);
            listener.tradeCancelErrorForNonNextShares(longFormTradeCancelErrorForNonNextShares);
            break;
        case MESSAGE_TYPE_TRADE_CANCEL_ERROR_FOR_NEXT_SHARES:
            tradeCancelErrorForNextShares.get(buffer);
            listener.tradeCancelErrorForNextShares(tradeCancelErrorForNextShares);
            break;
        case MESSAGE_TYPE_TRADE_CORRECTION_FOR_NON_NEXT_SHARES:
            tradeCorrectionForNonNextShares.get(buffer);
            listener.tradeCorrectionForNonNextShares(tradeCorrectionForNonNextShares);
            break;
        case MESSAGE_TYPE_LONG_FORM_TRADE_CORRECTION_FOR_NON_NEXT_SHARES:
            longFormTradeCorrectionForNonNextShares.get(buffer);
            listener.tradeCorrectionForNonNextShares(longFormTradeCorrectionForNonNextShares);
            break;
        case MESSAGE_TYPE_TRADE_CORRECTION_FOR_NEXT_SHARES:
            tradeCorrectionForNextShares.get(buffer);
            listener.tradeCorrectionForNextShares(tradeCorrectionForNextShares);
            break;
        case MESSAGE_TYPE_STOCK_DIRECTORY:
            stockDirectory.get(buffer);
            listener.stockDirectory(stockDirectory);
            break;
        case MESSAGE_TYPE_STOCK_TRADING_ACTION:
            stockTradingAction.get(buffer);
            listener.stockTradingAction(stockTradingAction);
            break;
        case MESSAGE_TYPE_REG_SHO_RESTRICTION:
            regSHORestriction.get(buffer);
            listener.regSHORestriction(regSHORestriction);
            break;
        case MESSAGE_TYPE_ADJUSTED_CLOSING_PRICE:
            adjustedClosingPrice.get(buffer);
            listener.adjustedClosingPrice(adjustedClosingPrice);
            break;
        case MESSAGE_TYPE_LONG_FORM_ADJUSTED_CLOSING_PRICE:
            longFormAdjustedClosingPrice.get(buffer);
            listener.adjustedClosingPrice(longFormAdjustedClosingPrice);
            break;
        case MESSAGE_TYPE_END_OF_DAY_TRADE_SUMMARY:
            endOfDayTradeSummary.get(buffer);
            listener.endOfDayTradeSummary(endOfDayTradeSummary);
            break;
        case MESSAGE_TYPE_LONG_FORM_END_OF_DAY_TRADE_SUMMARY:
            longFormEndOfDayTradeSummary.get(buffer);
            listener.endOfDayTradeSummary(longFormEndOfDayTradeSummary);
            break;
        case MESSAGE_TYPE_END_OF_DAY_TRADE_SUMMARY_NEXT_SHARES:
            endOfDayTradeSummaryNextShares.get(buffer);
            listener.endOfDayTradeSummaryNextShares(endOfDayTradeSummaryNextShares);
            break;
        case MESSAGE_TYPE_IPO_INFORMATION:
            ipoInformation.get(buffer);
            listener.ipoInformation(ipoInformation);
            break;
        case MESSAGE_TYPE_MWCB_DECLINE_LEVEL:
            mwcbDeclineLevel.get(buffer);
            listener.mwcbDeclineLevel(mwcbDeclineLevel);
            break;
        case MESSAGE_TYPE_MWCB_STATUS:
            mwcbStatus.get(buffer);
            listener.mwcbStatus(mwcbStatus);
            break;
        case MESSAGE_TYPE_IPO_QUOTING_PERIOD_UPDATE:
            ipoQuotingPeriodUpdate.get(buffer);
            listener.ipoQuotingPeriodUpdate(ipoQuotingPeriodUpdate);
            break;
        case MESSAGE_TYPE_OPERATIONAL_HALT:
            operationalHalt.get(buffer);
            listener.operationalHalt(operationalHalt);
            break;
        default:
            final char type = (char) messageType;
            System.err.println("nls plus,Unknown message type: " + type);
            // throw new NLS30Exception("Unknown message type: " + (char)messageType);
        }
    }

}
