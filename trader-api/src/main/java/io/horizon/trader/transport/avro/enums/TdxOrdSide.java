/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package io.horizon.trader.transport.avro.enums;

@org.apache.avro.specific.AvroGenerated
public enum TdxOrdSide implements org.apache.avro.generic.GenericEnumSymbol<TdxOrdSide> {
    INVALID, BUY, SELL, MARGIN_BUY, SHORT_SELL;
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"TdxOrdSide\",\"namespace\":\"io.horizon.trader.transport.avro.enums\",\"symbols\":[\"INVALID\",\"BUY\",\"SELL\",\"MARGIN_BUY\",\"SHORT_SELL\"]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }
}