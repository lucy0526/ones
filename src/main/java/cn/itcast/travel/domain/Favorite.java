package cn.itcast.travel.domain;

import java.io.Serializable;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private String date;//收藏时间
    private int uid;//所属用户
    private int tid;

    /**
     * 无参构造方法
     */
    public Favorite() {
    }

    public Favorite(String date, int uid, int tid) {
        this.date = date;
        this.uid = uid;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "date='" + date + '\'' +
                ", uid=" + uid +
                ", tid=" + tid +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
