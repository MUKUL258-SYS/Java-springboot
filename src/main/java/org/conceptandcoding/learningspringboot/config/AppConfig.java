package org.conceptandcoding.learningspringboot.config;
import org.conceptandcoding.learningspringboot.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{
    @Bean
    public User createUserBean(){
        return new User("abc","xyx");
    }
}
