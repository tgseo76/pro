package com.example.project.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public int num(int num){
        int sum =0;
        while (num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}
