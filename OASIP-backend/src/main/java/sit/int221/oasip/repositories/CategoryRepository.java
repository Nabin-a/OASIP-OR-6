package sit.int221.oasip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int221.oasip.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}