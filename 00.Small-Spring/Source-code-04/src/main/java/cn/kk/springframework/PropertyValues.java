package cn.kk.springframework;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/4 15:01
 * @Version 1.0
 * @Author zhangkk
 */
public class PropertyValues {
  private final List<PropertyValue> propertyValueList = new ArrayList<>();

  public void addPropertyValue(PropertyValue pv) {
    this.propertyValueList.add(pv);
  }

  public PropertyValue[] getPropertyValues() {
    return this.propertyValueList.toArray(new PropertyValue[0]);
  }

  public PropertyValue getPropertyValue(String propertyName) {
    for (PropertyValue pv : this.propertyValueList) {
      if (pv.getName().equals(propertyName)) {
        return pv;
      }
    }
    return null;
  }
}
