package behavioral.nullobject;

public class NullStorageService extends StorageService {

	@Override
	public void save(Report report) {
		System.out.println("Doing nothing");
	}

}
