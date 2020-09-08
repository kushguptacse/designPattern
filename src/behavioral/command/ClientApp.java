package behavioral.command;

public class ClientApp {

	public static void main(String[] args) throws InterruptedException {
		EWSService receiver = new EWSService();
		Command command1 = new AddMemberCommand("a@a", "spam", receiver);
		MailTasksRunner.getInstance().addCommand(command1);
		Command command2 = new AddMemberCommand("b@b", "spam", receiver);
		MailTasksRunner.getInstance().addCommand(command2);
		Thread.sleep(4000);
		MailTasksRunner.getInstance().shutdown();
	}

}
