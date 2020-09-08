package behavioral.interpreter;

public class Client {

	public static void main(String[] args) {
		Report report = new Report("cashflow report", "FINANACE OR Admin");
		ExpressionBuilder builder = new ExpressionBuilder();
		PermissionExpression expression = builder.build(report);
		System.out.println(expression);
		System.out.println(expression.interpret(new User("Kush", "USER", "ADMIN")));
	}

}
