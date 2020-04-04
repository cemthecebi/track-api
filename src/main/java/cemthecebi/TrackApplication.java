package cemthecebi;

import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.domain.entity.Category;
import cemthecebi.domain.model.enumtype.Role;
import cemthecebi.domain.model.enumtype.Status;
import cemthecebi.domain.repository.CategoryRepository;
import cemthecebi.domain.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class TrackApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrackApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        addUsers();
        addCategories(dateTimeFormatter, localDateTime);

    }

    private void addCategories(DateTimeFormatter dateTimeFormatter, LocalDateTime localDateTime) {
        Category category = new Category();
        category.setCreateDate(dateTimeFormatter.format(localDateTime));
        category.setStatus(Status.ACTIVE.name());
        category.setName("Action");
        category.setDescription("Best Action Tv Series");
        categoryRepository.save(category);

        Category category1 = new Category();
        category1.setCreateDate(dateTimeFormatter.format(localDateTime));
        category1.setStatus(Status.ACTIVE.name());
        category1.setName("Romance");
        category1.setDescription("Best Romance Tv Series");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setCreateDate(dateTimeFormatter.format(localDateTime));
        category2.setStatus(Status.ACTIVE.name());
        category2.setName("Sci-fi");
        category2.setDescription("Best Sci-fi Tv Series");

        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setCreateDate(dateTimeFormatter.format(localDateTime));
        category3.setStatus(Status.ACTIVE.name());
        category3.setName("Horror");
        category3.setDescription("Best Horror Tv Series");
        categoryRepository.save(category3);

        Category category4 = new Category();
        category4.setCreateDate(dateTimeFormatter.format(localDateTime));
        category4.setStatus(Status.ACTIVE.name());
        category4.setName("Fantasy");
        category4.setDescription("Best Fantasy Tv Series");
        categoryRepository.save(category4);
    }

    private void addUsers() {
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
