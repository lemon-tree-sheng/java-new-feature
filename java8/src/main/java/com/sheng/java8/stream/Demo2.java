package com.sheng.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shengxingyue, created on 2017/11/28
 */
public class Demo2 {

    public static void main(String[] args) {
        Property p1 = new Property("叫了个鸡", 1000, 500, 2);
        Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
        Property p3 = new Property("永和大王", 580, 3000, 1);
        Property p4 = new Property("肯德基", 6000, 200, 4);
        List<Property> propertyList = Arrays.asList(p1, p2, p3, p4);

        // 两种 lambda 方式排序，推荐下面一个
        Collections.sort(propertyList, (x, y) -> x.distance.compareTo(y.distance));
        Collections.sort(propertyList, Comparator.comparing(Property::getDistance));
        System.out.println("离我最近的店铺是：" + propertyList.get(0).getName());

        String result = propertyList.stream().sorted(Comparator.comparing(Property::getDistance)).findFirst().get().getName();
        System.out.println("离我最近的店铺是：" + result);

    }

}

/**
 * 店铺实体
 */
@Data
@AllArgsConstructor
class Property {
    String  name;
    Integer distance;
    Integer sales;
    Integer priceLevel;
}
