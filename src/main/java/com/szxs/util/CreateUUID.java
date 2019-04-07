package com.szxs.util;

import java.util.UUID;

public class CreateUUID {

    public static void main(String[] args) {
         int i=0;
        while (!UUID.randomUUID().toString().equals(UUID.randomUUID().toString())){
            System.out.println(i++);
        }
    }

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
