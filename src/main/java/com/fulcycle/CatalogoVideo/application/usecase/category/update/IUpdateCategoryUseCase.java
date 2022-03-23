package com.fulcycle.CatalogoVideo.application.usecase.category.update;

import java.util.UUID;

public interface IUpdateCategoryUseCase {
    void execute(UUID id, UpdateCategoryInputData input);    
}
