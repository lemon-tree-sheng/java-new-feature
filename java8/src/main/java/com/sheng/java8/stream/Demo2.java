package com.sheng.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Iterator;
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

        // for 循环
        int count = 0;
        for (Property property : propertyList) {
            if (property.getSales() > 1000) {
                count++;
            }
        }
        System.out.println("销量大于1000的店铺数量:" + count);

        // 迭代器
        int count2 = 0;
        Iterator iterator = propertyList.iterator();
        while (iterator.hasNext()) {
            Property property = (Property) iterator.next();
            if (property.getSales() > 1000) {
                count2++;
            }
        }
        System.out.println("销量大于1000的店铺数量:" + count2);

        // stream api
        long count3 = propertyList.stream().filter(property -> property.getSales() > 1000).count();
        System.out.println("销量大于1000的店铺数量:" + count3);
    }

}

/**
 * 店铺实体
 */
@Data
@AllArgsConstructor
class Property {
    String name;
    Integer distance;
    Integer sales;
    Integer priceLevel;
}
