package com.ls.testentity.repository;

import com.ls.testentity.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info,Long> {
    List<Info> findByDeletedFalse();
}
