package com.example.Alfamart.Repositori;

import com.example.Alfamart.Entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepositori extends JpaRepository<Barang , String> {
//    @Query("SELECT b FROM Barang b WHERE b.transaksi.id = :transactionId")
List<Barang> findByTransaksi_Id(String transactionId);
}
