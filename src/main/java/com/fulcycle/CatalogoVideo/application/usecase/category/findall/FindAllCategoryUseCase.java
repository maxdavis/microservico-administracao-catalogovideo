package com.fulcycle.CatalogoVideo.application.usecase.category.findall;

import java.util.List;
import java.util.stream.Collectors;

import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindAllCategoryUseCase implements IFindAllCategoryUseCase {

    private ICategoryRespository repository;

    @Override
    public List<CategoryOutputData> execute() {
        var list = repository.findAll();
        return list.stream()
                    .map(c -> CategoryOutputData.fromDomain(c))
                    .collect(Collectors.toList());
    }
    
}
