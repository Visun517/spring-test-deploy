package lk.ijse.gdse71.back_end.exception;

import lk.ijse.gdse71.back_end.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return new ResponseEntity<>(
                new ApiResponse(500, "An error occurred: " + e.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(ResourceNoteFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNoteFoundException e) {
        return new ResponseEntity<>(
                new ApiResponse(404, e.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<ApiResponse> handleUserAlreadyExist(UserAlreadyExist e) {
        return new ResponseEntity<>(
                new ApiResponse(409, e.getMessage(), null),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String , String > error =  new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(errorField -> {
            error.put(errorField.getField(), errorField.getDefaultMessage());
        });
        return new ResponseEntity<>(
                new ApiResponse(400, "Validation error", error),
                HttpStatus.BAD_REQUEST
        );
    }
}
