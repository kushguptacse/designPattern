package creational.simple.factory;

public class PostFactory {

	public static Post getPost(String postType) {
		switch (postType) {
		case "blog":
			return new BlogPost();
		case "product":
			return new ProductPost();
		default:
			throw new IllegalArgumentException("invalid post type passed");
		}
	}

}
