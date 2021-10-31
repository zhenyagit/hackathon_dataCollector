package org.imjs_man.dataCollector.service;
import org.imjs_man.dataCollector.entity.PairDepth;
import org.imjs_man.dataCollector.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PairService
{
    @Autowired
    PairRepository pairRepository;

    public void save(PairDepth pairDepth)
    {
        pairRepository.save(pairDepth);
    }
    public List<PairDepth> getAll()
    {
        return pairRepository.findAll();
    }
    public List<PairDepth> getAllByMarketName(String marketName)
    {
        return pairRepository.findAllByPairName(marketName);
    }


}