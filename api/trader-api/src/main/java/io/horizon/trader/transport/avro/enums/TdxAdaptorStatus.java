/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.horizon.trader.transport.avro.enums;
@org.apache.avro.specific.AvroGenerated
public enum TdxAdaptorStatus implements org.apache.avro.generic.GenericEnumSymbol<TdxAdaptorStatus> {
  INVALID, UNAVAILABLE, MD_ENABLE, MD_DISABLE, TRADER_ENABLE, TRADER_DISABLE  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"TdxAdaptorStatus\",\"namespace\":\"io.horizon.trader.transport.avro.enums\",\"symbols\":[\"INVALID\",\"UNAVAILABLE\",\"MD_ENABLE\",\"MD_DISABLE\",\"TRADER_ENABLE\",\"TRADER_DISABLE\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
