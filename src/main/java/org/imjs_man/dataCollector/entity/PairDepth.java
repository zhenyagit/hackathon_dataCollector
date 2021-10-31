package org.imjs_man.dataCollector.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PairDepth {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String pairName;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String asks;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String bids;

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

    public String getAsks() {
        return asks;
    }

    public void setAsks(String asks) {
        this.asks = asks;
    }

    public String getBids() {
        return bids;
    }

    public void setBids(String bids) {
        this.bids = bids;
    }
}
