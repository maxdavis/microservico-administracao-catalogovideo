package com.fulcycle.CatalogoVideo.application.usecase.category.delete;

import java.util.UUID;

import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RemoveCategoryUseCase implements IRemoveCategoryUseCase {

    private ICategoryRespository respository;

    @Override
    public void execute(UUID id) {
        respository.remove(id);        
    }
    
}
