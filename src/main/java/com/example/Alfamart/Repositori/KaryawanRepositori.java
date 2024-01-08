package com.example.Alfamart.Repositori;

import com.example.Alfamart.Entity.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepositori extends JpaRepository<Karyawan , String> {
}
