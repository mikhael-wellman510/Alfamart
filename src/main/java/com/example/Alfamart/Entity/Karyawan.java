package com.example.Alfamart.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_karyawan")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nama_karyawan" , nullable = false , length = 100)
    private String namaKaryawan;

    @Column(name = "nip" , nullable = false , length = 50)
    private String nip;

    @Override
    public String toString() {
        return "Karyawan{" +
                "id='" + id + '\'' +
                ", namaKaryawan='" + namaKaryawan + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
