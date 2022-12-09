package com.nest.studentapp_new_backend.dao;

import com.nest.studentapp_new_backend.model.Students;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends CrudRepository<Students,Integer> {
    @Query(value = "SELECT `id`, `admnno`, `college`, `name`, `rollno` FROM `students` WHERE `admnno` LIKE %:admissionNo%",nativeQuery = true)
    List<Students> SearchStudent(@Param("admissionNo") int admissionNo);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `students` WHERE `id`= :id",nativeQuery = true)
    void DeleteStudent(@Param("id") Integer id);
}
