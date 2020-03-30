package cemthecebi.domain.model.converter;

import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.domain.entity.User;
import cemthecebi.domain.model.enumtype.Role;
import cemthecebi.domain.model.enumtype.Status;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

@Component
public class UserRegisterRequestToUserConverter {

    private final PasswordEncoder passwordEncoder;

    public UserRegisterRequestToUserConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User convert(UserRegisterRequest userRegisterRequest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        User user = new User();
        user.setCreateDate(dateTimeFormatter.format(localDateTime));
        user.setStatus(Status.ACTIVE.name());
        user.setName(userRegisterRequest.getName());
        user.setSurname(userRegisterRequest.getSurname());
        user.setUserName(userRegisterRequest.getUsername());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        user.setGsmNumber(userRegisterRequest.getGsmNumber());
        user.setRoles(new ArrayList<>(Collections.singletonList(Role.ROLE_CLIENT)));
        return user;
    }
}
