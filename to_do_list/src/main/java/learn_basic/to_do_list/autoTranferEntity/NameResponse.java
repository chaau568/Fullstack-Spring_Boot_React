package learn_basic.to_do_list.autoTranferEntity;

public class NameResponse {
    private String message;

    public NameResponse() {}

    public NameResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
