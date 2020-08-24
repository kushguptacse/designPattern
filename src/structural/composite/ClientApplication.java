package structural.composite;

public class ClientApplication {

	public static void main(String[] args) {
		File root = createTree();
		root.ls();
		System.out.println("********************************");
		File file4 = new BinaryFile("file4", 290);
		file4.ls();
		root.addFile(file4);
		System.out.println(file4+ " removed: "+root.removeFile(file4));
	}

	private static File createTree() {
		File dir1 = new Directory("dir1");
		File file1 = new BinaryFile("file1", 10);
		File file2 = new BinaryFile("file2", 20);
		dir1.addFile(file1);
		dir1.addFile(file2);
		File dir2 = new Directory("dir2");
		dir1.addFile(dir2);
		File file3 = new BinaryFile("file3", 20);
		dir1.addFile(file3);
		return dir1;
	}

}
