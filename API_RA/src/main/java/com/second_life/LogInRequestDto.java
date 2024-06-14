package com.second_life;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Builder

public class LogInRequestDto {
   private String email;
   private String password;
}
