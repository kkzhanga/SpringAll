package cn.kk.springframework.bean;

/**
 * @Description TODO
 * @Date 2021/6/4 16:15
 * @Version 1.0
 * @Author zhangkk
 */
public class UserPropertyService {
  private String uId;

  private UserDao userDao;

  public void queryUserInfo() {
    System.out.println("UserPropertyService查询用户信息：" + userDao.queryUserName(uId));
  }

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

}
