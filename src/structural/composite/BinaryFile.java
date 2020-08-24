package structural.composite;

/**
 * act as leaf
 */
public class BinaryFile extends File {

	private long size;

	public BinaryFile(String name, long size) {
		super(name);
		this.size = size;
	}

	@Override
	public void ls() {
		System.out.println(getName() + " " + size);
	}

	@Override
	public void addFile(File file) {
		throw new UnsupportedOperationException("add file not supported at leaf level");
	}

	@Override
	public String toString() {
		return "BinaryFile [name=" + getName() + "]";
	}

	@Override
	public boolean removeFile(File file) {
		throw new UnsupportedOperationException("remove file not supported at leaf level");
	}

	@Override
	public File[] getFiles() {
		throw new UnsupportedOperationException("get files not supported at leaf level");
	}

}
