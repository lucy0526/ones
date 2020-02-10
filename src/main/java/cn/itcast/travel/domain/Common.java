package cn.itcast.travel.domain;

public class Common {
    private int cid;
    private int tid;
    private int uid;
    private int like;
    private String cdescribe;
    private String cdate;//出生日期

    public Common() {
    }

    public Common(int cid, int tid, int uid, int like, String cdescribe, String cdate) {
        this.cid = cid;
        this.tid = tid;
        this.uid = uid;
        this.like = like;
        this.cdescribe = cdescribe;
        this.cdate = cdate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}
