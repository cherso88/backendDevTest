package com.test.zara.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Double price;
    @NotNull
    private boolean availability;
}
