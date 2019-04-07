package com.szxs.test;

import java.util.UUID;

public class TestUUID {

    public static void main(String[] args) {
        while (!UUID.randomUUID().toString().equals(UUID.randomUUID().toString())){
            System.out.println(UUID.randomUUID().toString().length());
        }
    }
}
