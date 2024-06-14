package com.second_life;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Builder

public class RegistrationRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
