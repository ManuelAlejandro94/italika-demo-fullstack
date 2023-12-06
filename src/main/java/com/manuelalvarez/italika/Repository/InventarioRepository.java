package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.InventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioModel, Long> {

    @Query(value = "SELECT * FROM TB_INVENTARIO WHERE ID = :id",
            nativeQuery = true)
    InventarioModel FindById(@Param("id") Long id);
}
