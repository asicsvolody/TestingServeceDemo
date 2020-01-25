/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return FORMATTER.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return FORMATTER.format(date);
    }
}
