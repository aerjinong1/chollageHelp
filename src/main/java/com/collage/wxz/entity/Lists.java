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

    private Integer listId;
    private Integer staffId;
    private Integer customerId;
    private String listCreateTime;
    private String ListCompleteTime;
    private Integer listState;
    private String customerMessage;
    private Integer listEvaluateLevel;   //用户评分
    private String ListEvaluateMessage;//用户评价
    private String startPoint;
    private String endPoint;
    private String pic;
}
