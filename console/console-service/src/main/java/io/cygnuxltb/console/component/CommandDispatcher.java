package io.cygnuxltb.console.component;

import io.cygnuxltb.console.persistence.entity.sys.ParamEntity;
import io.cygnuxltb.protocol.http.inbound.command.StrategySwitch;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class CommandDispatcher {

    @PostConstruct
    private void init() {
    }

    /**
     *
     */
    public boolean sendControlCommand(StrategySwitch strategySwitch) {
        return false;
    }


    public boolean sendStrategyCommand(StrategySwitch strategySwitch) {
        return false;
    }


    public boolean sendParams(List<ParamEntity> params) {
        return false;
    }

}
