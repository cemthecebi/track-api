package cemthecebi.application.model.response;

public class UserRegisterResponse extends Response {

    public String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
