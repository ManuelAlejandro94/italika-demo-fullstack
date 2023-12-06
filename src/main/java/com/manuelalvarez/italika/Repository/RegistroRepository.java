package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.RegistroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroModel, Long> {

    @Query(value = "SELECT * FROM TB_REGISTRO WHERE ID = :id",
            nativeQuery = true)
    RegistroModel FindById(@Param("id") Long id);
}
