package com.spring.learning.car_rental_20.repos;

import com.spring.learning.car_rental_20.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Receipt r WHERE r.id=?1")
    public void deleteReceipt(Long receiptId);
}
