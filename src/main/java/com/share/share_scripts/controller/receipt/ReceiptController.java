package com.share.share_scripts.controller.receipt;

import com.share.share_scripts.domain.receipt.Receipt;
import com.share.share_scripts.dto.receipt.AddReceiptRequest;
import com.share.share_scripts.service.receipt.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping("/api/receipt")
    public ResponseEntity<Receipt> addReceipt(@RequestBody AddReceiptRequest request) {
        Receipt savedReceipt = receiptService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedReceipt);
    }
}
