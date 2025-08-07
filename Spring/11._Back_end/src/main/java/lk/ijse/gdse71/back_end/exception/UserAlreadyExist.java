package lk.ijse.gdse71.back_end.exception;


public class UserAlreadyExist extends RuntimeException {

    public UserAlreadyExist(String message) {
        super(message);
    }
}
