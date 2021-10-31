package org.imjs_man.dataCollector.repository;

import org.imjs_man.dataCollector.entity.DydxMarketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DydxMarketRepository extends CrudRepository<DydxMarketEntity, Long> {
    List<DydxMarketEntity> findAll();
}
