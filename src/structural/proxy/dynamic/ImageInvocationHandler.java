package structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javafx.geometry.Point2D;

//Implement invocation handler. Your "proxy" code goes here.
public class ImageInvocationHandler implements InvocationHandler {

	private static Method getLocationMethod;
	private static Method setLocationMethod;
	private static Method renderMethod;
	private String name;
	private Point2D location;
	private BitMapImage image;

	// Cache Methods for later comparison
	static {
		try {
			setLocationMethod = Image.class.getMethod("setLocation", new Class[] { Point2D.class });
			getLocationMethod = Image.class.getMethod("getLocation");
			renderMethod = Image.class.getMethod("render");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public ImageInvocationHandler(String name) {
		this.name = name;
	}

	// This method is called for every method invocation on the proxy
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoking method: " + method.getName());
		if (getLocationMethod.equals(method)) {
			return handleGetLocalation();
		} else if (setLocationMethod.equals(method)) {
			handleSetLocation(args);
		} else if (renderMethod.equals(method)) {
			handleRender();
		}
		return null;
	}

	private void handleRender() {
		if (image == null) {
			image = new BitMapImage(name);
			image.setLocation(location);
		}
		image.render();
	}

	private void handleSetLocation(Object[] args) {
		if (image == null) {
			location = (Point2D) args[0];
		} else {
			image.setLocation((Point2D) args[0]);
		}
	}

	private Object handleGetLocalation() {
		return image == null ? location : image.getLocation();
	}

}
