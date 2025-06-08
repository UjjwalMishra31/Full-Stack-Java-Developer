package JDBC.VID1DEMO1;

public class OwnerNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
