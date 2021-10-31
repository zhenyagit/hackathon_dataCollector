package org.imjs_man.dataCollector.repository;

import org.imjs_man.dataCollector.entity.PairDepth;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PairRepository extends CrudRepository<PairDepth, Long> {
    List<PairDepth> findAll();
    List<PairDepth> findAllByPairName(String marketName);

}
