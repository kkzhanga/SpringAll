package cn.kk.springframework.bean;


public class UserService {

    private String name;

    public UserService() {

    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("UserService查询用户信息：" + name);
    }

}
