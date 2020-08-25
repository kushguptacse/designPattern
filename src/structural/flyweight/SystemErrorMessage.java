package structural.flyweight;

//flyweight concrete class. Instance is shared
public class SystemErrorMessage implements ErrorMessage {

	// intrinsic state which can be shared among various objects.
	// and they remain same throughout
	// some error message $errorCode
	private String messageTemplate;

	// http://somedomain.com/help?error=
	private String helpUrlBase;

	public SystemErrorMessage(String messageTemplate, String helpUrlBase) {
		this.messageTemplate = messageTemplate;
		this.helpUrlBase = helpUrlBase;
	}

	@Override
	// code as extrinsic state passed by client
	public String getText(String errorCode) {
		return messageTemplate.replace("$errorCode", errorCode) + helpUrlBase + errorCode;
	}

}
