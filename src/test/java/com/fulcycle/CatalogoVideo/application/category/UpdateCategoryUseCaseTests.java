package com.fulcycle.CatalogoVideo.application.category;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;
import java.util.UUID;

import com.fulcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fulcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fulcycle.CatalogoVideo.application.usecase.category.get.FindByIdCategoryUseCase;
import com.fulcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryInputData;
import com.fulcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryUseCase;
import com.fulcycle.CatalogoVideo.domain.entity.Category;
import com.fulcycle.CatalogoVideo.domain.repository.ICategoryRespository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryUseCaseTests {

    @InjectMocks
    private UpdateCategoryUseCase useCase;

    @Mock
    ICategoryRespository repository;

    @BeforeEach
    void initUseCase() {
        useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsUpdateCategoryName()  {
        Category category = new Category(
                "Action",
                "Action Description",
                true);

        Category expected = new Category(
                "Action2",
                "Action Description",
                true);

        Optional<Category> opCategory = Optional.of(category);
        when(repository.findById(category.getId())).thenReturn(opCategory);

        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Action2");
        input.setDescription("Description");
        input.setIsActive(category.getIsActive());

        category.update(input.getName(), input.getDescription(), input.getIsActive());

        doNothing().when(repository).update(category);

        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(expected).isNotNull();
        assertThat(category.getName()).isEqualTo(expected.getName());

    }


    @Test
    public void throwNotFoundExceptionWhenIdIsWrong() {

        Category category = new Category(
            "Action",
            "Action Description",
            true);


        UpdateCategoryInputData input = new UpdateCategoryInputData();
            input.setName("Action2");
            input.setDescription("Description");
            input.setIsActive(category.getIsActive());

        assertThrows(NotFoundException.class, () -> 
           useCase.execute(UUID.fromString("8bc3a688-bdcb-11ec-9d64-0242ac120002"), input)
        );

    }


    @Test
    public void executeReturnsUpdateCategory()  {
        Category category = new Category(
                "Action",
                "Action Description",
                true);

        Category expected = new Category(
                "Action2",
                "Description 2",
                false);

        Optional<Category> opCategory = Optional.of(category);
        when(repository.findById(category.getId())).thenReturn(opCategory);

        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Action2");
        input.setDescription("Description 2");
        input.setIsActive(false);

        category.update(input.getName(), input.getDescription(), input.getIsActive());

        doNothing().when(repository).update(category);

        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(expected).isNotNull();
        assertThat(category.getName()).isEqualTo(expected.getName());

        assertThat(category.getDescription()).isEqualTo(expected.getDescription());
        assertFalse(category.getIsActive());

    }

}
