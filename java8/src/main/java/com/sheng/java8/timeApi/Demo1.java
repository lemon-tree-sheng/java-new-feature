package com.sheng.java8.timeApi;

import java.io.UnsupportedEncodingException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Base64;
import java.util.Date;

/**
 * @author shengxingyue, created on 2018/1/5
 */
public class Demo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // LocalDate
        LocalDate nowDate = now.toLocalDate();
        System.out.println(nowDate);

        // get something from LocalDate ...
        System.out.println(now.getSecond());
        System.out.println(now.getDayOfMonth());
        System.out.println(nowDate.getDayOfYear());

        // 附带月份和年份进行输出
        LocalDateTime now2 = now.withMonth(12).withYear(2016);
        System.out.println(now2);

        // 输出2016年圣诞节
        LocalDate christmas = LocalDate.of(2017, Month.DECEMBER, 12);
        System.out.println(christmas);

        // localtime
        LocalTime localTime = LocalTime.of(19, 0);
        System.out.println(localTime);

        // 解析字符串
        LocalTime localTime1 = LocalTime.parse("19:00:12");
        System.out.println(localTime1);

        // 当前日期加上两周后输出
        LocalDate localDate = nowDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate);

        // 计算两个时间的间隔
        Period period = Period.between(nowDate, christmas);
        System.out.println(period.getDays());

        // 计算下周一的时间并输出
        LocalDate nextDate = nowDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextDate);

        // 计算下个月的第二个星期天
        LocalDate nextMonth = nowDate.plusMonths(1);
        LocalDate firstDayOfNextMonth = LocalDate.of(nextDate.getYear(), nextMonth.getMonth(), 1);
        LocalDate targetDate = firstDayOfNextMonth.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(targetDate);

        //#######################################################
        // 将字符串代表的时区信息转化
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2016-04-20T19:22:15+01:30[Europe/Paris]");
        System.out.println(zonedDateTime);

        // 设定地区ID为亚洲的加尔各答（位于印度），并输出
        ZoneId id = ZoneId.of("Asia/Kolkata");
        System.out.println(id);

        // 获取系统默认时区
        ZoneId current = ZoneId.systemDefault();
        System.out.println(current);

        // #######################################################
        // 兼容原来的 API，使用 instant
        Date old = new Date();
        Instant instant = old.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDate localDate1 = LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
        System.out.println(localDate1);

        // #######################################################
        // base64 编解码
        String originalString = "shengxingyue";
        String encodeString = Base64.getEncoder().encodeToString(originalString.getBytes("utf-8"));
        System.out.println("encode:" + encodeString);
        byte[] decodeString = Base64.getDecoder().decode(encodeString);
        System.out.println("decode:" + new String(decodeString, "utf-8"));

    }
}
