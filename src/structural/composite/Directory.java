package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * composite
 */
public class Directory extends File {

	private List<File> children = new ArrayList<>();

	public Directory(String name) {
		super(name);
	}

	@Override
	public void ls() {
		System.out.println(this.getName());
		//delegates operation to its children
		children.forEach(File::ls);
	}

	@Override
	public void addFile(File file) {
		children.add(file);
	}

	@Override
	public boolean removeFile(File file) {
		return children.remove(file);
	}

	@Override
	public File[] getFiles() {
		return children.toArray(new File[children.size()]);
	}

}
