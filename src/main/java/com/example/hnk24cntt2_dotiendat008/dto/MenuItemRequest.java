package com.example.hnk24cntt2_dotiendat008.dto;

import com.example.hnk24cntt2_dotiendat008.entity.MenuItemStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @Positive(message = "Price must be greater than 0")
    private Double price;

    private MenuItemStatus status;
}