package com.fulcycle.CatalogoVideo.application.usecase.category.get;

import java.util.UUID;

import com.fulcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindByIdCategoryUseCase implements IFindByIdCategoryUseCase {

    private ICategoryRespository repository;

    @Override
    public CategoryOutputData execute(UUID id)  {
        return repository.findById(id)
         .map(CategoryOutputData::fromDomain)
         .orElseThrow(() -> new NotFoundException("Category %s not found", id));
    }

}
