/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package io.cygnuxltb.jcts.core.serialization.avro.rpc;

@org.apache.avro.specific.AvroGenerated
public interface ARpcMarketProtocol {
    public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"ARpcMarketProtocol\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.rpc\",\"types\":[{\"type\":\"enum\",\"name\":\"AEnumMarketDataType\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.enums\",\"doc\":\"行情类型\",\"symbols\":[\"DEPTH\",\"FAST\",\"LEVEL10\",\"LEVEL20\",\"LEVEL30\"]},{\"type\":\"enum\",\"name\":\"AEnumSubscribeStatus\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.enums\",\"doc\":\"行情订阅状态\",\"symbols\":[\"SUCCEED\",\"PART_SUCCEED\",\"FAILED\"]},{\"type\":\"record\",\"name\":\"AInMarketDataSubscribe\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"行情订阅\",\"fields\":[{\"name\":\"type\",\"type\":\"io.cygnuxltb.jcts.core.serialization.avro.enums.AEnumMarketDataType\"},{\"name\":\"instrumentCodes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"recvAddr\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]},{\"type\":\"record\",\"name\":\"AOutMarketDataSubscribeReply\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"行情订阅回报\",\"fields\":[{\"name\":\"status\",\"type\":\"io.cygnuxltb.jcts.core.serialization.avro.enums.AEnumSubscribeStatus\"},{\"name\":\"successInstrumentCodes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"failInstrumentCodes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"msg\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]},{\"type\":\"record\",\"name\":\"AOutDepthMarketData\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"深度行情数据结构\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"instrumentId\",\"type\":\"int\"},{\"name\":\"instrumentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastPrice\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"int\"},{\"name\":\"turnover\",\"type\":\"long\"},{\"name\":\"bidPrices\",\"type\":{\"type\":\"array\",\"items\":\"double\"}},{\"name\":\"bidVolumes\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"askPrices\",\"type\":{\"type\":\"array\",\"items\":\"double\"}},{\"name\":\"askVolumes\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"depth\",\"type\":\"int\"}]},{\"type\":\"record\",\"name\":\"AOutFastMarketData\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"五档快速行情数据结构\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"instrumentId\",\"type\":\"int\"},{\"name\":\"instrumentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastPrice\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"int\"},{\"name\":\"turnover\",\"type\":\"long\"},{\"name\":\"bidPrices1\",\"type\":\"double\"},{\"name\":\"bidPrices2\",\"type\":\"double\"},{\"name\":\"bidPrices3\",\"type\":\"double\"},{\"name\":\"bidPrices4\",\"type\":\"double\"},{\"name\":\"bidPrices5\",\"type\":\"double\"},{\"name\":\"bidVolumes1\",\"type\":\"int\"},{\"name\":\"bidVolumes2\",\"type\":\"int\"},{\"name\":\"bidVolumes3\",\"type\":\"int\"},{\"name\":\"bidVolumes4\",\"type\":\"int\"},{\"name\":\"bidVolumes5\",\"type\":\"int\"},{\"name\":\"askPrices1\",\"type\":\"double\"},{\"name\":\"askPrices2\",\"type\":\"double\"},{\"name\":\"askPrices3\",\"type\":\"double\"},{\"name\":\"askPrices4\",\"type\":\"double\"},{\"name\":\"askPrices5\",\"type\":\"double\"},{\"name\":\"askVolumes1\",\"type\":\"int\"},{\"name\":\"askVolumes2\",\"type\":\"int\"},{\"name\":\"askVolumes3\",\"type\":\"int\"},{\"name\":\"askVolumes4\",\"type\":\"int\"},{\"name\":\"askVolumes5\",\"type\":\"int\"}]},{\"type\":\"record\",\"name\":\"AOutMarketDataL10\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"十档行情数据结构\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"instrumentId\",\"type\":\"int\"},{\"name\":\"instrumentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastPrice\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"int\"},{\"name\":\"turnover\",\"type\":\"long\"},{\"name\":\"bidPrices1\",\"type\":\"double\"},{\"name\":\"bidPrices2\",\"type\":\"double\"},{\"name\":\"bidPrices3\",\"type\":\"double\"},{\"name\":\"bidPrices4\",\"type\":\"double\"},{\"name\":\"bidPrices5\",\"type\":\"double\"},{\"name\":\"bidPrices6\",\"type\":\"double\"},{\"name\":\"bidPrices7\",\"type\":\"double\"},{\"name\":\"bidPrices8\",\"type\":\"double\"},{\"name\":\"bidPrices9\",\"type\":\"double\"},{\"name\":\"bidPrices10\",\"type\":\"double\"},{\"name\":\"bidVolumes1\",\"type\":\"int\"},{\"name\":\"bidVolumes2\",\"type\":\"int\"},{\"name\":\"bidVolumes3\",\"type\":\"int\"},{\"name\":\"bidVolumes4\",\"type\":\"int\"},{\"name\":\"bidVolumes5\",\"type\":\"int\"},{\"name\":\"bidVolumes6\",\"type\":\"int\"},{\"name\":\"bidVolumes7\",\"type\":\"int\"},{\"name\":\"bidVolumes8\",\"type\":\"int\"},{\"name\":\"bidVolumes9\",\"type\":\"int\"},{\"name\":\"bidVolumes10\",\"type\":\"int\"},{\"name\":\"askPrices1\",\"type\":\"double\"},{\"name\":\"askPrices2\",\"type\":\"double\"},{\"name\":\"askPrices3\",\"type\":\"double\"},{\"name\":\"askPrices4\",\"type\":\"double\"},{\"name\":\"askPrices5\",\"type\":\"double\"},{\"name\":\"askPrices6\",\"type\":\"double\"},{\"name\":\"askPrices7\",\"type\":\"double\"},{\"name\":\"askPrices8\",\"type\":\"double\"},{\"name\":\"askPrices9\",\"type\":\"double\"},{\"name\":\"askPrices10\",\"type\":\"double\"},{\"name\":\"askVolumes1\",\"type\":\"int\"},{\"name\":\"askVolumes2\",\"type\":\"int\"},{\"name\":\"askVolumes3\",\"type\":\"int\"},{\"name\":\"askVolumes4\",\"type\":\"int\"},{\"name\":\"askVolumes5\",\"type\":\"int\"},{\"name\":\"askVolumes6\",\"type\":\"int\"},{\"name\":\"askVolumes7\",\"type\":\"int\"},{\"name\":\"askVolumes8\",\"type\":\"int\"},{\"name\":\"askVolumes9\",\"type\":\"int\"},{\"name\":\"askVolumes10\",\"type\":\"int\"}]},{\"type\":\"record\",\"name\":\"AOutMarketDataL20\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"二十档行情数据结构\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"instrumentId\",\"type\":\"int\"},{\"name\":\"instrumentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastPrice\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"int\"},{\"name\":\"turnover\",\"type\":\"long\"},{\"name\":\"bidPrices1\",\"type\":\"double\"},{\"name\":\"bidPrices2\",\"type\":\"double\"},{\"name\":\"bidPrices3\",\"type\":\"double\"},{\"name\":\"bidPrices4\",\"type\":\"double\"},{\"name\":\"bidPrices5\",\"type\":\"double\"},{\"name\":\"bidPrices6\",\"type\":\"double\"},{\"name\":\"bidPrices7\",\"type\":\"double\"},{\"name\":\"bidPrices8\",\"type\":\"double\"},{\"name\":\"bidPrices9\",\"type\":\"double\"},{\"name\":\"bidPrices10\",\"type\":\"double\"},{\"name\":\"bidPrices11\",\"type\":\"double\"},{\"name\":\"bidPrices12\",\"type\":\"double\"},{\"name\":\"bidPrices13\",\"type\":\"double\"},{\"name\":\"bidPrices14\",\"type\":\"double\"},{\"name\":\"bidPrices15\",\"type\":\"double\"},{\"name\":\"bidPrices16\",\"type\":\"double\"},{\"name\":\"bidPrices17\",\"type\":\"double\"},{\"name\":\"bidPrices18\",\"type\":\"double\"},{\"name\":\"bidPrices19\",\"type\":\"double\"},{\"name\":\"bidPrices20\",\"type\":\"double\"},{\"name\":\"bidVolumes1\",\"type\":\"int\"},{\"name\":\"bidVolumes2\",\"type\":\"int\"},{\"name\":\"bidVolumes3\",\"type\":\"int\"},{\"name\":\"bidVolumes4\",\"type\":\"int\"},{\"name\":\"bidVolumes5\",\"type\":\"int\"},{\"name\":\"bidVolumes6\",\"type\":\"int\"},{\"name\":\"bidVolumes7\",\"type\":\"int\"},{\"name\":\"bidVolumes8\",\"type\":\"int\"},{\"name\":\"bidVolumes9\",\"type\":\"int\"},{\"name\":\"bidVolumes10\",\"type\":\"int\"},{\"name\":\"bidVolumes11\",\"type\":\"int\"},{\"name\":\"bidVolumes12\",\"type\":\"int\"},{\"name\":\"bidVolumes13\",\"type\":\"int\"},{\"name\":\"bidVolumes14\",\"type\":\"int\"},{\"name\":\"bidVolumes15\",\"type\":\"int\"},{\"name\":\"bidVolumes16\",\"type\":\"int\"},{\"name\":\"bidVolumes17\",\"type\":\"int\"},{\"name\":\"bidVolumes18\",\"type\":\"int\"},{\"name\":\"bidVolumes19\",\"type\":\"int\"},{\"name\":\"bidVolumes20\",\"type\":\"int\"},{\"name\":\"askPrices1\",\"type\":\"double\"},{\"name\":\"askPrices2\",\"type\":\"double\"},{\"name\":\"askPrices3\",\"type\":\"double\"},{\"name\":\"askPrices4\",\"type\":\"double\"},{\"name\":\"askPrices5\",\"type\":\"double\"},{\"name\":\"askPrices6\",\"type\":\"double\"},{\"name\":\"askPrices7\",\"type\":\"double\"},{\"name\":\"askPrices8\",\"type\":\"double\"},{\"name\":\"askPrices9\",\"type\":\"double\"},{\"name\":\"askPrices10\",\"type\":\"double\"},{\"name\":\"askPrices11\",\"type\":\"double\"},{\"name\":\"askPrices12\",\"type\":\"double\"},{\"name\":\"askPrices13\",\"type\":\"double\"},{\"name\":\"askPrices14\",\"type\":\"double\"},{\"name\":\"askPrices15\",\"type\":\"double\"},{\"name\":\"askPrices16\",\"type\":\"double\"},{\"name\":\"askPrices17\",\"type\":\"double\"},{\"name\":\"askPrices18\",\"type\":\"double\"},{\"name\":\"askPrices19\",\"type\":\"double\"},{\"name\":\"askPrices20\",\"type\":\"double\"},{\"name\":\"askVolumes1\",\"type\":\"int\"},{\"name\":\"askVolumes2\",\"type\":\"int\"},{\"name\":\"askVolumes3\",\"type\":\"int\"},{\"name\":\"askVolumes4\",\"type\":\"int\"},{\"name\":\"askVolumes5\",\"type\":\"int\"},{\"name\":\"askVolumes6\",\"type\":\"int\"},{\"name\":\"askVolumes7\",\"type\":\"int\"},{\"name\":\"askVolumes8\",\"type\":\"int\"},{\"name\":\"askVolumes9\",\"type\":\"int\"},{\"name\":\"askVolumes10\",\"type\":\"int\"},{\"name\":\"askVolumes11\",\"type\":\"int\"},{\"name\":\"askVolumes12\",\"type\":\"int\"},{\"name\":\"askVolumes13\",\"type\":\"int\"},{\"n", "ame\":\"askVolumes14\",\"type\":\"int\"},{\"name\":\"askVolumes15\",\"type\":\"int\"},{\"name\":\"askVolumes16\",\"type\":\"int\"},{\"name\":\"askVolumes17\",\"type\":\"int\"},{\"name\":\"askVolumes18\",\"type\":\"int\"},{\"name\":\"askVolumes19\",\"type\":\"int\"},{\"name\":\"askVolumes20\",\"type\":\"int\"}]},{\"type\":\"record\",\"name\":\"AOutMarketDataL30\",\"namespace\":\"io.cygnuxltb.jcts.core.serialization.avro.record\",\"doc\":\"三十档行情数据结构\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"instrumentId\",\"type\":\"int\"},{\"name\":\"instrumentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastPrice\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"int\"},{\"name\":\"turnover\",\"type\":\"long\"},{\"name\":\"bidPrices1\",\"type\":\"double\"},{\"name\":\"bidPrices2\",\"type\":\"double\"},{\"name\":\"bidPrices3\",\"type\":\"double\"},{\"name\":\"bidPrices4\",\"type\":\"double\"},{\"name\":\"bidPrices5\",\"type\":\"double\"},{\"name\":\"bidPrices6\",\"type\":\"double\"},{\"name\":\"bidPrices7\",\"type\":\"double\"},{\"name\":\"bidPrices8\",\"type\":\"double\"},{\"name\":\"bidPrices9\",\"type\":\"double\"},{\"name\":\"bidPrices10\",\"type\":\"double\"},{\"name\":\"bidPrices11\",\"type\":\"double\"},{\"name\":\"bidPrices12\",\"type\":\"double\"},{\"name\":\"bidPrices13\",\"type\":\"double\"},{\"name\":\"bidPrices14\",\"type\":\"double\"},{\"name\":\"bidPrices15\",\"type\":\"double\"},{\"name\":\"bidPrices16\",\"type\":\"double\"},{\"name\":\"bidPrices17\",\"type\":\"double\"},{\"name\":\"bidPrices18\",\"type\":\"double\"},{\"name\":\"bidPrices19\",\"type\":\"double\"},{\"name\":\"bidPrices20\",\"type\":\"double\"},{\"name\":\"bidPrices21\",\"type\":\"double\"},{\"name\":\"bidPrices22\",\"type\":\"double\"},{\"name\":\"bidPrices23\",\"type\":\"double\"},{\"name\":\"bidPrices24\",\"type\":\"double\"},{\"name\":\"bidPrices25\",\"type\":\"double\"},{\"name\":\"bidPrices26\",\"type\":\"double\"},{\"name\":\"bidPrices27\",\"type\":\"double\"},{\"name\":\"bidPrices28\",\"type\":\"double\"},{\"name\":\"bidPrices29\",\"type\":\"double\"},{\"name\":\"bidPrices30\",\"type\":\"double\"},{\"name\":\"bidVolumes1\",\"type\":\"int\"},{\"name\":\"bidVolumes2\",\"type\":\"int\"},{\"name\":\"bidVolumes3\",\"type\":\"int\"},{\"name\":\"bidVolumes4\",\"type\":\"int\"},{\"name\":\"bidVolumes5\",\"type\":\"int\"},{\"name\":\"bidVolumes6\",\"type\":\"int\"},{\"name\":\"bidVolumes7\",\"type\":\"int\"},{\"name\":\"bidVolumes8\",\"type\":\"int\"},{\"name\":\"bidVolumes9\",\"type\":\"int\"},{\"name\":\"bidVolumes10\",\"type\":\"int\"},{\"name\":\"bidVolumes11\",\"type\":\"int\"},{\"name\":\"bidVolumes12\",\"type\":\"int\"},{\"name\":\"bidVolumes13\",\"type\":\"int\"},{\"name\":\"bidVolumes14\",\"type\":\"int\"},{\"name\":\"bidVolumes15\",\"type\":\"int\"},{\"name\":\"bidVolumes16\",\"type\":\"int\"},{\"name\":\"bidVolumes17\",\"type\":\"int\"},{\"name\":\"bidVolumes18\",\"type\":\"int\"},{\"name\":\"bidVolumes19\",\"type\":\"int\"},{\"name\":\"bidVolumes20\",\"type\":\"int\"},{\"name\":\"bidVolumes21\",\"type\":\"int\"},{\"name\":\"bidVolumes22\",\"type\":\"int\"},{\"name\":\"bidVolumes23\",\"type\":\"int\"},{\"name\":\"bidVolumes24\",\"type\":\"int\"},{\"name\":\"bidVolumes25\",\"type\":\"int\"},{\"name\":\"bidVolumes26\",\"type\":\"int\"},{\"name\":\"bidVolumes27\",\"type\":\"int\"},{\"name\":\"bidVolumes28\",\"type\":\"int\"},{\"name\":\"bidVolumes29\",\"type\":\"int\"},{\"name\":\"bidVolumes30\",\"type\":\"int\"},{\"name\":\"askPrices1\",\"type\":\"double\"},{\"name\":\"askPrices2\",\"type\":\"double\"},{\"name\":\"askPrices3\",\"type\":\"double\"},{\"name\":\"askPrices4\",\"type\":\"double\"},{\"name\":\"askPrices5\",\"type\":\"double\"},{\"name\":\"askPrices6\",\"type\":\"double\"},{\"name\":\"askPrices7\",\"type\":\"double\"},{\"name\":\"askPrices8\",\"type\":\"double\"},{\"name\":\"askPrices9\",\"type\":\"double\"},{\"name\":\"askPrices10\",\"type\":\"double\"},{\"name\":\"askPrices11\",\"type\":\"double\"},{\"name\":\"askPrices12\",\"type\":\"double\"},{\"name\":\"askPrices13\",\"type\":\"double\"},{\"name\":\"askPrices14\",\"type\":\"double\"},{\"name\":\"askPrices15\",\"type\":\"double\"},{\"name\":\"askPrices16\",\"type\":\"double\"},{\"name\":\"askPrices17\",\"type\":\"double\"},{\"name\":\"askPrices18\",\"type\":\"double\"},{\"name\":\"askPrices19\",\"type\":\"double\"},{\"name\":\"askPrices20\",\"type\":\"double\"},{\"name\":\"askPrices21\",\"type\":\"double\"},{\"name\":\"askPrices22\",\"type\":\"double\"},{\"name\":\"askPrices23\",\"type\":\"double\"},{\"name\":\"askPrices24\",\"type\":\"double\"},{\"name\":\"askPrices25\",\"type\":\"double\"},{\"name\":\"askPrices26\",\"type\":\"double\"},{\"name\":\"askPrices27\",\"type\":\"double\"},{\"name\":\"askPrices28\",\"type\":\"double\"},{\"name\":\"askPrices29\",\"type\":\"double\"},{\"name\":\"askPrices30\",\"type\":\"double\"},{\"name\":\"askVolumes1\",\"type\":\"int\"},{\"name\":\"askVolumes2\",\"type\":\"int\"},{\"name\":\"askVolumes3\",\"type\":\"int\"},{\"name\":\"askVolumes4\",\"type\":\"int\"},{\"name\":\"askVolumes5\",\"type\":\"int\"},{\"name\":\"askVolumes6\",\"type\":\"int\"},{\"name\":\"askVolumes7\",\"type\":\"int\"},{\"name\":\"askVolumes8\",\"type\":\"int\"},{\"name\":\"askVolumes9\",\"type\":\"int\"},{\"name\":\"askVolumes10\",\"type\":\"int\"},{\"name\":\"askVolumes11\",\"type\":\"int\"},{\"name\":\"askVolumes12\",\"type\":\"int\"},{\"name\":\"askVolumes13\",\"type\":\"int\"},{\"name\":\"askVolumes14\",\"type\":\"int\"},{\"name\":\"askVolumes15\",\"type\":\"int\"},{\"name\":\"askVolumes16\",\"type\":\"int\"},{\"name\":\"askVolumes17\",\"type\":\"int\"},{\"name\":\"askVolumes18\",\"type\":\"int\"},{\"name\":\"askVolumes19\",\"type\":\"int\"},{\"name\":\"askVolumes20\",\"type\":\"int\"},{\"name\":\"askVolumes21\",\"type\":\"int\"},{\"name\":\"askVolumes22\",\"type\":\"int\"},{\"name\":\"askVolumes23\",\"type\":\"int\"},{\"name\":\"askVolumes24\",\"type\":\"int\"},{\"name\":\"askVolumes25\",\"type\":\"int\"},{\"name\":\"askVolumes26\",\"type\":\"int\"},{\"name\":\"askVolumes27\",\"type\":\"int\"},{\"name\":\"askVolumes28\",\"type\":\"int\"},{\"name\":\"askVolumes29\",\"type\":\"int\"},{\"name\":\"askVolumes30\",\"type\":\"int\"}]}],\"messages\":{\"subscribeMarketData\":{\"doc\":\"订阅行情函数\",\"request\":[{\"name\":\"subscribe\",\"type\":\"io.cygnuxltb.jcts.core.serialization.avro.record.AInMarketDataSubscribe\"}],\"response\":\"boolean\"}}}");

    /**
     * 订阅行情函数
     */
    boolean subscribeMarketData(io.cygnuxltb.jcts.core.serialization.avro.record.AInMarketDataSubscribe subscribe);

    @org.apache.avro.specific.AvroGenerated
    public interface Callback extends ARpcMarketProtocol {
        public static final org.apache.avro.Protocol PROTOCOL = io.cygnuxltb.jcts.core.serialization.avro.rpc.ARpcMarketProtocol.PROTOCOL;

        /**
         * 订阅行情函数
         * @throws java.io.IOException The async call could not be completed.
         */
        void subscribeMarketData(io.cygnuxltb.jcts.core.serialization.avro.record.AInMarketDataSubscribe subscribe, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
    }
}