package solid.interfacesegregation.principle.before;

public class Order extends Entity {

	private double totalValue;

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}
