package cn.itcast.travel.domain;

public class UserSetRecommend {
    private int uid;
    private int ruid;

    @Override
    public String toString() {
        return "UserSetRecommend{" +
                "uid=" + uid +
                ", ruid=" + ruid +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRuid() {
        return ruid;
    }

    public void setRuid(int ruid) {
        this.ruid = ruid;
    }

    public UserSetRecommend(int uid, int ruid) {
        this.uid = uid;
        this.ruid = ruid;
    }

    public UserSetRecommend() {
    }
}
