package team.simpleVirtualWallet.beUser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserResponseDto {


    @Data
    @AllArgsConstructor
    public static class User {
        private int id;
        private String account;
        private String mail;
        private String phone;
    }

    private User user;
}
