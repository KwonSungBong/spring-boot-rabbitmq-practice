package com.example.demo.vo;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Trade {
    private BigInteger conclusionIdx;
    private String takerOrderGbn;
    private String takerTxId;
    private long takerMemberNo;
    private String takerBasePrice;
    private String takerFee;
    private String takerFeeCurrency;
    private String takerRemainQty;
    private String takerState;
    private long makerMemberNo;
    private String makerTxId;
    private String makerFee;
    private String makerBasePrice;
    private String makerFeeCurrency;
    private String makerRemainQty;
    private String makerState;
    private String baseCurrency;
    private String tradeCurrency;
    private String dealQty;
    private String dealPrice;
    private String dealFiatRate;
    private String dealTotPrice;
    private Date dealCreatedAt;
}
