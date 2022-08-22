package sit.int221.oasip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasip.dto.userdto.UserDtoCreate;
import sit.int221.oasip.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByName (String string);
    public boolean existsByEmail (String email);
    public User findByName (String name);
    public User findByEmail (String email);
}