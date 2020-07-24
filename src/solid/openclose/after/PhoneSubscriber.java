package solid.openclose.after;

import java.util.List;

import solid.openclose.before.CallHistory;

public class PhoneSubscriber extends Subscriber {

	//open for extension
	public double calculateBill() {
		List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(getSubscriberId());
		long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
		return totalDuration * getBaseRate() / 100;
	}

}
