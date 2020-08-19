package structural.adaptorobject;

public class MainApplication {

	public static void main(String[] args) {
		Employee emp = new Employee();
		populateEmployee(emp);
		EmployeeAdaptor adp = new EmployeeAdaptor(emp);
		System.out.println(new BuisnessCardDesigner().designCard(adp));
	}

	private static void populateEmployee(Employee emp) {
		emp.setFullName("kush gupta");
		emp.setJobTitle("SSE");
		emp.setOfficeLocation("Noida");
	}

}
