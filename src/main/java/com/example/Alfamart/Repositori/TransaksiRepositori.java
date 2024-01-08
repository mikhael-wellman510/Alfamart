package com.example.Alfamart.Repositori;

import com.example.Alfamart.Entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepositori extends JpaRepository<Transaksi,String> {

}
