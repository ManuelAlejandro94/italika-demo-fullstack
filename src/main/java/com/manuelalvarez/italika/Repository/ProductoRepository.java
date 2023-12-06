package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {

    @Query(value = "SELECT * FROM TB_PRODUCTO WHERE ID = :id",
            nativeQuery = true)
    ProductoModel FindById(@Param("id") Long id);
}
