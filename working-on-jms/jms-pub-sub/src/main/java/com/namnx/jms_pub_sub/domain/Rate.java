package com.namnx.jms_pub_sub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    private String code;
    private Float rateVal;
    private Date date;

    @Override
    public String toString() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return "Rate [code=" + code + ", rate=" + rateVal + ", date=" + format + "]";
    }
}
