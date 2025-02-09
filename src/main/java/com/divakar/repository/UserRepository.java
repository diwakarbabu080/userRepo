package com.divakar.repository;

import com.divakar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

    List<User> findByRole(String role);
    Optional<User> findByIdOrSsn(Long id, String ssn);
}
