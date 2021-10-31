package org.imjs_man.dataCollector.dydxApi;

import com.google.gson.*;
import org.apache.tomcat.util.json.ParseException;
import org.imjs_man.dataCollector.calculator.Calculator;
import org.imjs_man.dataCollector.entity.DydxMarketEntity;
import org.imjs_man.dataCollector.entity.PairDepth;
import org.imjs_man.dataCollector.service.DydxMarketService;
import org.imjs_man.dataCollector.service.PairService;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;


@Service
@EnableScheduling
public class DydxService {

    @Autowired
    DydxParser dydxParser;

    @Autowired
    PairService pairService;

    @Autowired
    DydxMarketService dydxMarketService;
    @Autowired
    Calculator calculator;


    @Scheduled(fixedDelay = 10000)
    public void getAndSaveMarsToken()
    {
        try {
            List<DydxMarketEntity> dydxMarketEntities = dydxMarketService.getAll();
            for (DydxMarketEntity dydxMarketEntity: dydxMarketEntities) {
                String market = dydxMarketEntity.getMarket();
                Map<String, String> data = dydxParser.getPairDepthFromJson(getDepthByPair(market));
                PairDepth pairDepth = new PairDepth();
                pairDepth.setPairName(market);
                pairDepth.setAsks(data.get("asks"));
                pairDepth.setBids(data.get("bids"));
                pairService.save(pairDepth);
            }
        } catch (IOException | ParseException | JSONException e) {
            e.printStackTrace();
        }
    }


    public String getDepthByPair(String marketName) throws IOException {
        try {
            return Jsoup.connect("https://api.dydx.exchange/v3/orderbook/"+marketName)
                    .ignoreContentType(true)
                    .timeout(300000)
                    .get().body().text();

        } catch (IOException e) {
            throw new IOException(e.getMessage()); //todo create exception class
        }
    }



    @Scheduled(fixedDelay = 1000*60*60*24)
//    public DydxMarketEntity getAvalableMarkets()
    public void getAndSaveAvalableMarkets()
    {
        try {
            String json = Jsoup.connect("https://api.dydx.exchange/v3/markets")
                    .ignoreContentType(true)
                    .timeout(300000)
                    .get().body().text();
            JSONObject parser = new JSONObject(json);
            JSONObject markets = parser.getJSONObject("markets");
            List<DydxMarketEntity> marketEntities = new ArrayList<>();
            for (Iterator it = markets.keys(); it.hasNext(); ) {
                Object key = it.next();
                String reader  = markets.getJSONObject((String) key).toString();
                Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime();
                }
                }).create();
                DydxMarketEntity market = gson.fromJson(reader, DydxMarketEntity.class);
                marketEntities.add(market);
            }
            dydxMarketService.saveAll(marketEntities);
        } catch (IOException | JSONException e) {
            e.printStackTrace();         //todo create exception class
        }
    }
}
