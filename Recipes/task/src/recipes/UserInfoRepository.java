package recipes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<User, Long> {

    Optional<User> getUserByEmail(String email);

    boolean existsUserById(long id);

}
