package web.name.placeholder.repositories;

import org.springframework.data.repository.CrudRepository;
import web.name.placeholder.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
