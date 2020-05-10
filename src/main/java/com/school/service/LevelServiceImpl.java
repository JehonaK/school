package com.school.service;

import com.school.entity.Level;
import com.school.repository.BaseRepository;
import com.school.repository.LevelRepository;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl extends BaseServiceImpl<Level, String> implements LevelService{
    private LevelRepository levelRepository;

    public LevelServiceImpl(BaseRepository<Level, String> baseRepository, LevelRepository levelRepository) {
        super(baseRepository);
        this.levelRepository = levelRepository;
    }
}
