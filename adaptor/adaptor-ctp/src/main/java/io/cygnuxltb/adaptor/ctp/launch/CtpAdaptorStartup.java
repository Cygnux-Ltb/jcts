package io.cygnuxltb.adaptor.ctp.launch;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.cygnuxltb.adaptor.ctp.CtpAdaptor;
import io.cygnuxltb.adaptor.ctp.CtpConfiguration;
import io.cygnuxltb.jcts.core.account.Account;
import io.cygnuxltb.jcts.core.adaptor.ConnectionType;
import io.cygnuxltb.jcts.core.handler.InboundHandler;
import io.cygnuxltb.jcts.core.handler.MarketDataHandler;
import io.cygnuxltb.jcts.core.handler.MarketDataRecorder;
import io.cygnuxltb.jcts.core.instrument.Instrument;
import io.cygnuxltb.jcts.core.instrument.InstrumentKeeper;
import io.cygnuxltb.jcts.core.mkd.MarketData;
import io.cygnuxltb.jcts.core.mkd.impl.BasicMarketData;
import io.mercury.common.log4j2.Log4j2Configurator;
import io.mercury.common.log4j2.Log4j2LoggerFactory;
import io.mercury.common.thread.ThreadSupport;
import io.mercury.common.util.StringSupport;
import org.slf4j.Logger;

import java.io.File;

import static io.cygnuxltb.jcts.core.instrument.futures.ChinaFutures.ChinaFuturesUtil.nextCloseTime;
import static io.cygnuxltb.jcts.core.util.MarketTradableTime.registerCloseTime;
import static io.mercury.common.datetime.pattern.DateTimePattern.YYYYMMDD_L_HHMMSS;

public final class CtpAdaptorStartup {

    static {
        Log4j2Configurator.setLogLevel(Log4j2Configurator.LogLevel.INFO);
        Log4j2Configurator.setLogFilename("ctp-" + YYYYMMDD_L_HHMMSS.now());
    }

    private static final Logger log = Log4j2LoggerFactory.getLogger(CtpAdaptorStartup.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Config file path must be enter");
            throw new IllegalArgumentException("Input args is empty");
        }
        final String filePath = args[0];
        if (StringSupport.isNullOrEmpty(filePath)) {
            System.out.println("Config file path cannot be empty");
            throw new IllegalArgumentException("File path is empty");
        }
        System.out.println("Config file path -> " + filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Config file does not exist");
            throw new IllegalArgumentException("Config file does not exist");
        }
        Config config = ConfigFactory.parseFile(file);
        String mode = config.getString("adaptor.mode");
        log.info("adaptor run mode == {}", mode);

        String instrumentCodes = config.getString("instrumentCodes");
        log.info("instrument codes == {}", instrumentCodes);

        Instrument[] instruments = InstrumentKeeper.getInstrument(instrumentCodes.split(","));

        registerCloseTime(nextCloseTime());

//        if (mode.equals("zmq")) {
//            try (// CtpZmqHandler module = new CtpZmqHandler(config);
//                 MarketDataHandler<MarketData> recorder = new MarketDataRecorder.LoggerMarketDataRecorder(null, instruments);
//                 var adaptor = new CtpAdaptor(new Account(config), CtpConfiguration.with(config),
//                        ConnectionType.OnlyMarketData,
//                          recorder)) {
//                recorder.setAdaptor(adaptor);
//                adaptor.startup();
//                ThreadSupport.join();
//            } catch (Exception e) {
//                log.error("exception message -> {}", e.getMessage(), e);
//            }
//        } else if (mode.equals("rmq")) {
//            // TODO
//            throw new UnsupportedOperationException("The current version does not support [rmq] mode");
//        }

    }

}
