package cn.itcast.travel.domain;

public class Score
{
    int uid;
    int tid;
    float score;

    public Score(int uid, int tid, float score) {
        this.uid = uid;
        this.tid = tid;
        this.score = score;
    }

    public Score() {
    }

    @Override
    public String toString() {
        return "Score{" +
                "uid=" + uid +
                ", tid=" + tid +
                ", score=" + score +
                '}';
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
