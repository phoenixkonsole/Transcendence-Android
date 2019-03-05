package transcendence.org.transcendencewallet.rate;

/**
 * Created by akshaynexus on 7/5/17.
 */
public class RequestTranscendenceRateException extends Exception {
    public RequestTranscendenceRateException(String message) {
        super(message);
    }

    public RequestTranscendenceRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestTranscendenceRateException(Exception e) {
        super(e);
    }
}
