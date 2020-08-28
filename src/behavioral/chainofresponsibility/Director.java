package behavioral.chainofresponsibility;

import behavioral.chainofresponsibility.LeaveApplication.Type;
//A concrete handler
public class Director extends Employee {

	public Director(LeaveApprover successor) {
		super("Director", successor);
	}

	@Override
	protected boolean processRequest(LeaveApplication application) {
		if (Type.PTO.equals(application.getType())) {
			application.approve(getApproverRole());
			return true;
		}
		return false;
	}

}
