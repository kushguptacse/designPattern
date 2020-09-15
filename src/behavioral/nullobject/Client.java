package behavioral.nullobject;

public class Client {
	public static void main(String[] args) {
//		ComplexService service = new ComplexService("simpleReport", new StorageService());
		ComplexService service = new ComplexService("simpleReport", new NullStorageService());
		service.generateReport();
		
	}
}
