package cemthecebi;

import cemthecebi.application.controller.UserRegisterRequest;
import cemthecebi.domain.model.Role;
import cemthecebi.domain.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class TrackApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TrackApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {
        UserRegisterRequest admin = new UserRegisterRequest();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@email.com");
        admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

        userService.signup(admin);

        UserRegisterRequest client = new UserRegisterRequest();
        client.setUsername("client");
        client.setPassword("client");
        client.setEmail("client@email.com");
        client.setRoles(new ArrayList<Role>(Collections.singletonList(Role.ROLE_CLIENT)));

        userService.signup(client);
    }

}
