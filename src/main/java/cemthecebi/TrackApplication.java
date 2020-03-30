package cemthecebi;

import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.domain.model.enumtype.Role;
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
        admin.setName("admin");
        admin.setSurname("admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@email.com");
        admin.setGsmNumber("0000000000");

        admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

        userService.register(admin);

        UserRegisterRequest client = new UserRegisterRequest();
        client.setName("client");
        client.setSurname("client");
        client.setUsername("client");
        client.setPassword("client");
        client.setEmail("client@email.com");
        client.setGsmNumber("0000000001");
        client.setRoles(new ArrayList<Role>(Collections.singletonList(Role.ROLE_CLIENT)));

        userService.register(client);
    }

}
