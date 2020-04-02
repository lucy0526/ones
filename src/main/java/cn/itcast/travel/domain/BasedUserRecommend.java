package cn.itcast.travel.domain;

public class BasedUserRecommend {
    private int uid;
    private int tid;
    private float preScore;

    @Override
    public String toString() {
        return "BasedUserRecommend{" +
                "uid=" + uid +
                ", tid=" + tid +
                ", preScore=" + preScore +
                '}';
    }

    public BasedUserRecommend() {
    }

    public BasedUserRecommend(int uid, int tid, float preScore) {
        this.uid = uid;
        this.tid = tid;
        this.preScore = preScore;
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

    public float getPreScore() {
        return preScore;
    }

    public void setPreScore(float preScore) {
        this.preScore = preScore;
    }
}
