package com.springboot.springsecurity.config;

import com.springboot.springsecurity.model.Usr;
import com.springboot.springsecurity.repository.UsrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadDatabaseUsers {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseUsers.class);
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Bean
    CommandLineRunner initDatabase(UsrRepository usrRepository) {
        return args -> {
            log.info("Loading users from database...");
            log.info("Preloading users from database..."+ usrRepository.save(new Usr(null,"user", passwordEncoder.encode("123456"),"USER")));
            log.info("Preloading users from database..."+ usrRepository.save(new Usr(null,"lucas", passwordEncoder.encode("123"),"ADMIN")));
        };
    }
}
