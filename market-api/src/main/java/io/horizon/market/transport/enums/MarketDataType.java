/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.horizon.market.transport.enums;
/** 行情类型 */
@org.apache.avro.specific.AvroGenerated
public enum MarketDataType implements org.apache.avro.generic.GenericEnumSymbol<MarketDataType> {
  Depth, Fast, Level10, Level20, Level30  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"MarketDataType\",\"namespace\":\"io.horizon.market.transport.enums\",\"doc\":\"行情类型\",\"symbols\":[\"Depth\",\"Fast\",\"Level10\",\"Level20\",\"Level30\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
