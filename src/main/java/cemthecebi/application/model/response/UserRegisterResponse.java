package cemthecebi.application.model.response;

import lombok.Data;

@Data
public class UserRegisterResponse extends Response {

    public String jwtToken;
}
