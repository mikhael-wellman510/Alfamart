package com.example.Alfamart.Dto.Response.CommonResponse;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse <T>{
    private Integer statusCode ;
    private String message;
    private T data;
}
