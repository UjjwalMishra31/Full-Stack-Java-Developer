package JDBC.VID1DEMO1;

public class DuplicateOwnerException extends Exception {
    private static final long serialVersionUID = 1L;

    public DuplicateOwnerException(String message) {
        super(message);
    }
}
