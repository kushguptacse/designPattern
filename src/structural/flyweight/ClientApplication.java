package structural.flyweight;

import structural.flyweight.ErrorMessageFactory.ErrorType;

public class ClientApplication {
	public static void main(String[] args) {
		ErrorMessage errorMessage1 = ErrorMessageFactory.getInstance().getError(ErrorType.GENERICSYSTEMERROR);
		System.out.println(errorMessage1.getText("501"));

		System.out.println("*****************");
		
		ErrorMessage errorMessage2 = ErrorMessageFactory.getInstance().getUserBannedMessage("1202");
		System.out.println(errorMessage2.getText(null));
	}
}
