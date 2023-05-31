package team.simpleVirtualWallet.beUser.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

    private String errorCode;
    private LocalDateTime timeStamp;
    private String message;
    private HttpStatus httpStatus;
    private String details;
}
