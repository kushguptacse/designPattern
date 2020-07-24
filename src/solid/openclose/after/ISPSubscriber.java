package solid.openclose.after;

import java.util.List;

import solid.openclose.before.InternetSessionHistory;

public class ISPSubscriber extends Subscriber {

	private long freeUsage;

	// open for extension
	public double calculateBill() {
		List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory
				.getCurrentSessions(getSubscriberId());
		long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
		long chargeableData = totalData - getFreeUsage();
		return chargeableData * getBaseRate() / 100;
	}

	public long getFreeUsage() {
		return freeUsage;
	}

	public void setFreeUsage(long freeUsage) {
		this.freeUsage = freeUsage;
	}

}
