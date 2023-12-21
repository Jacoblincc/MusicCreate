package com.jinxuliang.springspademo.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private int id;
    private String name;
}
