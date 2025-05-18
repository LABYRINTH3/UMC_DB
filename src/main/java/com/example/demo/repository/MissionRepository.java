package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}