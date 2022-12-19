public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error objectNull = new Error();
        Error objectTrue = new Error(true, 1, "start");
        Error objectFalse = new Error(false, 2, "start");
        objectNull.info();
        objectTrue.info();
        objectFalse.info();
    }

    public void info() {
        System.out.println("active " + this.active);
        System.out.println("status " + this.status);
        System.out.println("message " + this.message);
    }
}
