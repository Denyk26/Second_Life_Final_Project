package com.second_life;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Builder

public class ResponseForCategoryDto {
    private int id;
    private String name;
    private String description;
}
