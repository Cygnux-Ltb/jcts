/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.horizon.market.transport.enums;
/** 行情订阅状态 */
@org.apache.avro.specific.AvroGenerated
public enum SubscribeStatus implements org.apache.avro.generic.GenericEnumSymbol<SubscribeStatus> {
  Succeed, PartSucceed, Failed  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"SubscribeStatus\",\"namespace\":\"io.horizon.market.transport.enums\",\"doc\":\"行情订阅状态\",\"symbols\":[\"Succeed\",\"PartSucceed\",\"Failed\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
