package com.manuelalvarez.italika.Repository;

import com.manuelalvarez.italika.Model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {

    @Query(value = "SELECT * FROM TB_USERS WHERE ID = :id",
            nativeQuery = true)
    UsersModel FindById(@Param("id") Long id);
}
