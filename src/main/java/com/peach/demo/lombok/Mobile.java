package com.peach.demo.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * create by panta on 2017/12/9
 */
public class Mobile {

    @Getter@Setter(AccessLevel.PROTECTED)
    private String name;

    @NonNull
    private String color;

    private String os;
}
