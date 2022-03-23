package com.fulcycle.CatalogoVideo.application.usecase.category.create;

import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;

public interface ICreateCategoryUseCase {

    CategoryOutputData execute(CreateCategoryInputData input);
    
}
