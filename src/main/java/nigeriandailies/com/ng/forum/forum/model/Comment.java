package nigeriandailies.com.ng.forum.forum.model;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@ComponentScan
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
@Column(nullable = false)
    private String text;

    @ManyToOne(targetEntity = Post.class)
    private Post post;

    @ManyToOne(targetEntity = User.class)
    private User creator;

    public Comment() {
    }

    public Comment(String text, Post post, User creator) {
        this.text = text;
        this.post = post;
        this.creator = creator;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
