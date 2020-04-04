package cemthecebi.application.model.response;

import lombok.Data;

@Data
public class UserLoginResponse extends Response {

    public String jwtToken;

}
