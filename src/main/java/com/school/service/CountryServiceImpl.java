package com.school.service;

import com.school.entity.Country;
import com.school.repository.BaseRepository;
import com.school.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, String> implements CountryService{
    private CountryRepository countryRepository;

    public CountryServiceImpl(BaseRepository<Country, String> baseRepository, CountryRepository countryRepository) {
        super(baseRepository);
        this.countryRepository = countryRepository;
    }
}
