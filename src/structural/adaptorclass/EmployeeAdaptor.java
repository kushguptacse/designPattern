package structural.adaptorclass;

public class EmployeeAdaptor extends Employee implements Customer {

	@Override
	public String getDesignation() {
		return getJobTitle();
	}

	@Override
	public String getName() {
		return getFullName();
	}

	@Override
	public String getAddress() {
		return getOfficeLocation();
	}

}
