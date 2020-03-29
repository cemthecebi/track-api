package cemthecebi.domain.service;

import cemthecebi.application.controller.UserRegisterRequest;
import cemthecebi.domain.exception.CustomException;
import cemthecebi.domain.model.Role;
import cemthecebi.domain.model.User;
import cemthecebi.domain.repository.UserRepository;
import cemthecebi.infrastructure.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtTokenProvider jwtTokenProvider,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(UserRegisterRequest userRegisterRequest) {
        if (!userRepository.existsByUsername(userRegisterRequest.getUsername())) {

            User user = new User();
            user.setUsername(userRegisterRequest.getUsername());
            user.setEmail(userRegisterRequest.getEmail());
            user.setPassword(userRegisterRequest.getPassword());
            ArrayList<Role> roles = new ArrayList<>(Collections.singletonList(Role.ROLE_CLIENT));
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));

            userRepository.save(user);
            return jwtTokenProvider.createToken(userRegisterRequest.getUsername(), roles);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
    }

}
