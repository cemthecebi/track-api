package cemthecebi.application.controller;

import cemthecebi.application.model.request.UserLoginRequest;
import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.application.model.response.UserLoginResponse;
import cemthecebi.application.model.response.UserRegisterResponse;
import cemthecebi.domain.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.login(userLoginRequest);
    }

    @PostMapping("/register")
    public UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

//    @DeleteMapping(value = "/{username}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String delete(@PathVariable(value = "username") String username) {
//        userService.delete(username);
//        return username;
//    }
}
