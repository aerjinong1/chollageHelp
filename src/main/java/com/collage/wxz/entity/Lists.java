package com.collage.wxz.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Lists implements Serializable {
//    private static final Integer 好评=5;
//    private static final Integer 差评=0;
//    private static final Integer 未接单=1;
//    private static final Integer 已接单=2;
//    private static final Integer 已送达=3;
//    private static final Integer 已完成=4;
//    private static final Integer 已取消=9;
    Integer listId;
    Integer staffId;
    Integer customerId;
    String listCreateTime;
    String ListCompleteTime;
    Integer listState;
    String customerMessage;
    Integer listEvaluateLevel;   //用户评分
    String ListEvaluateMessage;//用户评价
    String startPoint;
    String endPoint;
}
