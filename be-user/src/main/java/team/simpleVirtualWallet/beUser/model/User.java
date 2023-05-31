package team.simpleVirtualWallet.beUser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
