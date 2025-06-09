package learn_basic.to_do_list.returnStatusCode;

public class UserExceptionStatus extends RuntimeException {
    public UserExceptionStatus(String message) {
        super(message);
    }
}
