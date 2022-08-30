package com.example.lab04;


import org.springframework.stereotype.*;

import java.io.Serializable;

@Component
public class Change implements Serializable {
    private int b1000;
    private int b500;
    private int b100;
    private int b20;
    private int b10;
    private int b5;
    private int b1;

    public Change(){
        this.b1 = 0;
        this.b5 = 0;
        this.b10 = 0;
        this.b20 = 0;
        this.b100 = 0;
        this.b500 = 0;
        this.b1000 = 0;
    }

    public Change(double balance){
        while(balance > 0){
            if(balance >= 1000){
                balance = balance - 1000;
                b1000 = b1000 + 1;
            }
            else if (balance >= 500 && balance < 1000){
                balance =  balance - 500;
                b500 = b500 + 1;
            }
            else if (balance >= 100 && balance < 500){
                balance = balance -100;
                b100 += 1;
            }
            else if (balance >= 20 && balance < 100) {
                balance = balance - 20;
                b20 += 1;
            }
            else if (balance >= 10 && balance < 20){
                balance = balance - 10;
                b10 += 1;
            }
            else if (balance >= 5 && balance < 10){
                balance = balance - 5;
                b5 += 1;
            }
            else if (balance >= 1 && balance < 5){
                balance = balance - 1;
                b1 += 1;
            }
            else{
                break;
            }
        }
    }
//    public Change(int b1000, int b500, int b100, int b20, int b10, int b5, int b1){
//
//    }

    public int getB1() {
        return b1;
    }

    public int getB5() {
        return b5;
    }

    public int getB10() {
        return b10;
    }

    public int getB20() {
        return b20;
    }

    public int getB100() {
        return b100;
    }

    public int getB500() {
        return b500;
    }

    public int getB1000() {
        return b1000;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }

    public void setB5(int b5) {
        this.b5 = b5;
    }

    public void setB10(int b10) {
        this.b10 = b10;
    }

    public void setB20(int b20) {
        this.b20 = b20;
    }

    public void setB100(int b100) {
        this.b100 = b100;
    }

    public void setB500(int b500) {
        this.b500 = b500;
    }

    public void setB1000(int b1000) {
        this.b1000 = b1000;
    }
}
