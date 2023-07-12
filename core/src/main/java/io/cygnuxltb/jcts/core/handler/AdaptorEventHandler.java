package io.cygnuxltb.jcts.core.handler;

import io.cygnuxltb.jcts.core.serialization.avro.event.AvAdaptorEvent;
import io.mercury.common.log4j2.Log4j2LoggerFactory;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface AdaptorEventHandler {

    void onAdaptorEvent(@Nonnull final AvAdaptorEvent event);

    /**
     * Logger implements AdaptorEventHandler
     *
     * @author yellow013
     */
    class AdaptorEventLogger implements AdaptorEventHandler {

        private final Logger log;

        public AdaptorEventLogger(Logger log) {
            this.log = log == null ? Log4j2LoggerFactory.getLogger(getClass()) : log;
        }

        @Override
        public void onAdaptorEvent(@Nonnull final AvAdaptorEvent report) {
            log.info("AdaptorEventLogger -> {}", report);
        }

    }

}
