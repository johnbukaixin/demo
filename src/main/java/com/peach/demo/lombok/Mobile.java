package com.peach.demo.lombok;

import lombok.*;

/**
 * create by panta on 2017/12/9
 */
@ToString(callSuper = true,exclude = {"os"})
public class Mobile {

    @Getter@Setter(AccessLevel.PROTECTED)
    private String name;

    @NonNull
    private String color;

    private String os;
}
