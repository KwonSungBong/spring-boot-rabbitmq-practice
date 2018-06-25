package com.example.demo.vo;

import lombok.Data;

@Data
public class Cancel {
    private java.math.BigInteger idx;
    private long memberNo;
    private String txId;
    private String state;
    private String withdrawQty;
    private java.util.Date createdAt;
    private java.util.Date updatedAt;
    private String basePrice;
    private String baseCurrency;
    private String tradeCurrency;
}
