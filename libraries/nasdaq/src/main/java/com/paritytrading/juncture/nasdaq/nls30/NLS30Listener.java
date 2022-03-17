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

import java.io.IOException;

/**
 * The interface for inbound messages.
 *
 * @author javalover123
 */
public interface NLS30Listener {

    /**
     * Receive a System Event message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void systemEvent(SystemEvent message) throws IOException;

    /**
     * Receive a Trade Report for Non-NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void tradeReportForNonNextShares(TradeReportForNonNextShares message) throws IOException;

    /**
     * Receive a Trade Report for NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void tradeReportForNextShares(TradeReportForNextShares message) throws IOException;

    /**
     * Receive a Trade Cancel/Error for Non-NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void tradeCancelErrorForNonNextShares(TradeCancelErrorForNonNextShares message) throws IOException;

    /**
     * Receive a Trade Cancel/Error for NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void tradeCancelErrorForNextShares(TradeCancelErrorForNextShares message) throws IOException;

    /**
     * Receive a Trade Correction for Non-NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void tradeCorrectionForNonNextShares(TradeCorrectionForNonNextShares message) throws IOException;

    /**
     * Receive a Trade Correction for NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void tradeCorrectionForNextShares(TradeCorrectionForNextShares message) throws IOException;

    /**
     * Receive a Stock Trading Action message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void stockTradingAction(StockTradingAction message) throws IOException;

    /**
     * Receive a Stock Directory message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void stockDirectory(StockDirectory message) throws IOException;

    /**
     * Receive a Reg SHO Restriction message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void regSHORestriction(RegSHORestriction message) throws IOException;

    /**
     * Receive a Adjusted Closing Price message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void adjustedClosingPrice(AdjustedClosingPrice message) throws IOException;

    /**
     * Receive a End of Day Trade Summary message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void endOfDayTradeSummary(EndOfDayTradeSummary message) throws IOException;

    /**
     * Receive a End of Day Trade Summary - NextShares message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void endOfDayTradeSummaryNextShares(EndOfDayTradeSummaryNextShares message) throws IOException;

    /**
     * Receive an IPO Information message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void ipoInformation(IPOInformation message) throws IOException;

    /**
     * Receive an MWCB Decline Level message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void mwcbDeclineLevel(MWCBDeclineLevel message) throws IOException;

    /**
     * Receive an MWCB Status message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void mwcbStatus(MWCBStatus message) throws IOException;

    /**
     * Receive an IPO Quoting Period Update message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void ipoQuotingPeriodUpdate(IPOQuotingPeriodUpdate message) throws IOException;

    /**
     * Receive an Operational Halt message.
     *
     * @param message the message
     * @throws IOException if an I/O error occurs
     */
    void operationalHalt(OperationalHalt message) throws IOException;

}
