package com.ls.testentity.repository;

import com.ls.testentity.entity.Info;
import com.ls.testentity.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Register ,Long> {
    List<Register> findByDeletedFalse();
}
