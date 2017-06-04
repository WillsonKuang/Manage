package com.willson.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangwsa on 2017/2/27.
 */
public class DateConverter implements Converter<String, Date> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convert(String stringDate) {
        if (StringUtils.isNotBlank(stringDate)) {
            try {
                return simpleDateFormat.parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
