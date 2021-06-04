package cn.kk.springframework;

/**
 * @Description TODO
 * @Date 2021/6/4 15:01
 * @Version 1.0
 * @Author zhangkk
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
