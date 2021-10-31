package org.imjs_man.dataCollector.calculator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.imjs_man.dataCollector.entity.AllDayDataEntity;
import org.imjs_man.dataCollector.entity.DydxMarketEntity;
import org.imjs_man.dataCollector.entity.PairDepth;
import org.imjs_man.dataCollector.service.AllDayDataService;
import org.imjs_man.dataCollector.service.DydxMarketService;
import org.imjs_man.dataCollector.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class Calculator {

    @Autowired
    PairService pairService;

    @Autowired
    DydxMarketService dydxMarketService;

    @Autowired
    AllDayDataService allDayDataService;

    public void calcDayPrice() {
        List<DydxMarketEntity> marketEntities = dydxMarketService.getAll();
        List<AllDayDataEntity> allDayDataEntities = new ArrayList<>();

        for (DydxMarketEntity dydxMarketEntity: marketEntities) {
            String marketName = dydxMarketEntity.getMarket();

            List<PairDepth> depths = pairService.getAllByMarketName(marketName);
            List<CalcData> calcDataAsks = new ArrayList<>();
            List<CalcData> calcDataBids = new ArrayList<>();
            for (PairDepth pairDepth : depths) {
                Gson gson = new Gson();
                Type itemsListType = new TypeToken<List<OrdersSizePrice>>() {
                }.getType();
                List<OrdersSizePrice> ordersSizePricesAsks = gson.fromJson(pairDepth.getAsks(), itemsListType);
                List<OrdersSizePrice> ordersSizePricesBids = gson.fromJson(pairDepth.getBids(), itemsListType);
                calcDataAsks.add(avgPrice(ordersSizePricesAsks));
                calcDataBids.add(avgPrice(ordersSizePricesBids));
            }
            CalcData calcDataAsk = finalPrice(calcDataAsks);
            CalcData calcDataBid = finalPrice(calcDataBids);
            AllDayDataEntity allDayDataEntity = new AllDayDataEntity();
            allDayDataEntity.setPairName(marketName);
            allDayDataEntity.setAskPrice(calcDataAsk.getAvgPrice());
            allDayDataEntity.setBidPrice(calcDataBid.getAvgPrice());
            allDayDataEntity.setAskVolume(calcDataAsk.getFullVolume());
            allDayDataEntity.setBidVolume(calcDataBid.getFullVolume());
            allDayDataEntities.add(allDayDataEntity);

        }
        allDayDataService.saveAll(allDayDataEntities);
    }
    public CalcData finalPrice(List<CalcData> calcDatas)
    {
        double summVolume=0;
        double summPriceSize = 0;

        for (CalcData calcData:calcDatas)
        {
            summVolume = summVolume + calcData.getFullVolume();
            summPriceSize = summPriceSize + calcData.getAvgPrice()*calcData.getFullVolume();
        }
        CalcData temp = new CalcData();
        temp.setAvgPrice(1/summVolume*summPriceSize);;
        temp.setFullVolume(summVolume);
        return temp;
    }
    public CalcData avgPrice(List<OrdersSizePrice> ordersSizePrices)
    {

        double summVolume=0;
        double summPriceSize = 0;

        for (OrdersSizePrice ordersSizePrice:ordersSizePrices)
        {
            summVolume = summVolume + ordersSizePrice.getSize();
            summPriceSize = summPriceSize + ordersSizePrice.getSize()*ordersSizePrice.getPrice();
        }
        CalcData temp = new CalcData();
        temp.setAvgPrice(1/summVolume*summPriceSize);;
        temp.setFullVolume(summVolume);
        return temp;

    }
}
