package team.simpleVirtualWallet.beUser.beUserService.dto;

import javax.validation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.simpleVirtualWallet.beUser.beUserService.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequestDto {
    @Valid
    private User user;
}
