package team.simpleVirtualWallet.beUser.beUserService.exception;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
public class VerifyUserException extends RuntimeException {

    public enum VerifyUserExceptionType {
        None,
        Unknown,
        NoSuchUser,
        WrongPassword
    }

    private VerifyUserExceptionType type;

    @Setter
    private String domain = "";

    public VerifyUserException domain(String domain) {
        this.domain = domain;
        return this;
    }

    private Timestamp timestamp;
    public VerifyUserException(VerifyUserExceptionType type, String message) {
        super(message);
        this.type = type;
        timestamp = new Timestamp(System.currentTimeMillis());
    }
}
