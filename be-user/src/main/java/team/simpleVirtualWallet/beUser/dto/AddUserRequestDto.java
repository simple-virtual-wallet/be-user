package team.simpleVirtualWallet.beUser.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.simpleVirtualWallet.beUser.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequestDto {
    @Valid
    private User user;
}
