package structural.proxy.part1;

//factory to give original or proxy object
public class ImageFactory {

	private ImageFactory() {

	}

	public static Image getInstance(String name) {
		// here we can use property to decide if we want to return original or proxy
		return new ImageProxy(name);
	}

}
