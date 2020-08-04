package creational.simple.factory;

public class Client {
	public static void main(String[] args) {
		Post post = PostFactory.getPost("product");
		System.out.println(post);
	}
}
