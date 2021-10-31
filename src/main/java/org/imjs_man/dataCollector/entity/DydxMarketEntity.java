package org.imjs_man.dataCollector.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DydxMarketEntity {
    @Id
    private String market;
    private String status;
    private String baseAsset;
    private String quoteAsset;
    private double stepSize;
    private double tickSize;
    private double indexPrice;
    private double oraclePrice;
    private double priceChange24H;
    private double nextFundingRate;
    private LocalDateTime nextFundingAt;
    private double minOrderSize;
    private String type;
    private double initialMarginFraction;
    private double maintenanceMarginFraction;
    private double volume24H;
    private double trades24H;
    private double openInterest;
    private double incrementalInitialMarginFraction;
    private double incrementalPositionSize;
    private int maxPositionSize;
    private int baselinePositionSize;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public double getStepSize() {
        return stepSize;
    }

    public void setStepSize(double stepSize) {
        this.stepSize = stepSize;
    }

    public double getTickSize() {
        return tickSize;
    }

    public void setTickSize(double tickSize) {
        this.tickSize = tickSize;
    }

    public double getIndexPrice() {
        return indexPrice;
    }

    public void setIndexPrice(double indexPrice) {
        this.indexPrice = indexPrice;
    }

    public double getOraclePrice() {
        return oraclePrice;
    }

    public void setOraclePrice(double oraclePrice) {
        this.oraclePrice = oraclePrice;
    }

    public double getPriceChange24H() {
        return priceChange24H;
    }

    public void setPriceChange24H(double priceChange24H) {
        this.priceChange24H = priceChange24H;
    }

    public double getNextFundingRate() {
        return nextFundingRate;
    }

    public void setNextFundingRate(double nextFundingRate) {
        this.nextFundingRate = nextFundingRate;
    }

    public LocalDateTime getNextFundingAt() {
        return nextFundingAt;
    }

    public void setNextFundingAt(LocalDateTime nextFundingAt) {
        this.nextFundingAt = nextFundingAt;
    }

    public double getMinOrderSize() {
        return minOrderSize;
    }

    public void setMinOrderSize(double minOrderSize) {
        this.minOrderSize = minOrderSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getInitialMarginFraction() {
        return initialMarginFraction;
    }

    public void setInitialMarginFraction(double initialMarginFraction) {
        this.initialMarginFraction = initialMarginFraction;
    }

    public double getMaintenanceMarginFraction() {
        return maintenanceMarginFraction;
    }

    public void setMaintenanceMarginFraction(double maintenanceMarginFraction) {
        this.maintenanceMarginFraction = maintenanceMarginFraction;
    }

    public double getVolume24H() {
        return volume24H;
    }

    public void setVolume24H(double volume24H) {
        this.volume24H = volume24H;
    }

    public double getTrades24H() {
        return trades24H;
    }

    public void setTrades24H(double trades24H) {
        this.trades24H = trades24H;
    }

    public double getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(double openInterest) {
        this.openInterest = openInterest;
    }

    public double getIncrementalInitialMarginFraction() {
        return incrementalInitialMarginFraction;
    }

    public void setIncrementalInitialMarginFraction(double incrementalInitialMarginFraction) {
        this.incrementalInitialMarginFraction = incrementalInitialMarginFraction;
    }

    public double getIncrementalPositionSize() {
        return incrementalPositionSize;
    }

    public void setIncrementalPositionSize(double incrementalPositionSize) {
        this.incrementalPositionSize = incrementalPositionSize;
    }

    public int getMaxPositionSize() {
        return maxPositionSize;
    }

    public void setMaxPositionSize(int maxPositionSize) {
        this.maxPositionSize = maxPositionSize;
    }

    public int getBaselinePositionSize() {
        return baselinePositionSize;
    }

    public void setBaselinePositionSize(int baselinePositionSize) {
        this.baselinePositionSize = baselinePositionSize;
    }
}
