package org.imjs_man.dataCollector.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllDayDataEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String pairName;
    private double askVolume;
    private double bidVolume;
    private double askPrice;
    private double bidPrice;
    @Column(name = "created_on")
    private LocalDateTime createdOn;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public double getAskVolume() {
        return askVolume;
    }

    public void setAskVolume(double askVolume) {
        this.askVolume = askVolume;
    }

    public double getBidVolume() {
        return bidVolume;
    }

    public void setBidVolume(double bidVolume) {
        this.bidVolume = bidVolume;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }
}
