package com.jamonedero92.bookit.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class EntityDTO {
    private long Id;

    @NotBlank
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String place;

    @NotNull
    private LocalDateTime date_time;

    @Min(1)
    private int capacity;

    public EntityDTO() {
    }


}
