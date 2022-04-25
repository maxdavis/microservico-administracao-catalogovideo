package com.fulcycle.CatalogoVideo.application.usecase.category.create;

import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fulcycle.CatalogoVideo.domain.entity.Category;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase {

    private ICategoryRespository repository;

    @Override
    public CategoryOutputData execute(CreateCategoryInputData input) {
        var created = repository.create(toDomain(input));
        return CategoryOutputData.fromDomain(created);
    }
  
    private Category toDomain(CreateCategoryInputData input){
        return new Category(
            input.getName(),
            input.getDescription(),
            input.getIsActive()
        );
    }
    
}
