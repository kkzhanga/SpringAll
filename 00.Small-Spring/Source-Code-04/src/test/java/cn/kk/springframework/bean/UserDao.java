package cn.kk.springframework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2021/6/4 15:56
 * @Version 1.0
 * @Author zhangkk
 */
public class UserDao {
  private static Map<String, String> hashMap = new HashMap<>();

  static {
    hashMap.put("10001", "广隶哥");
  }

  public String queryUserName(String uId) {
    return hashMap.get(uId);
  }

}
