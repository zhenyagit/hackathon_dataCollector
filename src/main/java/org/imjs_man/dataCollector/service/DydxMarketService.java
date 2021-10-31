package org.imjs_man.dataCollector.service;


import org.imjs_man.dataCollector.entity.DydxMarketEntity;
import org.imjs_man.dataCollector.repository.DydxMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DydxMarketService {

    @Autowired
    DydxMarketRepository dydxMarketRepository;

    public void saveAll(List<DydxMarketEntity> markets) {
        dydxMarketRepository.saveAll(markets);
    }

    public List<DydxMarketEntity> getAll() {
        return dydxMarketRepository.findAll();
    }
}
