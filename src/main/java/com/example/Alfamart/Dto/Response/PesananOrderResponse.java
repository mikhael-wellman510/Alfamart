package com.example.Alfamart.Dto.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PesananOrderResponse {
    private String namaBarang ;
    private Integer quantity;
    private Double harga;
    private Double TotalHarga;

}
