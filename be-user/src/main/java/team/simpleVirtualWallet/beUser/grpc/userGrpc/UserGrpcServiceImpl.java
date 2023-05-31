package team.simpleVirtualWallet.beUser.grpc.userGrpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import team.simpleVirtualWallet.beUser.model.User;
import team.simpleVirtualWallet.beUser.service.UserService;

//https://yidongnan.github.io/grpc-spring-boot-starter/zh-CN/server/getting-started.html
@GrpcService
@Slf4j
public class UserGrpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    UserService userService;

    @Override
    public void createUser(UserGrpc.CreateUserReq req, StreamObserver<UserGrpc.CreateUserRes> responseObserver) {

        log.info("createUser: {}", req);

        var id = userService.addUser(User
            .builder()
            .account(req.getAccount())
            .passwordHash(req.getPassword())
            .mail(req.getMail())
            .phone(req.getPhone())
            .build());

        UserGrpc.CreateUserRes res = UserGrpc.CreateUserRes.newBuilder().setId(id).build();

        // 调用onNext()方法来通知gRPC框架把reply 从server端 发送回 client端
        responseObserver.onNext(res);

        // 表示完成调用
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(UserGrpc.GetUserReq req, StreamObserver<UserGrpc.GetUserRes> responseObserver) {

        log.info("getUser: {}", req);

        var user = userService.getUser(req.getId(), req.getAccount(), req.getMail(), req.getPhone());

        UserGrpc.GetUserRes res = UserGrpc
                .GetUserRes
                .newBuilder()
                .setUser(user.isPresent() ? UserGrpc.User.newBuilder()
                        .setId(user.get().getId())
                        .setAccount(user.get().getAccount())
                        .setMail(user.get().getMail())
                        .setPhone(user.get().getPhone())
                        .build()
                        : null
                ).build();

        // 调用onNext()方法来通知gRPC框架把reply 从server端 发送回 client端
        responseObserver.onNext(res);

        // 表示完成调用
        responseObserver.onCompleted();
    }

}



