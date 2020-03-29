package cemthecebi.application.controller;

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

    @PostMapping("/signin")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return userService.signin(username, password);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userService.signup(userRegisterRequest);
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable(value = "username") String username) {
        userService.delete(username);
        return username;
    }
}
