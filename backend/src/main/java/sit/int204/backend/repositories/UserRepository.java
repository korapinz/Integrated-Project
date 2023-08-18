package sit.int204.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.backend.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
