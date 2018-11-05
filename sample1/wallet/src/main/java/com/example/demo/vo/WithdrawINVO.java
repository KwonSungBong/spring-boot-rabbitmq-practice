package com.example.demo.vo;

import lombok.Data;

@Data
public class WithdrawINVO {

    private long memberNo; // 회원번호
    private String currency; // 통화구분
    private long nodeId; // 노드아이디
    private String addressType; // 주소 타입 (E:외부지갑, I:내부지갑)
    private String receiveAddress; // 받는 주소
    private String locRcvAddress;	// 받는주소 식별자
    private String sendAddress; // 보내는 주소
    private String locSndAddress;	// 보내는주소 식별자
    private String volume; // 수량
    private String fee; // 수수료
    private String state; // R:대기,I:진행,C:완료,F:실패

}
