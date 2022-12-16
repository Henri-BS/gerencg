package com.altercode.gerencg.repository;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionCodeRepository extends JpaRepository<CommissionCode, String> {

@Query("SELECT obj FROM CommissionCode obj WHERE obj.code LIKE %?1%")
Page<CommissionCode> findItemsByCode(Pageable pageable, String code);

}
