package nigeriandailies.com.ng.forum.forum.repository;

import nigeriandailies.com.ng.forum.forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByCreatorId(Long id);
}
