package cemthecebi;

import cemthecebi.application.model.request.UserRegisterRequest;
import cemthecebi.domain.entity.Category;
import cemthecebi.domain.entity.TvShow;
import cemthecebi.domain.model.enumtype.Role;
import cemthecebi.domain.model.enumtype.Status;
import cemthecebi.domain.model.enumtype.TVShowStatus;
import cemthecebi.domain.repository.CategoryRepository;
import cemthecebi.domain.repository.TvShowRepository;
import cemthecebi.domain.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
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

    @Autowired
    TvShowRepository tvShowRepository;

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
        addMovies(dateTimeFormatter, localDateTime);
    }

    private void addMovies(DateTimeFormatter dateTimeFormatter, LocalDateTime localDateTime) {
        TvShow gameOfThrones = new TvShow();
        gameOfThrones.setCreateDate(dateTimeFormatter.format(localDateTime));
        gameOfThrones.setStatus(Status.ACTIVE.name());
        gameOfThrones.setImageLink("https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SY1000_CR0,0,734,1000_AL_.jpg");
        gameOfThrones.setTvShowStatus(TVShowStatus.ENDED);
        gameOfThrones.setTitle("Game of Thrones");
        gameOfThrones.setStartDate("2011");
        gameOfThrones.setEndDate("2019");
        gameOfThrones.setDescription("Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.\n");
        gameOfThrones.setCountry("USA");
        gameOfThrones.setLanguage("English");
        gameOfThrones.setEpisodeCount(BigDecimal.valueOf(73));
        gameOfThrones.setSeasonCount(BigDecimal.valueOf(8));
        gameOfThrones.setAverageEpisodeLength(BigDecimal.valueOf(60));
        gameOfThrones.setViewCount(BigDecimal.valueOf(870));
        gameOfThrones.setFollowCount(BigDecimal.valueOf(1000));
        gameOfThrones.setLikeCount(BigDecimal.valueOf(750));
        gameOfThrones.setDislikeCount(BigDecimal.valueOf(10));
        tvShowRepository.save(gameOfThrones);

        TvShow sonsOfAnarchy = new TvShow();
        sonsOfAnarchy.setCreateDate(dateTimeFormatter.format(localDateTime));
        sonsOfAnarchy.setStatus(Status.ACTIVE.name());
        sonsOfAnarchy.setImageLink("https://m.media-amazon.com/images/M/MV5BMTEyODg2NzkwMDBeQTJeQWpwZ15BbWU4MDQwODI3MzIx._V1_.jpg");
        sonsOfAnarchy.setTvShowStatus(TVShowStatus.ENDED);
        sonsOfAnarchy.setTitle("Sons of Anarchy");
        sonsOfAnarchy.setStartDate("2008");
        sonsOfAnarchy.setEndDate("2014");
        sonsOfAnarchy.setDescription("A biker struggles to balance being a father and being involved in an outlaw motorcycle club.\n");
        sonsOfAnarchy.setCountry("USA");
        sonsOfAnarchy.setLanguage("English");
        sonsOfAnarchy.setEpisodeCount(BigDecimal.valueOf(92));
        sonsOfAnarchy.setSeasonCount(BigDecimal.valueOf(7));
        sonsOfAnarchy.setAverageEpisodeLength(BigDecimal.valueOf(45));
        sonsOfAnarchy.setViewCount(BigDecimal.valueOf(934));
        sonsOfAnarchy.setFollowCount(BigDecimal.valueOf(1345));
        sonsOfAnarchy.setLikeCount(BigDecimal.valueOf(1000));
        sonsOfAnarchy.setDislikeCount(BigDecimal.valueOf(2));
        tvShowRepository.save(sonsOfAnarchy);

        TvShow dexter = new TvShow();
        dexter.setCreateDate(dateTimeFormatter.format(localDateTime));
        dexter.setStatus(Status.ACTIVE.name());
        dexter.setImageLink("https://m.media-amazon.com/images/M/MV5BMTM5MjkwMTI0MV5BMl5BanBnXkFtZTcwODQwMTc0OQ@@._V1_.jpg");
        dexter.setTvShowStatus(TVShowStatus.ENDED);
        dexter.setTitle("Dexter");
        dexter.setStartDate("2006");
        dexter.setEndDate("2013");
        dexter.setDescription("By day, mild-mannered Dexter is a blood-spatter analyst for the Miami police. But at night, he is a serial killer who only targets other murderers.");
        dexter.setCountry("USA");
        dexter.setLanguage("English");
        dexter.setEpisodeCount(BigDecimal.valueOf(96));
        dexter.setSeasonCount(BigDecimal.valueOf(8));
        dexter.setAverageEpisodeLength(BigDecimal.valueOf(50));
        dexter.setViewCount(BigDecimal.valueOf(500));
        dexter.setFollowCount(BigDecimal.valueOf(356));
        dexter.setLikeCount(BigDecimal.valueOf(803));
        dexter.setDislikeCount(BigDecimal.valueOf(300));
        tvShowRepository.save(dexter);
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
