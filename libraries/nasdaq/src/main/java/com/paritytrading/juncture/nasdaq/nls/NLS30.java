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
package com.paritytrading.juncture.nasdaq.nls;

import static com.paritytrading.foundation.ByteBuffers.getUnsignedInt;
import static com.paritytrading.foundation.ByteBuffers.getUnsignedShort;
import static com.paritytrading.foundation.ByteBuffers.putUnsignedInt;
import static com.paritytrading.foundation.ByteBuffers.putUnsignedShort;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.charset.StandardCharsets;

/**
 * Common definitions.
 */
public class NLS30 {

    private NLS30() {
    }

    public static final byte YES           = 'Y';
    public static final byte NO            = 'N';
    public static final byte NOT_AVAILABLE = ' ';

    public static final byte MESSAGE_TYPE_SYSTEM_EVENT                = 'S';
    public static final byte MESSAGE_TYPE_TRADE_REPORT_FOR_NON_NEXT_SHARES = 'T';
    public static final byte MESSAGE_TYPE_TRADE_REPORT_FOR_NEXT_SHARES = 'M';
    public static final byte MESSAGE_TYPE_TRADE_CANCEL_ERROR_FOR_NON_NEXT_SHARES = 'X';
    public static final byte MESSAGE_TYPE_TRADE_CANCEL_ERROR_FOR_NEXT_SHARES = 'O';
    public static final byte MESSAGE_TYPE_TRADE_CORRECTION_FOR_NON_NEXT_SHARES = 'C';
    public static final byte MESSAGE_TYPE_TRADE_CORRECTION_FOR_NEXT_SHARES = 'Z';
    public static final byte MESSAGE_TYPE_STOCK_TRADING_ACTION        = 'H';
    public static final byte MESSAGE_TYPE_STOCK_DIRECTORY             = 'R';
    public static final byte MESSAGE_TYPE_REG_SHO_RESTRICTION         = 'Y';
    public static final byte MESSAGE_TYPE_ADJUSTED_CLOSING_PRICE      = 'G';
    public static final byte MESSAGE_TYPE_END_OF_DAY_TRADE_SUMMARY    = 'J';
    public static final byte MESSAGE_TYPE_END_OF_DAY_TRADE_SUMMARY_NEXT_SHARES = 'N';
    public static final byte MESSAGE_TYPE_IPO_INFORMATION             = 'I';
    public static final byte MESSAGE_TYPE_MWCB_DECLINE_LEVEL          = 'V';
    public static final byte MESSAGE_TYPE_MWCB_STATUS                 = 'W';
    public static final byte MESSAGE_TYPE_IPO_QUOTING_PERIOD_UPDATE   = 'K';
    public static final byte MESSAGE_TYPE_OPERATIONAL_HALT            = 'h';

    /*
     * Event Code (5.1) values.
     */
    public static final byte EVENT_CODE_START_OF_MESSAGES     = 'O';
    public static final byte EVENT_CODE_START_OF_SYSTEM_HOURS = 'S';
    public static final byte EVENT_CODE_START_OF_MARKET_HOURS = 'Q';
    public static final byte EVENT_CODE_END_OF_MARKET_HOURS   = 'M';
    public static final byte EVENT_CODE_END_OF_SYSTEM_HOURS   = 'E';
    public static final byte EVENT_CODE_END_OF_MESSAGES       = 'C';

    /*
     * Market Code (5.2) values.
     */
    public static final byte MARKET_CODE_NASDAQ       = 'Q';
    public static final byte MARKET_CODE_TRF_CARTARET = 'L';
    public static final byte MARKET_CODE_TRF_CHICAGO  = '2';
    public static final byte MARKET_CODE_BX           = 'B';
    public static final byte MARKET_CODE_PSX          = 'X';

    /*
     * Security Class (5.2) values.
     */
    public static final byte SECURITY_CLASS_NASDAQ            = 'Q';
    public static final byte SECURITY_CLASS_NYSE              = 'N';
    public static final byte SECURITY_CLASS_NYSE_MKT          = 'A';
    public static final byte SECURITY_CLASS_NYSE_ARCA         = 'P';
    public static final byte SECURITY_CLASS_BATS              = 'Z';
    public static final byte SECURITY_CLASS_LLC               = 'V';

