package com.jinxuliang.springspademo.service;

import lombok.*;

//用于封装将要发送到客户端的信息
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientErrorInfo {
    private String message;
    private int statusCode;
}
