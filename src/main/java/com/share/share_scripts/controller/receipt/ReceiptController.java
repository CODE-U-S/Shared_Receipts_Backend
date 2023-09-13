package com.share.share_scripts.controller.receipt;

import com.share.share_scripts.domain.receipt.Receipt;
import com.share.share_scripts.dto.receipt.AddReceiptRequest;
import com.share.share_scripts.dto.receipt.ReceiptResponse;
import com.share.share_scripts.dto.receipt.UpdateReceiptRequest;
import com.share.share_scripts.service.link.LinkService;
import com.share.share_scripts.service.receipt.ReceiptService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

    @GetMapping("/api/receipt")
    public ResponseEntity<List<ReceiptResponse>> findAllReceipt() {
        List<ReceiptResponse> receipt = receiptService.findAll()
                .stream()
                .map(ReceiptResponse::new)
                .toList();

        return ResponseEntity.ok().body(receipt);
    }

    @PutMapping("/api/receipt/{id}")
    public ResponseEntity<Receipt> updateReceipt(@PathVariable Long id,
                                                 @RequestBody UpdateReceiptRequest request) {
        Receipt updatedReceipt = receiptService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedReceipt);
    }

    @DeleteMapping("/api/receipt/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Long id) {
        receiptService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
}
