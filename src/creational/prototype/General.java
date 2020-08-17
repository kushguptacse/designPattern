package creational.prototype;

//Doesn't support cloning
public class General extends GameUnit {

	private String state = "idle";

	public void boostMorale() {
		this.state = "MoralBoost";
	}

	@Override
	protected void reset() {
		throw new UnsupportedOperationException("Reset not supported");
	}

	@Override
	public General clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Ganerals are unique");
	}

	@Override
	public String toString() {
		return "General " + state + " @ " + getPosition();
	}

}
