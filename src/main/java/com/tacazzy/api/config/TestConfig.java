package com.tacazzy.api.config;

import com.tacazzy.api.models.User;
import com.tacazzy.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null);
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456",null);
        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
