package behavioral.chainofresponsibility;

import behavioral.chainofresponsibility.LeaveApplication.Type;
//A concrete handler
public class ProjectLead extends Employee {

	public ProjectLead(LeaveApprover successor) {
		super("Project Lead", successor);
	}

	@Override
	protected boolean processRequest(LeaveApplication application) {
		if (Type.SICK.equals(application.getType()) && application.getNoOfDays() < 2) {
			application.approve(getApproverRole());
			return true;
		}
		return false;
	}

}
