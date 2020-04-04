package cemthecebi.domain.service;

import cemthecebi.application.model.mapper.UserLoginResponseMapper;
import cemthecebi.application.model.mapper.UserRegisterResponseMapper;
import cemthecebi.application.model.request.UserLoginRequest;
import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.application.model.response.UserLoginResponse;
import cemthecebi.application.model.response.UserRegisterResponse;
import cemthecebi.domain.entity.User;
import cemthecebi.domain.exception.CustomException;
import cemthecebi.domain.model.converter.UserRegisterRequestToUserConverter;
import cemthecebi.domain.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserRegisterRequestToUserConverter userRegisterRequestToUserConverter;
    private final UserLoginResponseMapper userLoginResponseMapper;
    private final UserRegisterResponseMapper userRegisterResponseMapper;

    public UserService(UserRepository userRepository,
                       AuthenticationManager authenticationManager,
                       UserRegisterRequestToUserConverter userRegisterRequestToUserConverter,
                       UserLoginResponseMapper userLoginResponseMapper,
                       UserRegisterResponseMapper userRegisterResponseMapper) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userRegisterRequestToUserConverter = userRegisterRequestToUserConverter;
        this.userLoginResponseMapper = userLoginResponseMapper;
        this.userRegisterResponseMapper = userRegisterResponseMapper;
    }

    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword()));
            User user = userRepository.findByEmail(userLoginRequest.getEmail());
            return userLoginResponseMapper.map(user);
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        boolean isUserNotExist = !userRepository.existsByEmail(userRegisterRequest.getEmail());
        if (isUserNotExist) {
            User user = userRegisterRequestToUserConverter.convert(userRegisterRequest);
            User savedUser = userRepository.save(user);
            return userRegisterResponseMapper.map(savedUser);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

//    public void delete(String username) {
//        userRepository.deleteByUserName(username);
//    }

//    public User search(String username) {
//        User user = userRepository.findByUserName(username);
//        if (user == null) {
//            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
//        }
//        return user;
//    }
//
//    public User whoami(HttpServletRequest req) {
//        return userRepository.findByUserName(jwtTokenProvirder.getEmail(jwtTokenProvider.resolveToken(req)));
//    }
//
//    public String refresh(String username) {
//        return jwtTokenProvider.createToken(username, userRepository.findByUserName(username).getRoles());
//    }

}
