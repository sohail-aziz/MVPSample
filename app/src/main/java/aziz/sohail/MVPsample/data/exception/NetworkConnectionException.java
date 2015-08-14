package aziz.sohail.MVPsample.data.exception;

/**
 * Created by Sohail Aziz on 8/9/2015.
 */
public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(String detailMessage) {
        super(detailMessage);
    }

    public NetworkConnectionException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public NetworkConnectionException(Throwable throwable) {
        super(throwable);
    }
}
