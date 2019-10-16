package nigeriandailies.com.ng.forum.forum.service;

import nigeriandailies.com.ng.forum.forum.model.Post;
import nigeriandailies.com.ng.forum.forum.model.User;
import nigeriandailies.com.ng.forum.forum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }

    public List<Post> findByUser(User user){
        return postRepository.findByCreatorId(user.getId());
    }

    public boolean deletePost(Long postId){
        Optional<Post> thePost = postRepository.findById(postId);
        if(thePost == null)
            return false;
        postRepository.deleteById(postId);
        return true;
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public Optional<Post> find(Long postId) {
        return postRepository.findById(postId);
    }
}
