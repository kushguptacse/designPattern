package behavioral.chainofresponsibility;

import behavioral.chainofresponsibility.LeaveApplication.Type;

//A concrete handler
public class Manager extends Employee {

	public Manager(LeaveApprover successor) {
		super("Manager", successor);
	}

	@Override
	protected boolean processRequest(LeaveApplication application) {
		if (Type.SICK.equals(application.getType())
				|| (Type.PTO.equals(application.getType()) && application.getNoOfDays() <= 5)) {
			application.approve(getApproverRole());
			return true;
		}
		return false;
	}

}
