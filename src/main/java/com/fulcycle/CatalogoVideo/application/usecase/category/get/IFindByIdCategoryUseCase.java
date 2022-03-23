package com.fulcycle.CatalogoVideo.application.usecase.category.get;

import java.util.UUID;

import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;

public interface IFindByIdCategoryUseCase {

    CategoryOutputData execute(UUID id) throws Exception;

}
