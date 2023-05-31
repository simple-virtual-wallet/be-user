package team.simpleVirtualWallet.beUser.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import team.simpleVirtualWallet.beUser.dto.AddUserRequestDto;
import team.simpleVirtualWallet.beUser.dto.AddUserResponseDto;
import team.simpleVirtualWallet.beUser.dto.GetUserRequestDto;
import team.simpleVirtualWallet.beUser.dto.GetUserResponseDto;
import team.simpleVirtualWallet.beUser.service.UserService;

//@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<AddUserResponseDto> addUsers(@Valid @RequestBody AddUserRequestDto req) {

        var id = userService.addUser(req.getUser());
        return new ResponseEntity<AddUserResponseDto>(new AddUserResponseDto(id), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<GetUserResponseDto> getUser(@Valid @RequestBody GetUserRequestDto req) {

        var user = userService.getUser(req.getId(), req.getAccount(), req.getMail(), req.getPhone());
        if(user.isPresent()) {
            return new ResponseEntity<GetUserResponseDto>(new GetUserResponseDto(
            new GetUserResponseDto.User(
                    user.get().getId(),
                    user.get().getAccount(),
                    user.get().getMail(),
                    user.get().getPhone()
                )
            ), HttpStatus.OK);
        }

        return new ResponseEntity<GetUserResponseDto>(new GetUserResponseDto(null), HttpStatus.OK);
    }

}
