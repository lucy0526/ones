package cn.itcast.travel.domain;

public class Dev {
    private int uid1;
    private int uid2;
    private float dev;
    private int dev_count;

    public Dev() {
    }

    public Dev(int uid1, int uid2, float dev, int dev_count) {
        this.uid1 = uid1;
        this.uid2 = uid2;
        this.dev = dev;
        this.dev_count = dev_count;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "uid1=" + uid1 +
                ", uid2=" + uid2 +
                ", dev=" + dev +
                ", dev_count=" + dev_count +
                '}';
    }

    public int getUid1() {
        return uid1;
    }

    public void setUid1(int uid1) {
        this.uid1 = uid1;
    }

    public int getUid2() {
        return uid2;
    }

    public void setUid2(int uid2) {
        this.uid2 = uid2;
    }

    public float getDev() {
        return dev;
    }

    public void setDev(float dev) {
        this.dev = dev;
    }

    public int getDev_count() {
        return dev_count;
    }

    public void setDev_count(int dev_count) {
        this.dev_count = dev_count;
    }
}
