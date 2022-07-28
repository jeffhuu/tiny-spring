package com.jeff.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 胡星宇 <huxingyu@leyaoyao.com>
 * @date 2022/07/28
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue pv : this.propertyValueList) {
            if (name.equals(pv.getName())) {
                return pv;
            }
        }
        return null;
    }

}
