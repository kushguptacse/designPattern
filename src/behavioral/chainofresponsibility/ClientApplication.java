package behavioral.chainofresponsibility;

import java.time.LocalDate;

import behavioral.chainofresponsibility.LeaveApplication.Type;

public class ClientApplication {
	public static void main(String[] args) {
		LeaveApplication application = LeaveApplication.getBuilder().from(LocalDate.now()).to(LocalDate.of(2020, 9, 9))
				.withType(Type.SICK).build();
		System.out.println(application);
		LeaveApprover leaveApprover = createChain();
		System.out.println("*********");
		leaveApprover.processLeaveApplication(application);
		System.out.println(application);
	}

	private static LeaveApprover createChain() {
		LeaveApprover director = new Director(null);
		LeaveApprover manager = new Manager(director);
		return new ProjectLead(manager);
	}
}
