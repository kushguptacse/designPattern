package structural.proxy.dynamic;

import java.lang.reflect.Proxy;

//factory to give original or proxy object
public class ImageFactory {

	private ImageFactory() {
	}

	public static Image getInstance(String name) {
		return (Image) Proxy.newProxyInstance(ImageFactory.class.getClassLoader(), new Class[] { Image.class },
				new ImageInvocationHandler(name));
	}

}
