package com.example.Alfamart.Repositori;

import com.example.Alfamart.Entity.Retail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailRepositori extends JpaRepository<Retail,String> {
}
