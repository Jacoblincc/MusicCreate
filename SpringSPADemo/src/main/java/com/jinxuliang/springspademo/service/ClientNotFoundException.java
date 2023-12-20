package com.jinxuliang.springspademo.service;

//业务逻辑异常，表示“某Client没有找到“这个业务场景
public class ClientNotFoundException
        extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }
}
