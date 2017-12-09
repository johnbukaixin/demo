package com.peach.demo.lombok;

import lombok.Cleanup;
import sun.applet.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * create by panta on 2017/12/9
 */
public class Test {
    public static void main(String[] args) {

        try {
            @Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(new byte[] {'Y','e','s'});
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
