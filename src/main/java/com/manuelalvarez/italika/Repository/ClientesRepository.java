package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {

    @Procedure(procedureName = "sp_getByIdCliente")
    List<ClientesModel> getById(@Param("id") Long id);

    @Query(value = "SELECT * FROM TB_CLIENTES WHERE ID = :id",
            nativeQuery = true)
    ClientesModel FindById(@Param("id") Long id);
}
