package com.example.prototipo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate extends Date {
    public CustomDate(long date){
        super(date);
    }
    public CustomDate(){
        super();
    }

    @Override
    public String toString(){
        return new SimpleDateFormat("dd/MM/yyyy").format(this);
    }
}
