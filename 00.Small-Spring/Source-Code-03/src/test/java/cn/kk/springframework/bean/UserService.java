package cn.kk.springframework.bean;


public class UserService {

    public UserService() {

    }

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

}
