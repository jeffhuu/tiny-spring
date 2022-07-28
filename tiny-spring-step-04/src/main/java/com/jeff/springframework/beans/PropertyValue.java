package com.jeff.springframework.beans;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/28
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
