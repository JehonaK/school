package com.school.repository;

import com.school.entity.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends BaseRepository<Country, String>{
}
