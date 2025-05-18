package com.example.demo.repository.StoreRepository;

import com.example.demo.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}