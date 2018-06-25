package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

public enum CURRENCY {
	// 정렬 우선순위가 높은 순서대로 작성하시오 
	ALL("LBL.CURR_ALL","ALL"), // 원화
	KRW("LBL.CURR_KRW","W"), // 원화
	BTC("LBL.CURR_BTC","BTC"), // 비트코인
	ETH("LBL.CURR_ETH","ETH"), // 이더리움
	QTUM("LBL.CURR_QTUM","QTUM"), // 퀀텀
	SC("LBL.CURR_SC","SC"), // 시아
	XRP("LBL.CURR_XRP","XRP"), // 리플
    NPXS("LBL.CURR_NPXS","NPXS"),	// 펀디엑스
    SNT("LBL.CURR_SNT","SNT"),	// 스테이터스
    GTO("LBL.CURR_GTO","GTO"),	// 기프토
    OMG("LBL.CURR_OMG(","OMG"),	// 오미세고
    GNT("LBL.CURR_GNT","GNT");	// 골렘

	private String msgId;
	private String codeValue;

	CURRENCY(String msgId, String codeValue) {
		this.msgId = msgId;
		this.codeValue = codeValue;
	}

    public String getMsgId(){
        return this.msgId;
    }

    public String getCodeValue() {
        return this.codeValue;
    }

    public boolean isEquals(String value){
        return this.name().equals(value);
    }

    public static List<CURRENCY> coinList(){
        List<CURRENCY> list = new ArrayList<>();
        for (CURRENCY crncy : CURRENCY.values()) {
            if (crncy == CURRENCY.KRW || crncy == CURRENCY.ALL) {
                continue;
            }
            list.add(crncy);
        }
        return list;
    }
    
    public static List<CURRENCY> crncyCdList(){
        List<CURRENCY> list = new ArrayList<>();
        for (CURRENCY crncy : CURRENCY.values()) {
            if (crncy == CURRENCY.ALL) {
                continue;
            }
            list.add(crncy);
        }
        return list;
    }
}
