package behavioral.iterator;

public class ClientApp {
	public static void main(String[] args) {
		Iterator<ThemeColor> iterator = ThemeColor.getIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
