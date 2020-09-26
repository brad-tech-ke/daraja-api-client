package brad.tech.api.safaricom.daraja;

/**
 * This provides exception handling functionalities to the client and subclasses.
 */
public interface ExceptionHandler {
    void handle(String message, Throwable exception);
}