    /*
     * Sale Condition Modifier – Level 1 (5.2) values.
     */
    public static final byte SALE_CONDITION_MODIFIER_LEVEL1_REGULAR           = '@';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL1_CASH              = 'C';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL1_NEXT_DAY          = 'N';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL1_SELLER            = 'R';

    /*
     * Sale Condition Modifier – Level 2 (5.2) values.
     */
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_INTERMARKET_SWEEP          = 'F';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_OPENING_PRINT              = 'O';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_DERIVATIVE_PRICED          = '4';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_REOPENING_PRINT            = '5';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_CLOSING_PRINT              = '6';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_QCT                        = '7';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL2_NOT_APPLICABLE             = ' ';

    /*
     * Sale Condition Modifier – Level 3 (5.2) values.
     */
    public static final byte SALE_CONDITION_MODIFIER_LEVEL3_EXTENDED_HOURS_TRADE   = 'T';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL3_TRADE_OUT              = 'U';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL3_SOLD_LAST              = 'L';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL3_SOLD_OUT               = 'Z';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL3_NOT_APPLICABLE         = ' ';

    /*
     * Sale Condition Modifier – Level 4 (5.2) values.
     */
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_ACQUISITION          = 'A';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_BUNCHED              = 'B';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_DISTRIBUTION          = 'D';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_PRICE_VARIATION_TRANSACTION = 'H';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_NOCP              = 'M';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_PRIOR_REFERENCE_PRICE = 'P';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_NOOP              = 'Q';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_SPLIT_TRADE                = 'S';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_CONTINGENT_TRADE           = 'V';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_AVERAGE_PRICE_TRADE        = 'W';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_CROSS_TRADE                = 'X';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_ODD_LOT_EXECUTION          = 'o';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_ODD_LOT_CROSS_EXECUTION    = 'x';
    public static final byte SALE_CONDITION_MODIFIER_LEVEL4_NOT_APPLICABLE             = ' ';

    /*
     * Trading State (5.8.1) values.
     */
    public static final byte TRADING_STATE_HALTED           = 'H';
    public static final byte TRADING_STATE_PAUSED           = 'P';
    public static final byte TRADING_STATE_QUOTATION_PERIOD = 'Q';
    public static final byte TRADING_STATE_TRADING          = 'T';

    /*
     * Market Category (5.8.2) values.
     */
    public static final byte MARKET_CATEGORY_NASDAQ_GLOBAL_SELECT_MARKET = 'Q';
    public static final byte MARKET_CATEGORY_NASDAQ_GLOBAL_MARKET        = 'G';
    public static final byte MARKET_CATEGORY_NASDAQ_CAPITAL_MARKET       = 'S';
    public static final byte MARKET_CATEGORY_NYSE                        = 'N';
    public static final byte MARKET_CATEGORY_NYSE_MKT                    = 'A';
    public static final byte MARKET_CATEGORY_NYSE_ARCA                   = 'P';
    public static final byte MARKET_CATEGORY_BATS_Z_EXCHANGE             = 'Z';
    public static final byte MARKET_CATEGORY_LLC                         = 'V';
    public static final byte MARKET_CATEGORY_NOT_AVAILABLE               = ' ';

    /*
     * Financial Status Indicator (5.8.2) values.
     */
    public static final byte FINANCIAL_STATUS_INDICATOR_DEFICIENT                       = 'D';
    public static final byte FINANCIAL_STATUS_INDICATOR_DELINQUENT                      = 'E';
    public static final byte FINANCIAL_STATUS_INDICATOR_BANKRUPT                        = 'Q';
    public static final byte FINANCIAL_STATUS_INDICATOR_SUSPENDED                       = 'S';
    public static final byte FINANCIAL_STATUS_INDICATOR_DEFICIENT_BANKRUPT              = 'G';
    public static final byte FINANCIAL_STATUS_INDICATOR_DEFICIENT_DELINQUENT            = 'H';
    public static final byte FINANCIAL_STATUS_INDICATOR_DELINQUENT_BANKRUPT             = 'J';
    public static final byte FINANCIAL_STATUS_INDICATOR_DEFICIENT_DELINQUENT_BANKRUPT   = 'K';
    public static final byte FINANCIAL_STATUS_INDICATOR_CREATIONS_REDEMPTIONS_SUSPENDED = 'C';
    public static final byte FINANCIAL_STATUS_INDICATOR_NORMAL                          = 'N';
    public static final byte FINANCIAL_STATUS_INDICATOR_NOT_AVAILABLE                   = ' ';

