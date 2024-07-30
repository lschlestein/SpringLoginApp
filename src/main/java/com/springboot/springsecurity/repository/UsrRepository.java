package com.springboot.springsecurity.repository;

import com.springboot.springsecurity.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsrRepository extends JpaRepository<Usr, Long> {
    Optional<Usr> findByUsername(String username);
}
