package cemthecebi.application.controller;

import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.application.model.response.Response;
import cemthecebi.application.model.response.UserRegisterResponse;
import cemthecebi.domain.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable(value = "username") String username) {
        userService.delete(username);
        return username;
    }
}
