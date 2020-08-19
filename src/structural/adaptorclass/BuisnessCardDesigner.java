package structural.adaptorclass;

/**
 * Client which uses Target object Customer
 *
 */
public class BuisnessCardDesigner {

	public String designCard(Customer customer) {
		return customer.getName() + ", " + customer.getDesignation() + ", " + customer.getAddress();
	}

}
