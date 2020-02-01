package cn.itcast.travel.domain;

import java.io.Serializable;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private String date;//收藏时间
    private User user;//所属用户
    private TestTol testTol;

    /**
     * 无参构造方法
     */
    public Favorite() {
    }


    public Favorite(String date, User user, TestTol testTol) {
        this.date = date;
        this.user = user;
        this.testTol = testTol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestTol getTestTol() {
        return testTol;
    }

    public void setTestTol(TestTol testTol) {
        this.testTol = testTol;
    }
}
