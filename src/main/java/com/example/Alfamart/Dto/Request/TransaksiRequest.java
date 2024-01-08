package com.example.Alfamart.Dto.Request;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransaksiRequest {




    //Karyawan
    private String namaKaryawan;
    private String nip;

    //Retail
    private String namaRetail;
    private String noRetail;
    private String alamat;
    // Barang
    private List<BarangRequest> barangRequests;

    private Double tunai ;

    @Override
    public String toString() {
        return "TransaksiRequest{" +
                "namaKaryawan='" + namaKaryawan + '\'' +
                ", nip='" + nip + '\'' +
                ", namaRetail='" + namaRetail + '\'' +
                ", noRetail='" + noRetail + '\'' +
                ", alamat='" + alamat + '\'' +
                ", barangRequests=" + barangRequests +
                ", tunai=" + tunai +
                '}';
    }
}
