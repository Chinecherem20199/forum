package nigeriandailies.com.ng.forum.forum;

import nigeriandailies.com.ng.forum.forum.config.CustomUserDetails;
import nigeriandailies.com.ng.forum.forum.model.Role;
import nigeriandailies.com.ng.forum.forum.model.User;
import nigeriandailies.com.ng.forum.forum.repository.UserRepository;
import nigeriandailies.com.ng.forum.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
public class ForumApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService) throws Exception {
        if (repository.count()==0)
            userService.save(new User("admin", "adminPassword", Arrays.asList(new Role("USER"), new Role("ACTUATOR")
//                    , new Role("ADMIN")
            )));
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    /**
     * We return an istance of our CustomUserDetails.
     * @param repository
     * @return
     */
    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }

}
