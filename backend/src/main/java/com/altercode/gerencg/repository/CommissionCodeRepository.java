package com.altercode.gerencg.repository;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommissionCodeRepository extends JpaRepository<CommissionCode, String> {

@Query("SELECT obj FROM CommissionCode obj WHERE obj.code LIKE %?1%")
Page<CommissionCode> findAllCommissionsByCode (Pageable pageable, String code);

    @Query("SELECT obj FROM CommissionCode obj WHERE obj.code LIKE %?1%")
    List<CommissionCode> findAllCommissionsByCode(String code);
}
