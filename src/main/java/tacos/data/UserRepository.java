package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
