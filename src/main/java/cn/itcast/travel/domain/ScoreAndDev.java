package cn.itcast.travel.domain;

public class ScoreAndDev {
    private int uid;
    private int dev_count;
    private float score;


  /*  public int hashCode() {
        return uid;
    }

    public boolean equals(Object obj) {
        ScoreAndDev scoreAndDev = (ScoreAndDev) obj;
        return this.uid==scoreAndDev.uid;
    }*/



    public ScoreAndDev(int uid, int dev_count, float score) {
        this.uid = uid;
        this.dev_count = dev_count;
        this.score = score;
    }

    public ScoreAndDev() {
    }

    @Override
    public String toString() {
        return "ScoreAndDev{" +
                "uid=" + uid +
                ", dev_count=" + dev_count +
                ", score=" + score +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDev_count() {
        return dev_count;
    }

    public void setDev_count(int dev_count) {
        this.dev_count = dev_count;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
