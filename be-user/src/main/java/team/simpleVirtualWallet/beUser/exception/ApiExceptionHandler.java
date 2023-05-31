package team.simpleVirtualWallet.beUser.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetail> methodArgumentNotValidException(MethodArgumentNotValidException e,WebRequest req) {

        ErrorDetail err = new ErrorDetail(
                "ERR002",
                LocalDateTime.now(),
                "Validation Error",
                HttpStatus.BAD_REQUEST,
                e.getBindingResult().getFieldError().getDefaultMessage()) ;

        return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDetail> dataIntegrityViolationException(DataIntegrityViolationException e, WebRequest req) {

        ErrorDetail err = new ErrorDetail(
                "ERR001",
                LocalDateTime.now(),
                "SQL Error",
                HttpStatus.BAD_REQUEST,
                e.getMessage()) ;

        return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
    }
}
