package com.school.repository;

import com.school.entity.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends BaseRepository<School, String>  {

}
