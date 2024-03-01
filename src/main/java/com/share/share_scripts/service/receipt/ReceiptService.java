package com.share.share_scripts.service.receipt;

import com.share.share_scripts.domain.receipt.Receipt;
import com.share.share_scripts.dto.receipt.AddReceiptRequest;
import com.share.share_scripts.dto.receipt.UpdateReceiptRequest;
import com.share.share_scripts.exception.PostNotFoundException;
import com.share.share_scripts.exception.ReceiptNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.post.PostRepository;
import com.share.share_scripts.repository.receipt.ReceiptRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

import static com.share.share_scripts.exception.BadRequestException.badRequestException;

@RequiredArgsConstructor
@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final PostRepository postRepository;

    public Receipt save(AddReceiptRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        postRepository.findById(request.getPost().getId())
                .orElseThrow(() -> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));

        return receiptRepository.save(request.toEntity());
    }

    public List<Receipt> findAll() { return receiptRepository.findAll(); }

    public void delete(Long id) { receiptRepository.deleteById(id); }

    @Transactional
    public Receipt update(Long id, UpdateReceiptRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        Receipt receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new ReceiptNotFoundException(ErrorCode.RECEIPT_NOT_FOUND));

        receipt.update(
                request.getName(),
                request.getPrice()
        );

        return receipt;
    }
}
