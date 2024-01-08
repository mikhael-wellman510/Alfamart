package com.example.Alfamart.Service;

import com.example.Alfamart.Dto.Request.GetTransaksiRequest;
import com.example.Alfamart.Dto.Request.TransaksiRequest;
import com.example.Alfamart.Dto.Response.GetTransaksiResponse;
import com.example.Alfamart.Dto.Response.TransaksiResponse;

import java.util.List;

public interface TransaksiService {

    TransaksiResponse createTransaksi (TransaksiRequest transaksiRequest);
    List<GetTransaksiResponse> getTransaksi(String id);
}
