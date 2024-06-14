package com.second_life;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Builder

public class LogInResponseDto {
    private String accessToken;
    private String refreshToken;
    private int clientId;

}
