package structural.adaptorclass;

public class MainApplication {

	public static void main(String[] args) {
		EmployeeAdaptor adp = new EmployeeAdaptor();
		populateEmployee(adp);
		System.out.println(new BuisnessCardDesigner().designCard(adp));
	}

	private static void populateEmployee(Employee emp) {
		emp.setFullName("kush gupta");
		emp.setJobTitle("SSE");
		emp.setOfficeLocation("Noida");
	}

}
