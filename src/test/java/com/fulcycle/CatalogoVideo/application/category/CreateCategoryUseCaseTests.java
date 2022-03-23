package com.fulcycle.CatalogoVideo.application.category;

import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fulcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import com.fulcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryUseCase;
import com.fulcycle.CatalogoVideo.domain.entity.Category;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;



@ExtendWith(SpringExtension.class)
public class CreateCategoryUseCaseTests {

    @InjectMocks
    private CreateCategoryUseCase useCase;

    @Mock
    ICategoryRespository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new CreateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsCreatedCategory(){
        Category category = new Category( "Action", "Action Category");

        when(repository.create(any(Category.class))).thenReturn(category);

        CreateCategoryInputData input = new CreateCategoryInputData(
            category.getName(),
            category.getDescription(),
            category.getIsActive()
        );

        CategoryOutputData actual = useCase.execute(input);
        repository.create(category);

        assertThat(actual.getName()).isEqualTo(category.getName());
    }
    
}
