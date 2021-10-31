package org.imjs_man.dataCollector.repository;

import org.imjs_man.dataCollector.entity.AllDayDataEntity;
import org.imjs_man.dataCollector.entity.DydxMarketEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AllDayDataRepository extends CrudRepository<AllDayDataEntity, Long> {
    List<AllDayDataEntity> findAll();
}
