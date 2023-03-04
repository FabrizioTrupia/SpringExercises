package co.develhope.loginDemo.auth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestorePasswordDTO {

    private String newPassword;
    private String resetPasswordCode;

}
