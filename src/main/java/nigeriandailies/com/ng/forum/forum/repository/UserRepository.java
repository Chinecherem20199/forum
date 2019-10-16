package nigeriandailies.com.ng.forum.forum.repository;

import nigeriandailies.com.ng.forum.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}