package cemthecebi.domain.service;

import cemthecebi.application.model.mapper.UserRegisterResponseMapper;
import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.application.model.response.UserRegisterResponse;
import cemthecebi.domain.entity.User;
import cemthecebi.domain.exception.CustomException;
import cemthecebi.domain.model.converter.UserRegisterRequestToUserConverter;
import cemthecebi.domain.repository.UserRepository;
import cemthecebi.infrastructure.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserRegisterRequestToUserConverter userRegisterRequestToUserConverter;
    private final UserRegisterResponseMapper userRegisterResponseMapper;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtTokenProvider jwtTokenProvider,
                       AuthenticationManager authenticationManager,
                       UserRegisterRequestToUserConverter userRegisterRequestToUserConverter,
                       UserRegisterResponseMapper userRegisterResponseMapper) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userRegisterRequestToUserConverter = userRegisterRequestToUserConverter;
        this.userRegisterResponseMapper = userRegisterResponseMapper;
    }

    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUserName(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        boolean isUserNotExist = !userRepository.existsByUserName(userRegisterRequest.getUsername());
        if (isUserNotExist) {
            User user = userRegisterRequestToUserConverter.convert(userRegisterRequest);
            User savedUser = userRepository.save(user);
            return userRegisterResponseMapper.map(savedUser);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUserName(username);
    }

    public User search(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUserName(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUserName(username).getRoles());
    }

}
