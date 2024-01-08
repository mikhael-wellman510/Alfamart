package com.example.Alfamart.Dto.Request;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GetTransaksiRequest {
    private String id; ;
}
