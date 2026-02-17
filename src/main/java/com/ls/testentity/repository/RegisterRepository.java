package com.ls.testentity.repository;

import com.ls.testentity.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends JpaRepository<Register ,Long> {
    List<Register> findByDeletedFalse();
    Optional<Register> findByUsername(String username);
}
