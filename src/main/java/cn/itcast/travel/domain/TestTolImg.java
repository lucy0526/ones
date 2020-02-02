package cn.itcast.travel.domain;

public class TestTolImg {
    private int tgid;//商品图片id
    private int tid;//旅游商品id
    private String bigPic;//详情商品大图
    private String smallPic;//详情商品小图

    public TestTolImg() {
    }

    public TestTolImg(int tgid, int tid, String bigPic, String smallPic) {
        this.tgid = tgid;
        this.tid = tid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    public int getTgid() {
        return tgid;
    }

    public void setTgid(int tgid) {
        this.tgid = tgid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }
}
