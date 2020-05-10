package com.school.repository;

import com.school.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends BaseRepository<Subject, String> {
}
