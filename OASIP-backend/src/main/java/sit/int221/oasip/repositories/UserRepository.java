package sit.int221.oasip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasip.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByName (String name);
    public boolean existsByEmail (String email);
    public User findByName (String name);
    public User findByEmail (String email);
    public boolean existsByNameAndUserIdNot(String name, Integer userId);
    public boolean existsByEmailAndUserIdNot(String email, Integer userId);
    public boolean existsByPassword(String password);
}