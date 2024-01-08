package com.example.Alfamart.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_barang")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nama_barang" , nullable = false , length = 100)
    private String namaBarang;

    @Column(name = "quantity" , nullable = false , length = 50)
    private Integer quantity;

    @Column(name = "harga" , nullable = false , length = 50)
    private Double harga;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaksi transaksi;

    @Override
    public String toString() {
        return "Barang{" +
                "id='" + id + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", quantity=" + quantity +
                ", harga=" + harga +
                '}';
    }
}
