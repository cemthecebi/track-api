package cemthecebi.domain.repository;

import cemthecebi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserName(String username);

    User findByUserName(String username);

    @Transactional
    void deleteByUserName(String username);

}
