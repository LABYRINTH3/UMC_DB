// src/main/java/com/example/demo/repository/store/StoreRepositoryCustom.java
package com.example.demo.repository.StoreRepository;

import com.example.demo.domain.Store;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
