package com.fulcycle.CatalogoVideo.application.usecase.category.update;

import java.util.UUID;

import com.fulcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fulcycle.CatalogoVideo.domain.entity.Category;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase {

    private ICategoryRespository repository;;

    @Override
    public void execute(UUID id, UpdateCategoryInputData input) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException("Category %s not found", id));
        category.update(input.getName(), input.getDescription(), input.getIsActive());

        repository.update(category);
    }

}
