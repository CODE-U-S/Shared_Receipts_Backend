package com.share.share_scripts.repository.receipt;

import com.share.share_scripts.domain.receipt.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