    /*
     * Authenticity (5.8.2) values.
     */
    public static final byte AUTHENTICITY_PRODUCTION = 'P';
    public static final byte AUTHENTICTY_TEST        = 'T';

    /*
     * LULD Reference Price Tier (5.8.2) values.
     */
    public static final byte LULD_REFERENCE_PRICE_TIER_1 = '1';
    public static final byte LULD_REFERENCE_PRICE_TIER_2 = '2';

    /*
     * Reg SHO Action (5.8.3) values.
     */
    public static final byte REG_SHO_ACTION_NO_PRICE_TEST                              = '0';
    public static final byte REG_SHO_ACTION_SHORT_SALE_PRICE_TEST_INTRA_DAY_PRICE_DROP = '1';
    public static final byte REG_SHO_ACTION_SHORT_SALE_PRICE_TEST                      = '2';

    /*
     * Reference For Net Change (5.8.7) values.
     */
    public static final byte REFERENCE_FOR_NET_CHANGE_FIRST_TRADE_PRICE                = 'F';
    public static final byte REFERENCE_FOR_NET_CHANGE_UNDERWRITER_PRICE                = 'W';

    /*
     * Breached Level (5.5.7.2) values.
     */
    public static final byte BREACHED_LEVEL_1 = '1';
    public static final byte BREACHED_LEVEL_2 = '2';
    public static final byte BREACHED_LEVEL_3 = '3';

    /*
     * IPO Quotation Release Qualifier (5.8.9) values.
     */
    public static final byte IPO_QUOTATION_RELEASE_QUALIFIER_ANTICIPATED_QUOTATION_TIME     = 'A';
    public static final byte IPO_QUOTATION_RELEASE_QUALIFIER_IPO_RELEASE_CANCELED_POSTPONED = 'C';

    /*
     * Operational Halt Action (5.2.5) values.
     */
    public static final byte OPERATIONAL_HALT_ACTION_OPERATIONALLY_HALTED = 'H';
    public static final byte OPERATIONAL_HALT_ACTION_TRADING_RESUMED      = 'T';

    /**
     * A message.
     */
    public interface Message {

        /**
         * Read this message from the buffer.
         *
         * @param buffer a buffer
         * @throws BufferUnderflowException if there are fewer bytes remaining
         *   in the buffer than what this message consists of
         */
        void get(ByteBuffer buffer);

        /**
         * Write this message to the buffer.
         *
         * @param buffer a buffer
         * @throws BufferOverflowException if there are fewer bytes remaining
         *   in the buffer than what this message consists of
         * @throws ReadOnlyBufferException if the buffer is read-only
         */
        void put(ByteBuffer buffer);

        /**
         * Read 4 byte double
         *
         * @param buffer a buffer
         * @return double
         */
        default double readDouble4(ByteBuffer buffer) {
            return buffer.getInt() / 10000.0;
        }

        /**
         * Read 8 byte price
         *
         * @param buffer a buffer
         * @return price
         */
        default double readPrice8(ByteBuffer buffer) {
            return buffer.getLong() / 10000.0 / 1000;
        }

        /**
         * Read string
         *
         * @param buffer a buffer
         * @param length length
         * @return String
         */
        default String readString(ByteBuffer buffer, int length) {
            byte[] bytes = new byte[length];
            buffer.get(bytes);
            return new String(bytes, StandardCharsets.UTF_8).trim();
        }

        /**
         * Write double
         *
         * @param buffer a buffer
         * @param value  double value
         * @return Byte array
         */
        default void put(ByteBuffer buffer, double value) {
            buffer.putInt((int) (value * 10000));
        }

        /**
         * Write double
         *
         * @param buffer a buffer
         * @param value  double value
         * @return Byte array
         */
        default void putPrice8(ByteBuffer buffer, double value) {
            buffer.putLong((int) (value * 10000 * 1000));
        }

    }

