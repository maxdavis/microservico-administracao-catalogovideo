package com.fulcycle.CatalogoVideo.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fulcycle.CatalogoVideo.domain.entity.Category;

public interface ICategoryRespository {
    List<Category> findAll();
    Category create(Category category);
    Optional<Category> findById(UUID id);
    void remove(UUID id);
    void update(Category category);    
}
