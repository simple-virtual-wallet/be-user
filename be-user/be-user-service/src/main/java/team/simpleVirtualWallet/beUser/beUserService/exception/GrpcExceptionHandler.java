package team.simpleVirtualWallet.beUser.beUserService.exception;

import com.google.rpc.ErrorInfo;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;

@GrpcAdvice
public class GrpcExceptionHandler {

    @net.devh.boot.grpc.server.advice.GrpcExceptionHandler
    public Status handleInvalidArgument(IllegalArgumentException e) {
        return Status.INVALID_ARGUMENT.withDescription("Your description").withCause(e);
    }


    @net.devh.boot.grpc.server.advice.GrpcExceptionHandler
    public Status handleVerifyUserException(VerifyUserException e) {
        var statusBuilder = com.google.rpc.Status.newBuilder();

        switch(e.getType()) {
            case NoSuchUser:
                return Status.NOT_FOUND.withDescription(
                        ErrorInfo.newBuilder()
                                .setReason(e.getMessage())
                                .setDomain(e.getDomain())
                                .putMetadata("errorCode", "ERR005")
                                .putMetadata("timestamp", e.getTimestamp().toString())
                                .build().toString()
                ).withCause(e);
            case WrongPassword:
                return Status.UNAVAILABLE.withDescription(
                        ErrorInfo.newBuilder()
                                .setReason(e.getMessage())
                                .setDomain(e.getDomain())
                                .putMetadata("errorCode", "ERR004")
                                .putMetadata("timestamp", e.getTimestamp().toString())
                                .build().toString()
                ).withCause(e);
        }
        return Status.UNKNOWN.withCause(e);
    }
}
