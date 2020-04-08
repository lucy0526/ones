package cn.itcast.travel.domain;

import java.util.List;

public class RecommendToPage {
    private int tid;
    private float preScore;

    private String tname;//测试工具名称，必输
    private int count;//收藏数量
    private String timage;//缩略图

    public RecommendToPage() {
    }

    public RecommendToPage(int tid, float preScore, String tname, int count, String timage) {
        this.tid = tid;
        this.preScore = preScore;
        this.tname = tname;
        this.count = count;
        this.timage = timage;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public float getPreScore() {
        return preScore;
    }

    public void setPreScore(float preScore) {
        this.preScore = preScore;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }

    @Override
    public String toString() {
        return "RecommendToPage{" +
                "tid=" + tid +
                ", preScore=" + preScore +
                ", tname='" + tname + '\'' +
                ", count=" + count +
                ", timage='" + timage + '\'' +
                '}';
    }
}
