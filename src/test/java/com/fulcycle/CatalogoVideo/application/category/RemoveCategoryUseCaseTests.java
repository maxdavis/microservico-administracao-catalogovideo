package com.fulcycle.CatalogoVideo.application.category;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fulcycle.CatalogoVideo.application.usecase.category.delete.RemoveCategoryUseCase;
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
public class RemoveCategoryUseCaseTests {

    @InjectMocks
    private RemoveCategoryUseCase useCase;

    @Mock
    ICategoryRespository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new RemoveCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsRemove() throws Exception {
        Category category = new Category(
                "Action",
                "Action Description",
                true);

        doNothing()
                .when(repository)
                .remove(category.getId());

        useCase.execute(category.getId());
        repository.findById(category.getId());

        assertThat(category).isNotNull();
        verify(repository, times(1)).remove(category.getId());

    }
}
