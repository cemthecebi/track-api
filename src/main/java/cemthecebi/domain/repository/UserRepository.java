package cemthecebi.domain.repository;

import cemthecebi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String username);

    User findByEmail(String username);

}
