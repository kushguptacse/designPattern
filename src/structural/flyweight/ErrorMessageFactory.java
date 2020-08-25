package structural.flyweight;

import java.util.EnumMap;
import java.util.Map;

public class ErrorMessageFactory {

	// This serves as key for getting flyweight instance
	public enum ErrorType {
		GENERICSYSTEMERROR, PAGENOTFOUNDERROR, SERVERERROR
	};

	private static final ErrorMessageFactory INSTANCE = new ErrorMessageFactory();

	// This serves as key for getting flyweight instance
	private Map<ErrorType, SystemErrorMessage> errorMessages = new EnumMap<>(ErrorType.class);

	private ErrorMessageFactory() {
		errorMessages.put(ErrorType.GENERICSYSTEMERROR, new SystemErrorMessage(
				"A generic error of type $errorCode occured. Please refer to:\n", "http://google.com/q="));
		errorMessages.put(ErrorType.PAGENOTFOUNDERROR, new SystemErrorMessage(
				"Page not foun. An error of type $errorCode occurred. Please refer to:\n", "http://google.com/q="));
	}

	public static ErrorMessageFactory getInstance() {
		return INSTANCE;
	}

	public SystemErrorMessage getError(ErrorType type) {
		return errorMessages.get(type);
	}
	
	public UserBannedErrorMessage getUserBannedMessage(String caseId) {
		return new UserBannedErrorMessage(caseId);
	}
	
}
