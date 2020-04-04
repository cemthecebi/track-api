package cemthecebi.application.model.request;

import cemthecebi.domain.model.enumtype.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserRegisterRequest {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String gsmNumber;
    List<Role> roles;
}
