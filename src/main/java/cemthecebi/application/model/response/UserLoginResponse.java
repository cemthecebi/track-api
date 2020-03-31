package cemthecebi.application.model.response;

public class UserLoginResponse extends Response {

    public String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
