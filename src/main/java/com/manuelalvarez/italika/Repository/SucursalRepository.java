package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.SucursalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalModel, Long> {

    @Query(value = "SELECT * FROM TB_SUCURSAL WHERE ID = :id",
            nativeQuery = true)
    SucursalModel FindById(@Param("id") Long id);

    @Query(value = "DECLARE @return_value int\n" +
            "\n" +
            "EXEC @return_value = [dbo].[sp_RandomIDSucursal]\n" +
            "\n" +
            "SELECT 'Return Value' = @return_value\n" +
            "\n" +
            "GO",
            nativeQuery = true)
    Long GetIDSucursalRandom();
}
