package com.example.Alfamart.Dto.Response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransaksiResponse {


    private String namaRetail;
    private String alamat;
    private String namaKasir;
    private String nip;

    private String kodeTransaksi;

    private LocalDateTime tanggal;
    private LocalDateTime jam;


    private List<PesananOrderResponse> orderPesanan;

    private Double subTotal ;
    private Double pajak;

    private Double total;
    private Double tunai;

    private Double kembalian;


}
