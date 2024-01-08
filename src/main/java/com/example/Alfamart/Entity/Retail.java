package com.example.Alfamart.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_retail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Retail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nama_retail" , nullable = false, length = 100)
    private String namaRetail;

    @Column(name = "no_retail", nullable = false, length = 50)
    private String noRetail;

    @Column(name = "alamat", nullable = false,length = 100)
    private String alamat;

    @ManyToOne
    @JoinColumn(name = "karyawan_id")
    private Karyawan karyawan;

    @Override
    public String toString() {
        return "Retail{" +
                "id='" + id + '\'' +
                ", namaRetail='" + namaRetail + '\'' +
                ", noRetail='" + noRetail + '\'' +
                ", alamat='" + alamat + '\'' +
                ", karyawan=" + karyawan +
                '}';
    }
}
