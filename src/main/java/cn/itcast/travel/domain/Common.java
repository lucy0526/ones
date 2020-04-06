package cn.itcast.travel.domain;

public class Common {
    private int cid;
    private int tid;
    private int uid;
    private int c_like;
    private String cdescribe;
    private String cdate;//出生日期

    public Common() {
    }

    public Common(int cid, int tid, int uid, int c_like, String cdescribe, String cdate) {
        this.cid = cid;
        this.tid = tid;
        this.uid = uid;
        this.c_like = c_like;
        this.cdescribe = cdescribe;
        this.cdate = cdate;
    }

    public int getC_like() {
        return c_like;
    }

    public void setC_like(int c_like) {
        this.c_like = c_like;
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
