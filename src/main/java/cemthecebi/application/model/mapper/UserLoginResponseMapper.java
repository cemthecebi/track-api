package cemthecebi.application.model.mapper;

import cemthecebi.application.model.request.UserLoginRequest;
import cemthecebi.application.model.response.Response;
import cemthecebi.application.model.response.UserLoginResponse;
import cemthecebi.application.model.response.UserRegisterResponse;
import cemthecebi.domain.entity.User;
import cemthecebi.infrastructure.security.JwtTokenProvider;
import org.springframework.stereotype.Component;

@Component
public class UserLoginResponseMapper extends Response {
    private final JwtTokenProvider jwtTokenProvider;

    public UserLoginResponseMapper(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public UserLoginResponse map(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setJwtToken(jwtTokenProvider.createToken(user.getEmail(), user.getRoles()));
        userLoginResponse.setStatus("OK");
        return userLoginResponse;
    }
}
