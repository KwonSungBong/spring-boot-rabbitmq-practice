package com.example.demo.vo;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Order {
    private BigInteger orderIdx;    //unsigned
    private String txId;            //uuid
    private String amount;          //amount
    private String state;           //state
    private Date createdAt;         //registration date time
    private Date updatedAt;         //updated date time
}