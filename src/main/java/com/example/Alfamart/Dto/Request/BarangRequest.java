package com.example.Alfamart.Dto.Request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BarangRequest {

    private String namaBarang;
    private Integer quantity;
    private Double harga;

    @Override
    public String toString() {
        return "BarangRequest{" +
                "namaBarang='" + namaBarang + '\'' +
                ", quantity='" + quantity + '\'' +
                ", harga=" + harga +
                '}';
    }
}