    /**
     * A System Event (5.1) message.
     */
    public static class SystemEvent implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public char eventCode;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            eventCode      = (char) buffer.get();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_SYSTEM_EVENT);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) eventCode);
        }
    }

    /**
     * A Trade Report for Non-NextShares (5.2) message.
     */
    public static class TradeReportForNonNextShares implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public char  originatingMarketCenterIdentifier;
        public String issueSymbol;
        public char securityClass;
        public String tradeControlNumber;
        public double  tradePrice;
        public long tradeSize;
        public String saleConditionModifier;
        public char saleConditionModifierLevel1;
        public char saleConditionModifierLevel2;
        public char saleConditionModifierLevel3;
        public char saleConditionModifierLevel4;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            originatingMarketCenterIdentifier = (char) buffer.get();
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            tradeControlNumber = readString(buffer, 10);
            tradePrice = readDouble4(buffer);
            tradeSize = getUnsignedInt(buffer);
            saleConditionModifier = readString(buffer, 4);
            saleConditionModifierLevel1 = (char) buffer.get();
            saleConditionModifierLevel2 = (char) buffer.get();
            saleConditionModifierLevel3 = (char) buffer.get();
            saleConditionModifierLevel4 = (char) buffer.get();
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) originatingMarketCenterIdentifier);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put(tradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, tradePrice);
            putUnsignedInt(buffer, tradeSize);
            buffer.put(saleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) saleConditionModifierLevel1);
            buffer.put((byte) saleConditionModifierLevel2);
            buffer.put((byte) saleConditionModifierLevel3);
            buffer.put((byte) saleConditionModifierLevel4);
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A Trade Report for NextShares (5.3) message.
     */
    public static class TradeReportForNextShares implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public char  originatingMarketCenterIdentifier;
        public String nextSharesSymbol;
        public char securityClass;
        public String tradeControlNumber;
        public double proxyPrice;
        public long tradeSize;
        public double navOffsetAmount;
        public String saleConditionModifier;
        public char saleConditionModifierLevel1;
        public char saleConditionModifierLevel2;
        public char saleConditionModifierLevel3;
        public char saleConditionModifierLevel4;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            originatingMarketCenterIdentifier = (char) buffer.get();
            nextSharesSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            tradeControlNumber = readString(buffer, 10);
            proxyPrice = readDouble4(buffer);
            tradeSize = getUnsignedInt(buffer);
            navOffsetAmount = readDouble4(buffer);
            saleConditionModifier = readString(buffer, 4);
            saleConditionModifierLevel1 = (char) buffer.get();
            saleConditionModifierLevel2 = (char) buffer.get();
            saleConditionModifierLevel3 = (char) buffer.get();
            saleConditionModifierLevel4 = (char) buffer.get();
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) originatingMarketCenterIdentifier);
            buffer.put(nextSharesSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put(tradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, proxyPrice);
            putUnsignedInt(buffer, tradeSize);
            put(buffer, navOffsetAmount);
            buffer.put(saleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) saleConditionModifierLevel1);
            buffer.put((byte) saleConditionModifierLevel2);
            buffer.put((byte) saleConditionModifierLevel3);
            buffer.put((byte) saleConditionModifierLevel4);
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A Trade Cancel/Error for Non-NextShares (5.4) message.
     */
    public static class TradeCancelErrorForNonNextShares implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public char  originatingMarketCenterIdentifier;
        public String issueSymbol;
        public char securityClass;
        public String originalTradeControlNumber;
        public double originalTradePrice;
        public long originalTradeSize;
        public String originalSaleConditionModifier;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            originatingMarketCenterIdentifier = (char) buffer.get();
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            originalTradeControlNumber = readString(buffer, 10);
            originalTradePrice = readDouble4(buffer);
            originalTradeSize = getUnsignedInt(buffer);
            originalSaleConditionModifier = readString(buffer, 4);
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) originatingMarketCenterIdentifier);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put(originalTradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, originalTradePrice);
            putUnsignedInt(buffer, originalTradeSize);
            buffer.put(originalSaleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A Trade Cancel/Error for NextShares (5.5) message.
     */
    public static class TradeCancelErrorForNextShares implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public char marketCenterIdentifier;
        public String issueSymbol;
        public char securityClass;
        public String originalTradeControlNumber;
        public double originalProxyPrice;
        public double originalNavOffsetAmount;
        public long originalTradeSize;
        public String originalSaleConditionModifier;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            marketCenterIdentifier = (char) buffer.get();
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            originalTradeControlNumber = readString(buffer, 10);
            originalProxyPrice = readDouble4(buffer);
            originalNavOffsetAmount = readDouble4(buffer);
            originalTradeSize = getUnsignedInt(buffer);
            originalSaleConditionModifier = readString(buffer, 4);
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) marketCenterIdentifier);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put(originalTradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, originalProxyPrice);
            put(buffer, originalNavOffsetAmount);
            putUnsignedInt(buffer, originalTradeSize);
            buffer.put(originalSaleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A Trade Correction for Non-NextShares (5.6) message.
     */
    public static class TradeCorrectionForNonNextShares implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public char  originatingMarketCenterIdentifier;
        public String issueSymbol;
        public char securityClass;
        public String originalTradeControlNumber;
        public double originalTradePrice;
        public long originalTradeSize;
        public String originalSaleConditionModifier;
        public String correctionTradeControlNumber;
        public double correctionTradePrice;
        public long correctionTradeSize;
        public String correctionSaleConditionModifier;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            originatingMarketCenterIdentifier = (char) buffer.get();
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            originalTradeControlNumber = readString(buffer, 10);
            originalTradePrice = readDouble4(buffer);
            originalTradeSize = getUnsignedInt(buffer);
            originalSaleConditionModifier = readString(buffer, 4);
            correctionTradeControlNumber = readString(buffer, 10);
            correctionTradePrice = readDouble4(buffer);
            correctionTradeSize = getUnsignedInt(buffer);
            correctionSaleConditionModifier = readString(buffer, 4);
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) originatingMarketCenterIdentifier);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put(originalTradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, originalTradePrice);
            putUnsignedInt(buffer, originalTradeSize);
            buffer.put(originalSaleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.put(correctionTradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, correctionTradePrice);
            putUnsignedInt(buffer, correctionTradeSize);
            buffer.put(correctionSaleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A Trade Correction for NextShares (5.7) message.
     */
    public static class TradeCorrectionForNextShares implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public char marketCenterIdentifier;
        public String issueSymbol;
        public char securityClass;
        public String originalTradeControlNumber;
        public double originalProxyPrice;
        public double originalNavOffsetAmount;
        public long originalTradeSize;
        public String originalSaleConditionModifier;
        public String correctionTradeControlNumber;
        public double correctionProxyPrice;
        public double correctionNavOffsetAmount;
        public long correctionTradeSize;
        public String correctionSaleConditionModifier;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            marketCenterIdentifier = (char) buffer.get();
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            originalTradeControlNumber = readString(buffer, 10);
            originalProxyPrice = readDouble4(buffer);
            originalNavOffsetAmount = readDouble4(buffer);
            originalTradeSize = getUnsignedInt(buffer);
            originalSaleConditionModifier = readString(buffer, 4);
            correctionTradeControlNumber = readString(buffer, 10);
            correctionProxyPrice = readDouble4(buffer);
            correctionNavOffsetAmount = readDouble4(buffer);
            correctionTradeSize = getUnsignedInt(buffer);
            correctionSaleConditionModifier = readString(buffer, 4);
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) marketCenterIdentifier);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put(originalTradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, originalProxyPrice);
            put(buffer, originalNavOffsetAmount);
            putUnsignedInt(buffer, originalTradeSize);
            buffer.put(originalSaleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.put(correctionTradeControlNumber.getBytes(StandardCharsets.UTF_8));
            put(buffer, correctionProxyPrice);
            put(buffer, correctionNavOffsetAmount);
            putUnsignedInt(buffer, correctionTradeSize);
            buffer.put(correctionSaleConditionModifier.getBytes(StandardCharsets.UTF_8));
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A Stock Trading Action (5.8.1) message.
     */
    public static class StockTradingAction implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public char reserved;
        public String issueSymbol;
        public char securityClass;
        public char currentTradingState;
        public String  reason;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            reserved  = (char) buffer.get();
            issueSymbol = readString(buffer, 8);
            securityClass  = (char) buffer.get();
            currentTradingState = (char) buffer.get();
            reason         = readString(buffer, 4);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_TRADING_ACTION);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put((byte) currentTradingState);
            buffer.put(reason.getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * A Stock Directory (5.8.2) message.
     */
    public static class StockDirectory implements Message {
        public int   trackingNumber;
        public int   timestampHigh;
        public long  timestampLow;
        public String stock;
        public char  marketCategory;
        public char  financialStatusIndicator;
        public long  roundLotSize;
        public char  roundLotsOnly;
        public char  issueClassification;
        public String issueSubType;
        public char  authenticity;
        public char  shortSaleThresholdIndicator;
        public char  ipoFlag;
        public char  luldReferencePriceTier;
        public char  etpFlag;
        public long  etpLeverageFactor;
        public char  inverseIndicator;
        public String bloombergID;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber              = getUnsignedShort(buffer);
            timestampHigh               = getUnsignedShort(buffer);
            timestampLow                = getUnsignedInt(buffer);
            stock                       = readString(buffer, 8);
            marketCategory              = (char) buffer.get();
            financialStatusIndicator    = (char) buffer.get();
            roundLotSize                = getUnsignedInt(buffer);
            roundLotsOnly               = (char) buffer.get();
            issueClassification         = (char) buffer.get();
            issueSubType                = readString(buffer, 2);
            authenticity                = (char) buffer.get();
            shortSaleThresholdIndicator = (char) buffer.get();
            ipoFlag                     = (char) buffer.get();
            luldReferencePriceTier      = (char) buffer.get();
            etpFlag                     = (char) buffer.get();
            etpLeverageFactor           = getUnsignedInt(buffer);
            inverseIndicator            = (char) buffer.get();
            bloombergID                 = readString(buffer, 12);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_STOCK_DIRECTORY);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(stock.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) marketCategory);
            buffer.put((byte) financialStatusIndicator);
            putUnsignedInt(buffer, roundLotSize);
            buffer.put((byte) roundLotsOnly);
            buffer.put((byte) issueClassification);
            buffer.put(issueSubType.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) authenticity);
            buffer.put((byte) shortSaleThresholdIndicator);
            buffer.put((byte) ipoFlag);
            buffer.put((byte) luldReferencePriceTier);
            buffer.put((byte) etpFlag);
            putUnsignedInt(buffer, etpLeverageFactor);
            buffer.put((byte) inverseIndicator);
            buffer.put(bloombergID.getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * A Reg SHO Restriction (5.8.3) message.
     */
    public static class RegSHORestriction implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String issueSymbol;
        public char regSHOAction;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            issueSymbol = readString(buffer, 8);
            regSHOAction   = (char) buffer.get();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_REG_SHO_RESTRICTION);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) regSHOAction);
        }
    }

    /**
     * A Adjusted Closing Price (5.8.4) message.
     */
    public static class AdjustedClosingPrice implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String issueSymbol;
        public char securityClass;
        public double adjustedClosingPrice;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            adjustedClosingPrice = readDouble4(buffer);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_REG_SHO_RESTRICTION);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            put(buffer, adjustedClosingPrice);
        }
    }

    /**
     * A End of Day Trade Summary (5.8.5) message.
     */
    public static class EndOfDayTradeSummary implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String issueSymbol;
        public char marketCategory;
        public double nasdaqHighPrice;
        public double nasdaqLowPrice;
        public double nasdaqClosingPrice;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            issueSymbol = readString(buffer, 8);
            marketCategory = (char) buffer.get();
            nasdaqHighPrice = readDouble4(buffer);
            nasdaqLowPrice = readDouble4(buffer);
            nasdaqClosingPrice = readDouble4(buffer);
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_REG_SHO_RESTRICTION);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) marketCategory);
            put(buffer, nasdaqHighPrice);
            put(buffer, nasdaqLowPrice);
            put(buffer, nasdaqClosingPrice);
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * A End of Day Trade Summary - NextShares (5.8.6) message.
     */
    public static class EndOfDayTradeSummaryNextShares implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String issueSymbol;
        public char marketCategory;
        public double nasdaqHighPrice;
        public double navOffsetAmountHigh;
        public double nasdaqLowPrice;
        public double navOffsetAmountLow;
        public double nasdaqClosingPrice;
        public double navOffsetAmountClose;
        public long consolidatedVolume;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            issueSymbol = readString(buffer, 8);
            marketCategory = (char) buffer.get();
            nasdaqHighPrice = readDouble4(buffer);
            navOffsetAmountHigh = readDouble4(buffer);
            nasdaqLowPrice = readDouble4(buffer);
            navOffsetAmountLow = readDouble4(buffer);
            nasdaqClosingPrice = readDouble4(buffer);
            navOffsetAmountClose = readDouble4(buffer);
            consolidatedVolume = buffer.getLong();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_REG_SHO_RESTRICTION);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) marketCategory);
            put(buffer, nasdaqHighPrice);
            put(buffer, navOffsetAmountHigh);
            put(buffer, nasdaqLowPrice);
            put(buffer, navOffsetAmountLow);
            put(buffer, nasdaqClosingPrice);
            put(buffer, navOffsetAmountClose);
            buffer.putLong(consolidatedVolume);
        }
    }

    /**
     * An IPO Information (5.8.7) message.
     */
    public static class IPOInformation implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String issueSymbol;
        public char securityClass;
        public char referenceForNetChange;
        public double referencePrice;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber               = getUnsignedShort(buffer);
            timestampHigh                = getUnsignedShort(buffer);
            timestampLow                 = getUnsignedInt(buffer);
            issueSymbol = readString(buffer, 8);
            securityClass = (char) buffer.get();
            referenceForNetChange = (char) buffer.get();
            referencePrice = readDouble4(buffer);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_IPO_QUOTING_PERIOD_UPDATE);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(issueSymbol.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) securityClass);
            buffer.put((byte) referenceForNetChange);
            put(buffer, referencePrice);
        }
    }

    /**
     * An MWCB Decline Level (5.5.7.1) message.
     */
    public static class MWCBDeclineLevel implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public double level1;
        public double level2;
        public double level3;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            level1         = readPrice8(buffer);
            level2         = readPrice8(buffer);
            level3         = readPrice8(buffer);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_MWCB_DECLINE_LEVEL);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            putPrice8(buffer, level1);
            putPrice8(buffer, level2);
            putPrice8(buffer, level3);
        }
    }

    /**
     * An MWCB Status (5.5.7.2) message.
     */
    public static class MWCBStatus implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public char breachedLevel;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber = getUnsignedShort(buffer);
            timestampHigh  = getUnsignedShort(buffer);
            timestampLow   = getUnsignedInt(buffer);
            breachedLevel  = (char) buffer.get();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_MWCB_STATUS);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put((byte) breachedLevel);
        }
    }

    /**
     * An IPO Quoting Period Update (5.8.9) message.
     */
    public static class IPOQuotingPeriodUpdate implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String stock;
        public long ipoQuotationReleaseTime;
        public char ipoQuotationReleaseQualifier;
        public double ipoPrice;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber               = getUnsignedShort(buffer);
            timestampHigh                = getUnsignedShort(buffer);
            timestampLow                 = getUnsignedInt(buffer);
            stock                        = readString(buffer, 8);
            ipoQuotationReleaseTime      = getUnsignedInt(buffer);
            ipoQuotationReleaseQualifier = (char) buffer.get();
            ipoPrice                     = readDouble4(buffer);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_IPO_QUOTING_PERIOD_UPDATE);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(stock.getBytes(StandardCharsets.UTF_8));
            putUnsignedInt(buffer, ipoQuotationReleaseTime);
            buffer.put((byte) ipoQuotationReleaseQualifier);
            put(buffer, ipoPrice);
        }
    }

    /**
     * An Operational Halt (5.8.10) message.
     */
    public static class OperationalHalt implements Message {
        public int  trackingNumber;
        public int  timestampHigh;
        public long timestampLow;
        public String stock;
        public char marketCode;
        public char operationalHaltAction;

        @Override
        public void get(ByteBuffer buffer) {
            trackingNumber        = getUnsignedShort(buffer);
            timestampHigh         = getUnsignedShort(buffer);
            timestampLow          = getUnsignedInt(buffer);
            stock                 = readString(buffer, 8);
            marketCode            = (char) buffer.get();
            operationalHaltAction = (char) buffer.get();
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(MESSAGE_TYPE_OPERATIONAL_HALT);
            putUnsignedShort(buffer, trackingNumber);
            putUnsignedShort(buffer, timestampHigh);
            putUnsignedInt(buffer, timestampLow);
            buffer.put(stock.getBytes(StandardCharsets.UTF_8));
            buffer.put((byte) marketCode);
            buffer.put((byte) operationalHaltAction);
        }
    }

}
