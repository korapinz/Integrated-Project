package sit.int204.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.backend.entities.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
}