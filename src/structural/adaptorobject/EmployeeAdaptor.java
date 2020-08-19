package structural.adaptorobject;

public class EmployeeAdaptor implements Customer {

	private Employee employee;

	public EmployeeAdaptor(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String getDesignation() {
		return employee.getJobTitle();
	}

	@Override
	public String getName() {
		return employee.getFullName();
	}

	@Override
	public String getAddress() {
		return employee.getOfficeLocation();
	}

}
