package com.school.repository;

import com.school.entity.School;
import com.school.entity.SchoolClass;
import com.school.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends BaseRepository<School, String>  {

    School findBySchoolAdmin(User user);

}
