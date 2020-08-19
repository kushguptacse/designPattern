package creational.object.pool;

import java.util.Arrays;

import javafx.geometry.Point2D;

public class ClientApplication {

	public static void main(String[] args) {
		ObjectPool<BitMap> pool = new ObjectPool<>(Arrays.asList(new BitMap("file1.bmp"), new BitMap("file2.bmp")));
		BitMap map1 = pool.get();
		map1.setLocation(new Point2D(10, 10));

		BitMap map2 = pool.get();
		map2.setLocation(new Point2D(12, 12));

		map1.draw();
		map2.draw();

		pool.release(map1);
		pool.release(map2);

	}

}
