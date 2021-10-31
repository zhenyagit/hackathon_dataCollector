package org.imjs_man.dataCollector.service;

import org.imjs_man.dataCollector.entity.AllDayDataEntity;
import org.imjs_man.dataCollector.repository.AllDayDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllDayDataService {
    @Autowired
    AllDayDataRepository allDayDataRepository;

    public void saveAll(List<AllDayDataEntity> markets) {
        allDayDataRepository.saveAll(markets);
    }

}
