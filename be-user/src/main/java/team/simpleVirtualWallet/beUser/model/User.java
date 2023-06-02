package team.simpleVirtualWallet.beUser.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "account is null.")
    @NotBlank(message = "account is blank.")
    @NotEmpty(message = "account is empty.")
    private String account;

    private String passwordHash;

    @Email()
    private String mail;

    @NotNull(message = "phone is null.")
    @NotBlank(message = "phone is blank.")
    @NotEmpty(message = "phone is empty.")
    private String phone;

}
