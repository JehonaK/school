package com.school.repository;

import com.school.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String> {

    User findByEmail(String email);

}
