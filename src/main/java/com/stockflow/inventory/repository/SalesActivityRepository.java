package com.stockflow.inventory.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stockflow.inventory.entity.SalesActivity;

public interface SalesActivityRepository extends JpaRepository<SalesActivity, Long> {
    @Query("SELECT SUM(s.quantitySold) FROM SalesActivity s WHERE s.product.id = :productId AND s.warehouseId = :warehouseId AND s.soldAt >= :since")
    Integer findTotalSalesLast30Days(@Param("productId") Long productId, @Param("warehouseId") Long warehouseId, @Param("since") LocalDateTime since);
}
