package com.example.Alfamart.Service.Impl;

import com.example.Alfamart.Dto.Request.GetTransaksiRequest;
import com.example.Alfamart.Dto.Request.TransaksiRequest;
import com.example.Alfamart.Dto.Response.GetTransaksiResponse;
import com.example.Alfamart.Dto.Response.PesananOrderResponse;
import com.example.Alfamart.Dto.Response.TransaksiResponse;
import com.example.Alfamart.Entity.Barang;
import com.example.Alfamart.Entity.Karyawan;
import com.example.Alfamart.Entity.Retail;
import com.example.Alfamart.Entity.Transaksi;
import com.example.Alfamart.Repositori.BarangRepositori;
import com.example.Alfamart.Repositori.KaryawanRepositori;
import com.example.Alfamart.Repositori.RetailRepositori;
import com.example.Alfamart.Repositori.TransaksiRepositori;
import com.example.Alfamart.Service.TransaksiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransaksiServiceImpl implements TransaksiService {

    private final KaryawanRepositori karyawanRepositori;
    private final RetailRepositori retailRepositori;
    private final BarangRepositori barangRepositori;
    private final TransaksiRepositori transaksiRepositori;
    @Override
    public TransaksiResponse createTransaksi(TransaksiRequest transaksiRequest) {
        // Todo kode transaksi -> noRetail/Tanggal/urutanTransaksi
        // Todo Kode Transaksi

        // Todo ->Create Karyawan
        Karyawan karyawan = Karyawan.builder()
                .nip(transaksiRequest.getNip())
                .namaKaryawan(transaksiRequest.getNamaKaryawan())
                .build();
        Karyawan karyawan1 = karyawanRepositori.saveAndFlush(karyawan);

        //Todo -> CreateRetail
        Retail retail = Retail.builder()
                .namaRetail(transaksiRequest.getNamaRetail())
                .noRetail(transaksiRequest.getNoRetail())
                .alamat(transaksiRequest.getAlamat())
                .karyawan(karyawan)
                .build();
        Retail retail1 = retailRepositori.saveAndFlush(retail);

        // Todo -> Sub Total (Menggunakan Stream)
        Double subTotal = transaksiRequest.getBarangRequests().stream()
                .mapToDouble(barangRequest -> barangRequest.getHarga() * barangRequest.getQuantity())
                .sum();
        // Todo -> Pajak 10%


        System.out.println(subTotal);

        Double pajak = 10.0;

        // Todo - > Hasil total (Di tambahkan dengan pajak
        Double rumus = (pajak / 100) * subTotal;
        Double total = rumus + subTotal;

        // Todo -> Total kembalian
        Double kembalian = transaksiRequest.getTunai() - total;

        // Todo Transaksi
        Transaksi transaksi = Transaksi.builder()
                .retail(retail1)
                .tanggalTransaksi(LocalDateTime.now())
                .kodeTransaksi("121212")

                .subTotal(subTotal)
                .pajak(pajak)
                .totalBelanja(subTotal)
                .tunai(transaksiRequest.getTunai())
                .kembalian(kembalian)
                .build();
        System.out.println(transaksi);

        Transaksi trx = transaksiRepositori.saveAndFlush(transaksi);
        //Todo -> Create Barang



        List<Barang> br = transaksiRequest.getBarangRequests().stream().map(tr -> Barang.builder()
                .namaBarang(tr.getNamaBarang())
                .quantity(tr.getQuantity())
                .harga(tr.getHarga())
                .transaksi(trx)
                .build()).toList();
        List<Barang> brSave = barangRepositori.saveAllAndFlush(br);

        //Todo ->Detail Order Respon
        List<PesananOrderResponse> dtr = transaksiRequest.getBarangRequests().stream().map(barang -> {

           return PesananOrderResponse.builder()
                    .namaBarang(barang.getNamaBarang())
                    .quantity(barang.getQuantity())
                    .harga(barang.getHarga())
                    .TotalHarga(barang.getQuantity() * barang.getHarga())
                    .build();

        }).toList();


        return TransaksiResponse.builder()
                .namaRetail(transaksiRequest.getNamaRetail())
                .alamat(transaksiRequest.getAlamat())
                .namaKasir(transaksiRequest.getNamaKaryawan())
                .nip(transaksiRequest.getNip())
                .tanggal(LocalDateTime.now())
                .jam(LocalDateTime.now())
                .orderPesanan(dtr)
                .subTotal(subTotal)
                .pajak(pajak)
                .total(total)
                .tunai(transaksiRequest.getTunai())
                .kembalian(kembalian)
                .build();
    }



    @Override
    public List<GetTransaksiResponse> getTransaksi(String id) {

        List<Barang> getAllOrder = barangRepositori.findByTransaksi_Id(id);

        return getAllOrder.stream()
                .map(getAllOrders -> GetTransaksiResponse.builder()
                        .namaBarang(getAllOrders.getNamaBarang())
                        .quantity(getAllOrders.getQuantity())
                        .harga(getAllOrders.getHarga())
                        .totalHarga(getAllOrders.getHarga() * getAllOrders.getQuantity())
                        .build()).toList();
    }
}
