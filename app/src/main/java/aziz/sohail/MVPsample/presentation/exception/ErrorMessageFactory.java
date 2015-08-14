package aziz.sohail.MVPsample.presentation.exception;

import android.content.Context;

import aziz.sohail.MVPsample.R;
import aziz.sohail.MVPsample.data.exception.InvalidCredentialException;
import aziz.sohail.MVPsample.data.exception.NetworkConnectionException;

/**
 * Created by Sohail Aziz on 8/9/2015.
 * Factory used to create Error message with exception as condition
 */
public class ErrorMessageFactory {

    private ErrorMessageFactory() {

    }

    /**
     * Creates a string representing an error message
     *
     * @param context   needed to retrieve the string
     * @param exception Exception as condition for error message
     * @return {@link java.lang.String} an error message
     */
    public static String create(Context context, Exception exception) {

        if (context == null) {
            throw new IllegalArgumentException();
        }

        String message = "Generic Error";

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.error_network);
        } else if (exception instanceof InvalidCredentialException) {
            message = context.getString(R.string.error_credentials);
        }

        return message;
    }
}
