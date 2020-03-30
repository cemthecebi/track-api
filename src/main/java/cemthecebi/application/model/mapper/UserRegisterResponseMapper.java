package cemthecebi.application.model.mapper;

import cemthecebi.application.model.response.Response;
import cemthecebi.application.model.response.UserRegisterResponse;
import cemthecebi.domain.entity.User;
import cemthecebi.infrastructure.security.JwtTokenProvider;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterResponseMapper extends Response {
    private final JwtTokenProvider jwtTokenProvider;

    public UserRegisterResponseMapper(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public UserRegisterResponse map(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setJwtToken(jwtTokenProvider.createToken(user.getUserName(), user.getRoles()));
        userRegisterResponse.setStatus("OK");
        return userRegisterResponse;
    }
}
