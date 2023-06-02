package team.simpleVirtualWallet.beUser.dto;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserRequestDto {
    @Nullable
    private Integer id;

    @Nullable
    private String account;

    @Nullable
    private String mail;

    @Nullable
    private String phone;

    @AssertTrue(message = "at least 1 param is required")
    private boolean hasParam() {
        return id != null || account != null || mail != null || phone != null;
    }
}
