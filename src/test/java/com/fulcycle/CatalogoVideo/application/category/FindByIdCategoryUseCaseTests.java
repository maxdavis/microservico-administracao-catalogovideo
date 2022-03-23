package com.fulcycle.CatalogoVideo.application.category;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fulcycle.CatalogoVideo.application.usecase.category.get.FindByIdCategoryUseCase;
import com.fulcycle.CatalogoVideo.domain.entity.Category;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class FindByIdCategoryUseCaseTests {

    @InjectMocks
    private FindByIdCategoryUseCase useCase;

    @Mock
    ICategoryRespository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new FindByIdCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsFindById()  {
        Category category = new Category(
                "Action",
                "Action Description",
                true);

        Optional<Category> opCategory = Optional.of(category);

        when(repository.findById(category.getId())).thenReturn(opCategory);

        doReturn(opCategory)
                .when(repository)
                .findById(category.getId());

        CategoryOutputData actual = useCase.execute(category.getId());
        repository.findById(category.getId());

        assertThat(category).isNotNull();
        assertThat(actual).isNotNull();

    }
}
