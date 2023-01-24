package sit.int221.oasip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sit.int221.oasip.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByName (String name);
    public boolean existsByEmail (String email);

    @Query(value = "select * from user u where u.email = :email",nativeQuery = true)
    public User findByEmail (@Param("email") String email);

    @Query(value = "select * from user u where u.role = :role",nativeQuery = true)
    public User findByRole(@Param("role") String role);
    public boolean existsByNameAndUserIdNot(String name, Integer userId);
    public boolean existsByEmailAndUserIdNot(String email, Integer userId);
}