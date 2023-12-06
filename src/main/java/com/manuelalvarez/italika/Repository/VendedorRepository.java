package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Long> {

    @Query(value = "SELECT * FROM TB_VENDEDOR WHERE ID = :id",
            nativeQuery = true)
    VendedorModel FindById(@Param("id") Long id);

    @Query(value = "SELECT * FROM TB_VENDEDOR WHERE SUCURSAL = :sucursal",
            nativeQuery = true)
    List<VendedorModel> FindBySucursalParam(@Param("sucursal") Long sucursal);
}
