package com.example.Alfamart.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Todo -> Table Retail
    @ManyToOne
    @JoinColumn(name = "retail_id")
    private Retail retail;

    @Column(name = "tanggal_transaksi")
    private LocalDateTime tanggalTransaksi;

    // Todo kode transaksi -> noRetail/Tanggal/urutanTransaksi
    @Column(name = "kode_transaksi" , nullable = false)
    private String kodeTransaksi ;

    // Todo -> Table Barang yang di beli supaya banyak
    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL)
    private List<Barang> barang;

    @Column(name = "sub_total" , nullable = false)
    private Double subTotal;

    @Column(name = "pajak" , nullable = false)
    private Double pajak;

    @Column(name = "total_belanja" , nullable = false )
    private Double totalBelanja;

    @Column(name = "tunai" , nullable = false)
    private Double tunai;

    @Column(name = "kembalian" , nullable = false)
    private Double kembalian;

    @Override
    public String toString() {
        return "Transaksi{" +
                "id='" + id + '\'' +
                ", retail=" + retail +
                ", tanggalTransaksi=" + tanggalTransaksi +
                ", kodeTransaksi='" + kodeTransaksi + '\'' +
                ", barang=" + barang +
                ", subTotal=" + subTotal +
                ", pajak=" + pajak +
                ", totalBelanja=" + totalBelanja +
                ", tunai=" + tunai +
                ", kembalian=" + kembalian +
                '}';
    }
}
