package com.example.Alfamart.Controller;

import com.example.Alfamart.Constant.AppPath;
import com.example.Alfamart.Dto.Request.TransaksiRequest;
import com.example.Alfamart.Dto.Response.CommonResponse.CommonResponse;
import com.example.Alfamart.Dto.Response.GetTransaksiResponse;
import com.example.Alfamart.Dto.Response.TransaksiResponse;
import com.example.Alfamart.Service.TransaksiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.TRANSACTION)
public class TransactionController {

    private final TransaksiService transaksiService;


    @PostMapping(value = "/create")
    public ResponseEntity<?> createTransaction(@RequestBody TransaksiRequest transaksiRequest){
        TransaksiResponse transaksiResponse = transaksiService.createTransaksi(transaksiRequest);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<TransaksiResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Product")
                        .data(transaksiResponse)
                        .build()) ;

    }

    @GetMapping(value = "/get/{transactionId}")
    public ResponseEntity<?> getTransaksi(@PathVariable String transactionId){

        List<GetTransaksiResponse> getTransaksiResponses = transaksiService.getTransaksi(transactionId);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<GetTransaksiResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Product")
                        .data(getTransaksiResponses)
                        .build()) ;

    }

}
