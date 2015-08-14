package aziz.sohail.MVPsample.data.exception;

/**
 * Created by Sohail Aziz on 8/9/2015.
 */
public class InvalidCredentialException extends Exception {
    public InvalidCredentialException() {
        super();
    }

    public InvalidCredentialException(String detailMessage) {
        super(detailMessage);
    }

    public InvalidCredentialException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InvalidCredentialException(Throwable throwable) {
        super(throwable);
    }
}
