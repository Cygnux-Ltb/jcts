/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.horizon.trader.transport.outbound;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;
import java.util.Optional;
/** 账户可用余额回报 */
@org.apache.avro.specific.AvroGenerated
public class TdxBalanceReport extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -376288979028923415L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TdxBalanceReport\",\"namespace\":\"io.horizon.trader.transport.outbound\",\"doc\":\"账户可用余额回报\",\"fields\":[{\"name\":\"epochMillis\",\"type\":\"long\"},{\"name\":\"brokerId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"investorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"available\",\"type\":\"long\"},{\"name\":\"currencyId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TdxBalanceReport> ENCODER =
      new BinaryMessageEncoder<TdxBalanceReport>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TdxBalanceReport> DECODER =
      new BinaryMessageDecoder<TdxBalanceReport>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TdxBalanceReport> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TdxBalanceReport> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TdxBalanceReport> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TdxBalanceReport>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TdxBalanceReport to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TdxBalanceReport from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TdxBalanceReport instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TdxBalanceReport fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long epochMillis;
  private java.lang.String brokerId;
  private java.lang.String investorId;
  private long available;
  private java.lang.String currencyId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TdxBalanceReport() {}

  /**
   * All-args constructor.
   * @param epochMillis The new value for epochMillis
   * @param brokerId The new value for brokerId
   * @param investorId The new value for investorId
   * @param available The new value for available
   * @param currencyId The new value for currencyId
   */
  public TdxBalanceReport(java.lang.Long epochMillis, java.lang.String brokerId, java.lang.String investorId, java.lang.Long available, java.lang.String currencyId) {
    this.epochMillis = epochMillis;
    this.brokerId = brokerId;
    this.investorId = investorId;
    this.available = available;
    this.currencyId = currencyId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return epochMillis;
    case 1: return brokerId;
    case 2: return investorId;
    case 3: return available;
    case 4: return currencyId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: epochMillis = (java.lang.Long)value$; break;
    case 1: brokerId = value$ != null ? value$.toString() : null; break;
    case 2: investorId = value$ != null ? value$.toString() : null; break;
    case 3: available = (java.lang.Long)value$; break;
    case 4: currencyId = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'epochMillis' field.
   * @return The value of the 'epochMillis' field.
   */
  public long getEpochMillis() {
    return epochMillis;
  }

  /**
   * Gets the value of the 'epochMillis' field as an Optional&lt;java.lang.Long&gt;.
   * @return The value wrapped in an Optional&lt;java.lang.Long&gt;.
   */
  public Optional<java.lang.Long> getOptionalEpochMillis() {
    return Optional.<java.lang.Long>ofNullable(epochMillis);
  }

  /**
   * Sets the value of the 'epochMillis' field.
   * @param value the value to set.
   */
  public TdxBalanceReport setEpochMillis(long value) {
    this.epochMillis = value;
    return this;
  }

  /**
   * Gets the value of the 'brokerId' field.
   * @return The value of the 'brokerId' field.
   */
  public java.lang.String getBrokerId() {
    return brokerId;
  }

  /**
   * Gets the value of the 'brokerId' field as an Optional&lt;java.lang.String&gt;.
   * @return The value wrapped in an Optional&lt;java.lang.String&gt;.
   */
  public Optional<java.lang.String> getOptionalBrokerId() {
    return Optional.<java.lang.String>ofNullable(brokerId);
  }

  /**
   * Sets the value of the 'brokerId' field.
   * @param value the value to set.
   */
  public TdxBalanceReport setBrokerId(java.lang.String value) {
    this.brokerId = value;
    return this;
  }

  /**
   * Gets the value of the 'investorId' field.
   * @return The value of the 'investorId' field.
   */
  public java.lang.String getInvestorId() {
    return investorId;
  }

  /**
   * Gets the value of the 'investorId' field as an Optional&lt;java.lang.String&gt;.
   * @return The value wrapped in an Optional&lt;java.lang.String&gt;.
   */
  public Optional<java.lang.String> getOptionalInvestorId() {
    return Optional.<java.lang.String>ofNullable(investorId);
  }

  /**
   * Sets the value of the 'investorId' field.
   * @param value the value to set.
   */
  public TdxBalanceReport setInvestorId(java.lang.String value) {
    this.investorId = value;
    return this;
  }

  /**
   * Gets the value of the 'available' field.
   * @return The value of the 'available' field.
   */
  public long getAvailable() {
    return available;
  }

  /**
   * Gets the value of the 'available' field as an Optional&lt;java.lang.Long&gt;.
   * @return The value wrapped in an Optional&lt;java.lang.Long&gt;.
   */
  public Optional<java.lang.Long> getOptionalAvailable() {
    return Optional.<java.lang.Long>ofNullable(available);
  }

  /**
   * Sets the value of the 'available' field.
   * @param value the value to set.
   */
  public TdxBalanceReport setAvailable(long value) {
    this.available = value;
    return this;
  }

  /**
   * Gets the value of the 'currencyId' field.
   * @return The value of the 'currencyId' field.
   */
  public java.lang.String getCurrencyId() {
    return currencyId;
  }

  /**
   * Gets the value of the 'currencyId' field as an Optional&lt;java.lang.String&gt;.
   * @return The value wrapped in an Optional&lt;java.lang.String&gt;.
   */
  public Optional<java.lang.String> getOptionalCurrencyId() {
    return Optional.<java.lang.String>ofNullable(currencyId);
  }

  /**
   * Sets the value of the 'currencyId' field.
   * @param value the value to set.
   */
  public TdxBalanceReport setCurrencyId(java.lang.String value) {
    this.currencyId = value;
    return this;
  }

  /**
   * Creates a new TdxBalanceReport RecordBuilder.
   * @return A new TdxBalanceReport RecordBuilder
   */
  public static io.horizon.trader.transport.outbound.TdxBalanceReport.Builder newBuilder() {
    return new io.horizon.trader.transport.outbound.TdxBalanceReport.Builder();
  }

  /**
   * Creates a new TdxBalanceReport RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TdxBalanceReport RecordBuilder
   */
  public static io.horizon.trader.transport.outbound.TdxBalanceReport.Builder newBuilder(io.horizon.trader.transport.outbound.TdxBalanceReport.Builder other) {
    if (other == null) {
      return new io.horizon.trader.transport.outbound.TdxBalanceReport.Builder();
    } else {
      return new io.horizon.trader.transport.outbound.TdxBalanceReport.Builder(other);
    }
  }

  /**
   * Creates a new TdxBalanceReport RecordBuilder by copying an existing TdxBalanceReport instance.
   * @param other The existing instance to copy.
   * @return A new TdxBalanceReport RecordBuilder
   */
  public static io.horizon.trader.transport.outbound.TdxBalanceReport.Builder newBuilder(io.horizon.trader.transport.outbound.TdxBalanceReport other) {
    if (other == null) {
      return new io.horizon.trader.transport.outbound.TdxBalanceReport.Builder();
    } else {
      return new io.horizon.trader.transport.outbound.TdxBalanceReport.Builder(other);
    }
  }

  /**
   * RecordBuilder for TdxBalanceReport instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TdxBalanceReport>
    implements org.apache.avro.data.RecordBuilder<TdxBalanceReport> {

    private long epochMillis;
    private java.lang.String brokerId;
    private java.lang.String investorId;
    private long available;
    private java.lang.String currencyId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.horizon.trader.transport.outbound.TdxBalanceReport.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.epochMillis)) {
        this.epochMillis = data().deepCopy(fields()[0].schema(), other.epochMillis);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.brokerId)) {
        this.brokerId = data().deepCopy(fields()[1].schema(), other.brokerId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.investorId)) {
        this.investorId = data().deepCopy(fields()[2].schema(), other.investorId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.available)) {
        this.available = data().deepCopy(fields()[3].schema(), other.available);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.currencyId)) {
        this.currencyId = data().deepCopy(fields()[4].schema(), other.currencyId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing TdxBalanceReport instance
     * @param other The existing instance to copy.
     */
    private Builder(io.horizon.trader.transport.outbound.TdxBalanceReport other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.epochMillis)) {
        this.epochMillis = data().deepCopy(fields()[0].schema(), other.epochMillis);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.brokerId)) {
        this.brokerId = data().deepCopy(fields()[1].schema(), other.brokerId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.investorId)) {
        this.investorId = data().deepCopy(fields()[2].schema(), other.investorId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.available)) {
        this.available = data().deepCopy(fields()[3].schema(), other.available);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.currencyId)) {
        this.currencyId = data().deepCopy(fields()[4].schema(), other.currencyId);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'epochMillis' field.
      * @return The value.
      */
    public long getEpochMillis() {
      return epochMillis;
    }

    /**
      * Gets the value of the 'epochMillis' field as an Optional&lt;java.lang.Long&gt;.
      * @return The value wrapped in an Optional&lt;java.lang.Long&gt;.
      */
    public Optional<java.lang.Long> getOptionalEpochMillis() {
      return Optional.<java.lang.Long>ofNullable(epochMillis);
    }

    /**
      * Sets the value of the 'epochMillis' field.
      * @param value The value of 'epochMillis'.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder setEpochMillis(long value) {
      validate(fields()[0], value);
      this.epochMillis = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'epochMillis' field has been set.
      * @return True if the 'epochMillis' field has been set, false otherwise.
      */
    public boolean hasEpochMillis() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'epochMillis' field.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder clearEpochMillis() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'brokerId' field.
      * @return The value.
      */
    public java.lang.String getBrokerId() {
      return brokerId;
    }

    /**
      * Gets the value of the 'brokerId' field as an Optional&lt;java.lang.String&gt;.
      * @return The value wrapped in an Optional&lt;java.lang.String&gt;.
      */
    public Optional<java.lang.String> getOptionalBrokerId() {
      return Optional.<java.lang.String>ofNullable(brokerId);
    }

    /**
      * Sets the value of the 'brokerId' field.
      * @param value The value of 'brokerId'.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder setBrokerId(java.lang.String value) {
      validate(fields()[1], value);
      this.brokerId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'brokerId' field has been set.
      * @return True if the 'brokerId' field has been set, false otherwise.
      */
    public boolean hasBrokerId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'brokerId' field.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder clearBrokerId() {
      brokerId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'investorId' field.
      * @return The value.
      */
    public java.lang.String getInvestorId() {
      return investorId;
    }

    /**
      * Gets the value of the 'investorId' field as an Optional&lt;java.lang.String&gt;.
      * @return The value wrapped in an Optional&lt;java.lang.String&gt;.
      */
    public Optional<java.lang.String> getOptionalInvestorId() {
      return Optional.<java.lang.String>ofNullable(investorId);
    }

    /**
      * Sets the value of the 'investorId' field.
      * @param value The value of 'investorId'.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder setInvestorId(java.lang.String value) {
      validate(fields()[2], value);
      this.investorId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'investorId' field has been set.
      * @return True if the 'investorId' field has been set, false otherwise.
      */
    public boolean hasInvestorId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'investorId' field.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder clearInvestorId() {
      investorId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'available' field.
      * @return The value.
      */
    public long getAvailable() {
      return available;
    }

    /**
      * Gets the value of the 'available' field as an Optional&lt;java.lang.Long&gt;.
      * @return The value wrapped in an Optional&lt;java.lang.Long&gt;.
      */
    public Optional<java.lang.Long> getOptionalAvailable() {
      return Optional.<java.lang.Long>ofNullable(available);
    }

    /**
      * Sets the value of the 'available' field.
      * @param value The value of 'available'.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder setAvailable(long value) {
      validate(fields()[3], value);
      this.available = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'available' field has been set.
      * @return True if the 'available' field has been set, false otherwise.
      */
    public boolean hasAvailable() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'available' field.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder clearAvailable() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'currencyId' field.
      * @return The value.
      */
    public java.lang.String getCurrencyId() {
      return currencyId;
    }

    /**
      * Gets the value of the 'currencyId' field as an Optional&lt;java.lang.String&gt;.
      * @return The value wrapped in an Optional&lt;java.lang.String&gt;.
      */
    public Optional<java.lang.String> getOptionalCurrencyId() {
      return Optional.<java.lang.String>ofNullable(currencyId);
    }

    /**
      * Sets the value of the 'currencyId' field.
      * @param value The value of 'currencyId'.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder setCurrencyId(java.lang.String value) {
      validate(fields()[4], value);
      this.currencyId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'currencyId' field has been set.
      * @return True if the 'currencyId' field has been set, false otherwise.
      */
    public boolean hasCurrencyId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'currencyId' field.
      * @return This builder.
      */
    public io.horizon.trader.transport.outbound.TdxBalanceReport.Builder clearCurrencyId() {
      currencyId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public TdxBalanceReport build() {
      try {
        TdxBalanceReport record = new TdxBalanceReport();
        record.epochMillis = fieldSetFlags()[0] ? this.epochMillis : (java.lang.Long) defaultValue(fields()[0]);
        record.brokerId = fieldSetFlags()[1] ? this.brokerId : (java.lang.String) defaultValue(fields()[1]);
        record.investorId = fieldSetFlags()[2] ? this.investorId : (java.lang.String) defaultValue(fields()[2]);
        record.available = fieldSetFlags()[3] ? this.available : (java.lang.Long) defaultValue(fields()[3]);
        record.currencyId = fieldSetFlags()[4] ? this.currencyId : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TdxBalanceReport>
    WRITER$ = (org.apache.avro.io.DatumWriter<TdxBalanceReport>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TdxBalanceReport>
    READER$ = (org.apache.avro.io.DatumReader<TdxBalanceReport>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.epochMillis);

    out.writeString(this.brokerId);

    out.writeString(this.investorId);

    out.writeLong(this.available);

    out.writeString(this.currencyId);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.epochMillis = in.readLong();

      this.brokerId = in.readString();

      this.investorId = in.readString();

      this.available = in.readLong();

      this.currencyId = in.readString();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.epochMillis = in.readLong();
          break;

        case 1:
          this.brokerId = in.readString();
          break;

        case 2:
          this.investorId = in.readString();
          break;

        case 3:
          this.available = in.readLong();
          break;

        case 4:
          this.currencyId = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










