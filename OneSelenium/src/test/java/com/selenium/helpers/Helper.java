package com.selenium.helpers;

public class Helper {

    public void sleepSeconds(Integer seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}
