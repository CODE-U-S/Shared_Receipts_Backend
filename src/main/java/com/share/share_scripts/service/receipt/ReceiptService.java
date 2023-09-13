package com.share.share_scripts.service.receipt;

import com.share.share_scripts.domain.receipt.Receipt;
import com.share.share_scripts.dto.post.AddPostRequest;
import com.share.share_scripts.dto.receipt.AddReceiptRequest;
import com.share.share_scripts.dto.receipt.UpdateReceiptRequest;
import com.share.share_scripts.repository.receipt.ReceiptRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    public Receipt save(AddReceiptRequest request) {
        return receiptRepository.save(request.toEntity());
    }

    public List<Receipt> findAll() { return receiptRepository.findAll(); }

    public void delete(Long id) { receiptRepository.deleteById(id); }

    @Transactional
    public Receipt update(Long id, UpdateReceiptRequest request) {
        Receipt receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        receipt.update(request.getPostNo(),
                request.getName(),
                request.getPrice());

        return receipt;
    }
}
