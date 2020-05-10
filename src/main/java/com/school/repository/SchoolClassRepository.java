package com.school.repository;

import com.school.entity.SchoolClass;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends BaseRepository<SchoolClass, String> {
}
