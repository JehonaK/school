package com.school.repository;

import com.school.entity.SchoolClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassRepository extends BaseRepository<SchoolClass, String> {

    @Query(value = "SELECT * FROM school_class WHERE id IN (?1)", nativeQuery = true)
    List<SchoolClass> getBatchOfSchoolClasses(List<String> schoolClassIdList);

}
