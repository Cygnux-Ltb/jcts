package io.cygnuxltb.jcts.engine.barrier;

import io.horizon.trader.order.ChildOrder;
import io.horizon.trader.risk.OrderBarrier;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class AdaptorBarrier implements OrderBarrier {

	@Override
	public boolean filter(ChildOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

}
