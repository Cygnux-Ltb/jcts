/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package io.horizon.trader.transport.avro.inbound;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

import java.io.Serial;

/**
 * 查询订单
 */
@org.apache.avro.specific.AvroGenerated
public class TdxQueryOrder extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    @Serial
    private static final long serialVersionUID = -4160127631853341693L;


    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TdxQueryOrder\",\"namespace\":\"io.horizon.trader.transport.avro.inbound\",\"doc\":\"查询订单\",\"fields\":[{\"name\":\"generateTime\",\"type\":\"long\",\"default\":0},{\"name\":\"sendTime\",\"type\":\"long\",\"default\":0},{\"name\":\"ordSysId\",\"type\":\"long\"},{\"name\":\"exchangeCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"instrumentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"brokerId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"accountId\",\"type\":\"int\"},{\"name\":\"subAccountId\",\"type\":\"int\"},{\"name\":\"strategyId\",\"type\":\"int\"},{\"name\":\"operatorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"\"}]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    private static final SpecificData MODEL$ = new SpecificData();

    private static final BinaryMessageEncoder<TdxQueryOrder> ENCODER =
            new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<TdxQueryOrder> DECODER =
            new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

    /**
     * Return the BinaryMessageEncoder instance used by this class.
     *
     * @return the message encoder used by this class
     */
    public static BinaryMessageEncoder<TdxQueryOrder> getEncoder() {
        return ENCODER;
    }

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     *
     * @return the message decoder used by this class
     */
    public static BinaryMessageDecoder<TdxQueryOrder> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     *
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
     */
    public static BinaryMessageDecoder<TdxQueryOrder> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
    }

    /**
     * Serializes this TdxQueryOrder to a ByteBuffer.
     *
     * @return a buffer holding the serialized data for this instance
     * @throws java.io.IOException if this instance could not be serialized
     */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    /**
     * Deserializes a TdxQueryOrder from a ByteBuffer.
     *
     * @param b a byte buffer holding serialized data for an instance of this class
     * @return a TdxQueryOrder instance decoded from the given buffer
     * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
     */
    public static TdxQueryOrder fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    private long generateTime;
    private long sendTime;
    private long ordSysId;
    private java.lang.String exchangeCode;
    private java.lang.String instrumentCode;
    private java.lang.String brokerId;
    private int accountId;
    private int subAccountId;
    private int strategyId;
    private java.lang.String operatorId;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public TdxQueryOrder() {
    }

    /**
     * All-args constructor.
     *
     * @param generateTime   The new value for generateTime
     * @param sendTime       The new value for sendTime
     * @param ordSysId       The new value for ordSysId
     * @param exchangeCode   The new value for exchangeCode
     * @param instrumentCode The new value for instrumentCode
     * @param brokerId       The new value for brokerId
     * @param accountId      The new value for accountId
     * @param subAccountId   The new value for subAccountId
     * @param strategyId     The new value for strategyId
     * @param operatorId     The new value for operatorId
     */
    public TdxQueryOrder(java.lang.Long generateTime, java.lang.Long sendTime, java.lang.Long ordSysId, java.lang.String exchangeCode, java.lang.String instrumentCode, java.lang.String brokerId, java.lang.Integer accountId, java.lang.Integer subAccountId, java.lang.Integer strategyId, java.lang.String operatorId) {
        this.generateTime = generateTime;
        this.sendTime = sendTime;
        this.ordSysId = ordSysId;
        this.exchangeCode = exchangeCode;
        this.instrumentCode = instrumentCode;
        this.brokerId = brokerId;
        this.accountId = accountId;
        this.subAccountId = subAccountId;
        this.strategyId = strategyId;
        this.operatorId = operatorId;
    }

    public org.apache.avro.specific.SpecificData getSpecificData() {
        return MODEL$;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        return switch (field$) {
            case 0 -> generateTime;
            case 1 -> sendTime;
            case 2 -> ordSysId;
            case 3 -> exchangeCode;
            case 4 -> instrumentCode;
            case 5 -> brokerId;
            case 6 -> accountId;
            case 7 -> subAccountId;
            case 8 -> strategyId;
            case 9 -> operatorId;
            default -> throw new IndexOutOfBoundsException("Invalid index: " + field$);
        };
    }

    // Used by DatumReader.  Applications should not call.
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0 -> generateTime = (Long) value$;
            case 1 -> sendTime = (Long) value$;
            case 2 -> ordSysId = (Long) value$;
            case 3 -> exchangeCode = value$ != null ? value$.toString() : null;
            case 4 -> instrumentCode = value$ != null ? value$.toString() : null;
            case 5 -> brokerId = value$ != null ? value$.toString() : null;
            case 6 -> accountId = (Integer) value$;
            case 7 -> subAccountId = (Integer) value$;
            case 8 -> strategyId = (Integer) value$;
            case 9 -> operatorId = value$ != null ? value$.toString() : null;
            default -> throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    /**
     * Gets the value of the 'generateTime' field.
     *
     * @return The value of the 'generateTime' field.
     */
    public long getGenerateTime() {
        return generateTime;
    }


    /**
     * Sets the value of the 'generateTime' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setGenerateTime(long value) {
        this.generateTime = value;
        return this;
    }

    /**
     * Gets the value of the 'sendTime' field.
     *
     * @return The value of the 'sendTime' field.
     */
    public long getSendTime() {
        return sendTime;
    }


    /**
     * Sets the value of the 'sendTime' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setSendTime(long value) {
        this.sendTime = value;
        return this;
    }

    /**
     * Gets the value of the 'ordSysId' field.
     *
     * @return The value of the 'ordSysId' field.
     */
    public long getOrdSysId() {
        return ordSysId;
    }


    /**
     * Sets the value of the 'ordSysId' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setOrdSysId(long value) {
        this.ordSysId = value;
        return this;
    }

    /**
     * Gets the value of the 'exchangeCode' field.
     *
     * @return The value of the 'exchangeCode' field.
     */
    public java.lang.String getExchangeCode() {
        return exchangeCode;
    }


    /**
     * Sets the value of the 'exchangeCode' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setExchangeCode(java.lang.String value) {
        this.exchangeCode = value;
        return this;
    }

    /**
     * Gets the value of the 'instrumentCode' field.
     *
     * @return The value of the 'instrumentCode' field.
     */
    public java.lang.String getInstrumentCode() {
        return instrumentCode;
    }


    /**
     * Sets the value of the 'instrumentCode' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setInstrumentCode(java.lang.String value) {
        this.instrumentCode = value;
        return this;
    }

    /**
     * Gets the value of the 'brokerId' field.
     *
     * @return The value of the 'brokerId' field.
     */
    public java.lang.String getBrokerId() {
        return brokerId;
    }


    /**
     * Sets the value of the 'brokerId' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setBrokerId(java.lang.String value) {
        this.brokerId = value;
        return this;
    }

    /**
     * Gets the value of the 'accountId' field.
     *
     * @return The value of the 'accountId' field.
     */
    public int getAccountId() {
        return accountId;
    }


    /**
     * Sets the value of the 'accountId' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setAccountId(int value) {
        this.accountId = value;
        return this;
    }

    /**
     * Gets the value of the 'subAccountId' field.
     *
     * @return The value of the 'subAccountId' field.
     */
    public int getSubAccountId() {
        return subAccountId;
    }


    /**
     * Sets the value of the 'subAccountId' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setSubAccountId(int value) {
        this.subAccountId = value;
        return this;
    }

    /**
     * Gets the value of the 'strategyId' field.
     *
     * @return The value of the 'strategyId' field.
     */
    public int getStrategyId() {
        return strategyId;
    }


    /**
     * Sets the value of the 'strategyId' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setStrategyId(int value) {
        this.strategyId = value;
        return this;
    }

    /**
     * Gets the value of the 'operatorId' field.
     *
     * @return The value of the 'operatorId' field.
     */
    public java.lang.String getOperatorId() {
        return operatorId;
    }


    /**
     * Sets the value of the 'operatorId' field.
     *
     * @param value the value to set.
     */
    public TdxQueryOrder setOperatorId(java.lang.String value) {
        this.operatorId = value;
        return this;
    }

    /**
     * Creates a new TdxQueryOrder RecordBuilder.
     *
     * @return A new TdxQueryOrder RecordBuilder
     */
    public static io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder newBuilder() {
        return new io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder();
    }

    /**
     * Creates a new TdxQueryOrder RecordBuilder by copying an existing Builder.
     *
     * @param other The existing builder to copy.
     * @return A new TdxQueryOrder RecordBuilder
     */
    public static io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder newBuilder(io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder other) {
        if (other == null) {
            return new io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder();
        } else {
            return new io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder(other);
        }
    }

    /**
     * Creates a new TdxQueryOrder RecordBuilder by copying an existing TdxQueryOrder instance.
     *
     * @param other The existing instance to copy.
     * @return A new TdxQueryOrder RecordBuilder
     */
    public static io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder newBuilder(io.horizon.trader.transport.avro.inbound.TdxQueryOrder other) {
        if (other == null) {
            return new io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder();
        } else {
            return new io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder(other);
        }
    }

    /**
     * RecordBuilder for TdxQueryOrder instances.
     */
    @org.apache.avro.specific.AvroGenerated
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TdxQueryOrder>
            implements org.apache.avro.data.RecordBuilder<TdxQueryOrder> {

        private long generateTime;
        private long sendTime;
        private long ordSysId;
        private java.lang.String exchangeCode;
        private java.lang.String instrumentCode;
        private java.lang.String brokerId;
        private int accountId;
        private int subAccountId;
        private int strategyId;
        private java.lang.String operatorId;

        /**
         * Creates a new Builder
         */
        private Builder() {
            super(SCHEMA$, MODEL$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         *
         * @param other The existing Builder to copy.
         */
        private Builder(io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.generateTime)) {
                this.generateTime = data().deepCopy(fields()[0].schema(), other.generateTime);
                fieldSetFlags()[0] = other.fieldSetFlags()[0];
            }
            if (isValidValue(fields()[1], other.sendTime)) {
                this.sendTime = data().deepCopy(fields()[1].schema(), other.sendTime);
                fieldSetFlags()[1] = other.fieldSetFlags()[1];
            }
            if (isValidValue(fields()[2], other.ordSysId)) {
                this.ordSysId = data().deepCopy(fields()[2].schema(), other.ordSysId);
                fieldSetFlags()[2] = other.fieldSetFlags()[2];
            }
            if (isValidValue(fields()[3], other.exchangeCode)) {
                this.exchangeCode = data().deepCopy(fields()[3].schema(), other.exchangeCode);
                fieldSetFlags()[3] = other.fieldSetFlags()[3];
            }
            if (isValidValue(fields()[4], other.instrumentCode)) {
                this.instrumentCode = data().deepCopy(fields()[4].schema(), other.instrumentCode);
                fieldSetFlags()[4] = other.fieldSetFlags()[4];
            }
            if (isValidValue(fields()[5], other.brokerId)) {
                this.brokerId = data().deepCopy(fields()[5].schema(), other.brokerId);
                fieldSetFlags()[5] = other.fieldSetFlags()[5];
            }
            if (isValidValue(fields()[6], other.accountId)) {
                this.accountId = data().deepCopy(fields()[6].schema(), other.accountId);
                fieldSetFlags()[6] = other.fieldSetFlags()[6];
            }
            if (isValidValue(fields()[7], other.subAccountId)) {
                this.subAccountId = data().deepCopy(fields()[7].schema(), other.subAccountId);
                fieldSetFlags()[7] = other.fieldSetFlags()[7];
            }
            if (isValidValue(fields()[8], other.strategyId)) {
                this.strategyId = data().deepCopy(fields()[8].schema(), other.strategyId);
                fieldSetFlags()[8] = other.fieldSetFlags()[8];
            }
            if (isValidValue(fields()[9], other.operatorId)) {
                this.operatorId = data().deepCopy(fields()[9].schema(), other.operatorId);
                fieldSetFlags()[9] = other.fieldSetFlags()[9];
            }
        }

        /**
         * Creates a Builder by copying an existing TdxQueryOrder instance
         *
         * @param other The existing instance to copy.
         */
        private Builder(io.horizon.trader.transport.avro.inbound.TdxQueryOrder other) {
            super(SCHEMA$, MODEL$);
            if (isValidValue(fields()[0], other.generateTime)) {
                this.generateTime = data().deepCopy(fields()[0].schema(), other.generateTime);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.sendTime)) {
                this.sendTime = data().deepCopy(fields()[1].schema(), other.sendTime);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.ordSysId)) {
                this.ordSysId = data().deepCopy(fields()[2].schema(), other.ordSysId);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.exchangeCode)) {
                this.exchangeCode = data().deepCopy(fields()[3].schema(), other.exchangeCode);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.instrumentCode)) {
                this.instrumentCode = data().deepCopy(fields()[4].schema(), other.instrumentCode);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.brokerId)) {
                this.brokerId = data().deepCopy(fields()[5].schema(), other.brokerId);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.accountId)) {
                this.accountId = data().deepCopy(fields()[6].schema(), other.accountId);
                fieldSetFlags()[6] = true;
            }
            if (isValidValue(fields()[7], other.subAccountId)) {
                this.subAccountId = data().deepCopy(fields()[7].schema(), other.subAccountId);
                fieldSetFlags()[7] = true;
            }
            if (isValidValue(fields()[8], other.strategyId)) {
                this.strategyId = data().deepCopy(fields()[8].schema(), other.strategyId);
                fieldSetFlags()[8] = true;
            }
            if (isValidValue(fields()[9], other.operatorId)) {
                this.operatorId = data().deepCopy(fields()[9].schema(), other.operatorId);
                fieldSetFlags()[9] = true;
            }
        }

        /**
         * Gets the value of the 'generateTime' field.
         *
         * @return The value.
         */
        public long getGenerateTime() {
            return generateTime;
        }


        /**
         * Sets the value of the 'generateTime' field.
         *
         * @param value The value of 'generateTime'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setGenerateTime(long value) {
            validate(fields()[0], value);
            this.generateTime = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'generateTime' field has been set.
         *
         * @return True if the 'generateTime' field has been set, false otherwise.
         */
        public boolean hasGenerateTime() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'generateTime' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearGenerateTime() {
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'sendTime' field.
         *
         * @return The value.
         */
        public long getSendTime() {
            return sendTime;
        }


        /**
         * Sets the value of the 'sendTime' field.
         *
         * @param value The value of 'sendTime'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setSendTime(long value) {
            validate(fields()[1], value);
            this.sendTime = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'sendTime' field has been set.
         *
         * @return True if the 'sendTime' field has been set, false otherwise.
         */
        public boolean hasSendTime() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'sendTime' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearSendTime() {
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'ordSysId' field.
         *
         * @return The value.
         */
        public long getOrdSysId() {
            return ordSysId;
        }


        /**
         * Sets the value of the 'ordSysId' field.
         *
         * @param value The value of 'ordSysId'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setOrdSysId(long value) {
            validate(fields()[2], value);
            this.ordSysId = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'ordSysId' field has been set.
         *
         * @return True if the 'ordSysId' field has been set, false otherwise.
         */
        public boolean hasOrdSysId() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'ordSysId' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearOrdSysId() {
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'exchangeCode' field.
         *
         * @return The value.
         */
        public java.lang.String getExchangeCode() {
            return exchangeCode;
        }


        /**
         * Sets the value of the 'exchangeCode' field.
         *
         * @param value The value of 'exchangeCode'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setExchangeCode(java.lang.String value) {
            validate(fields()[3], value);
            this.exchangeCode = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'exchangeCode' field has been set.
         *
         * @return True if the 'exchangeCode' field has been set, false otherwise.
         */
        public boolean hasExchangeCode() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'exchangeCode' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearExchangeCode() {
            exchangeCode = null;
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'instrumentCode' field.
         *
         * @return The value.
         */
        public java.lang.String getInstrumentCode() {
            return instrumentCode;
        }


        /**
         * Sets the value of the 'instrumentCode' field.
         *
         * @param value The value of 'instrumentCode'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setInstrumentCode(java.lang.String value) {
            validate(fields()[4], value);
            this.instrumentCode = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'instrumentCode' field has been set.
         *
         * @return True if the 'instrumentCode' field has been set, false otherwise.
         */
        public boolean hasInstrumentCode() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'instrumentCode' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearInstrumentCode() {
            instrumentCode = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'brokerId' field.
         *
         * @return The value.
         */
        public java.lang.String getBrokerId() {
            return brokerId;
        }


        /**
         * Sets the value of the 'brokerId' field.
         *
         * @param value The value of 'brokerId'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setBrokerId(java.lang.String value) {
            validate(fields()[5], value);
            this.brokerId = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'brokerId' field has been set.
         *
         * @return True if the 'brokerId' field has been set, false otherwise.
         */
        public boolean hasBrokerId() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'brokerId' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearBrokerId() {
            brokerId = null;
            fieldSetFlags()[5] = false;
            return this;
        }

        /**
         * Gets the value of the 'accountId' field.
         *
         * @return The value.
         */
        public int getAccountId() {
            return accountId;
        }


        /**
         * Sets the value of the 'accountId' field.
         *
         * @param value The value of 'accountId'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setAccountId(int value) {
            validate(fields()[6], value);
            this.accountId = value;
            fieldSetFlags()[6] = true;
            return this;
        }

        /**
         * Checks whether the 'accountId' field has been set.
         *
         * @return True if the 'accountId' field has been set, false otherwise.
         */
        public boolean hasAccountId() {
            return fieldSetFlags()[6];
        }


        /**
         * Clears the value of the 'accountId' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearAccountId() {
            fieldSetFlags()[6] = false;
            return this;
        }

        /**
         * Gets the value of the 'subAccountId' field.
         *
         * @return The value.
         */
        public int getSubAccountId() {
            return subAccountId;
        }


        /**
         * Sets the value of the 'subAccountId' field.
         *
         * @param value The value of 'subAccountId'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setSubAccountId(int value) {
            validate(fields()[7], value);
            this.subAccountId = value;
            fieldSetFlags()[7] = true;
            return this;
        }

        /**
         * Checks whether the 'subAccountId' field has been set.
         *
         * @return True if the 'subAccountId' field has been set, false otherwise.
         */
        public boolean hasSubAccountId() {
            return fieldSetFlags()[7];
        }


        /**
         * Clears the value of the 'subAccountId' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearSubAccountId() {
            fieldSetFlags()[7] = false;
            return this;
        }

        /**
         * Gets the value of the 'strategyId' field.
         *
         * @return The value.
         */
        public int getStrategyId() {
            return strategyId;
        }


        /**
         * Sets the value of the 'strategyId' field.
         *
         * @param value The value of 'strategyId'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setStrategyId(int value) {
            validate(fields()[8], value);
            this.strategyId = value;
            fieldSetFlags()[8] = true;
            return this;
        }

        /**
         * Checks whether the 'strategyId' field has been set.
         *
         * @return True if the 'strategyId' field has been set, false otherwise.
         */
        public boolean hasStrategyId() {
            return fieldSetFlags()[8];
        }


        /**
         * Clears the value of the 'strategyId' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearStrategyId() {
            fieldSetFlags()[8] = false;
            return this;
        }

        /**
         * Gets the value of the 'operatorId' field.
         *
         * @return The value.
         */
        public java.lang.String getOperatorId() {
            return operatorId;
        }


        /**
         * Sets the value of the 'operatorId' field.
         *
         * @param value The value of 'operatorId'.
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder setOperatorId(java.lang.String value) {
            validate(fields()[9], value);
            this.operatorId = value;
            fieldSetFlags()[9] = true;
            return this;
        }

        /**
         * Checks whether the 'operatorId' field has been set.
         *
         * @return True if the 'operatorId' field has been set, false otherwise.
         */
        public boolean hasOperatorId() {
            return fieldSetFlags()[9];
        }


        /**
         * Clears the value of the 'operatorId' field.
         *
         * @return This builder.
         */
        public io.horizon.trader.transport.avro.inbound.TdxQueryOrder.Builder clearOperatorId() {
            operatorId = null;
            fieldSetFlags()[9] = false;
            return this;
        }

        @Override
        public TdxQueryOrder build() {
            try {
                TdxQueryOrder record = new TdxQueryOrder();
                record.generateTime = fieldSetFlags()[0] ? this.generateTime : (java.lang.Long) defaultValue(fields()[0]);
                record.sendTime = fieldSetFlags()[1] ? this.sendTime : (java.lang.Long) defaultValue(fields()[1]);
                record.ordSysId = fieldSetFlags()[2] ? this.ordSysId : (java.lang.Long) defaultValue(fields()[2]);
                record.exchangeCode = fieldSetFlags()[3] ? this.exchangeCode : (java.lang.String) defaultValue(fields()[3]);
                record.instrumentCode = fieldSetFlags()[4] ? this.instrumentCode : (java.lang.String) defaultValue(fields()[4]);
                record.brokerId = fieldSetFlags()[5] ? this.brokerId : (java.lang.String) defaultValue(fields()[5]);
                record.accountId = fieldSetFlags()[6] ? this.accountId : (java.lang.Integer) defaultValue(fields()[6]);
                record.subAccountId = fieldSetFlags()[7] ? this.subAccountId : (java.lang.Integer) defaultValue(fields()[7]);
                record.strategyId = fieldSetFlags()[8] ? this.strategyId : (java.lang.Integer) defaultValue(fields()[8]);
                record.operatorId = fieldSetFlags()[9] ? this.operatorId : (java.lang.String) defaultValue(fields()[9]);
                return record;
            } catch (org.apache.avro.AvroMissingFieldException e) {
                throw e;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<TdxQueryOrder>
            WRITER$ = (org.apache.avro.io.DatumWriter<TdxQueryOrder>) MODEL$.createDatumWriter(SCHEMA$);

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<TdxQueryOrder>
            READER$ = (org.apache.avro.io.DatumReader<TdxQueryOrder>) MODEL$.createDatumReader(SCHEMA$);

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    @Override
    protected boolean hasCustomCoders() {
        return true;
    }

    @Override
    public void customEncode(org.apache.avro.io.Encoder out)
            throws java.io.IOException {
        out.writeLong(this.generateTime);

        out.writeLong(this.sendTime);

        out.writeLong(this.ordSysId);

        out.writeString(this.exchangeCode);

        out.writeString(this.instrumentCode);

        out.writeString(this.brokerId);

        out.writeInt(this.accountId);

        out.writeInt(this.subAccountId);

        out.writeInt(this.strategyId);

        out.writeString(this.operatorId);

    }

    @Override
    public void customDecode(org.apache.avro.io.ResolvingDecoder in)
            throws java.io.IOException {
        org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
        if (fieldOrder == null) {
            this.generateTime = in.readLong();

            this.sendTime = in.readLong();

            this.ordSysId = in.readLong();

            this.exchangeCode = in.readString();

            this.instrumentCode = in.readString();

            this.brokerId = in.readString();

            this.accountId = in.readInt();

            this.subAccountId = in.readInt();

            this.strategyId = in.readInt();

            this.operatorId = in.readString();

        } else {
            for (int i = 0; i < 10; i++) {
                switch (fieldOrder[i].pos()) {
                    case 0 -> this.generateTime = in.readLong();
                    case 1 -> this.sendTime = in.readLong();
                    case 2 -> this.ordSysId = in.readLong();
                    case 3 -> this.exchangeCode = in.readString();
                    case 4 -> this.instrumentCode = in.readString();
                    case 5 -> this.brokerId = in.readString();
                    case 6 -> this.accountId = in.readInt();
                    case 7 -> this.subAccountId = in.readInt();
                    case 8 -> this.strategyId = in.readInt();
                    case 9 -> this.operatorId = in.readString();
                    default -> throw new java.io.IOException("Corrupt ResolvingDecoder.");
                }
            }
        }
    }
}










