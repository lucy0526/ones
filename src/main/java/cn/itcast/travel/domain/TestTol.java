package cn.itcast.travel.domain;

import java.util.List;

public class TestTol {
    private int tid;//测试工具id，必输
    private String tname;//测试工具名称，必输
    private double price;//价格，必输
    private String testIntroduce;//测试工具介绍
    private String tflag;   //是否可用，必输，0代表不可用，1代表是可以用
    private String tdate;   //上架时间
    private int count;//收藏数量
    private int cid;//所属分类，必输
    private String rimage;//缩略图
    private String source;//抓取数据的来源地址

    private Category category;//所属分类
    private List<RouteImg> routeImgList;//商品详情图片列表

    public TestTol() {
    }

    public TestTol(int tid, String tname, double price, String testIntroduce, String tflag, String tdate, int count, int cid, String rimage, String source, Category category, List<RouteImg> routeImgList) {
        this.tid = tid;
        this.tname = tname;
        this.price = price;
        this.testIntroduce = testIntroduce;
        this.tflag = tflag;
        this.tdate = tdate;
        this.count = count;
        this.cid = cid;
        this.rimage = rimage;
        this.source = source;
        this.category = category;
        this.routeImgList = routeImgList;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTestIntroduce() {
        return testIntroduce;
    }

    public void setTestIntroduce(String testIntroduce) {
        this.testIntroduce = testIntroduce;
    }

    public String getTflag() {
        return tflag;
    }

    public void setTflag(String tflag) {
        this.tflag = tflag;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<RouteImg> getRouteImgList() {
        return routeImgList;
    }

    public void setRouteImgList(List<RouteImg> routeImgList) {
        this.routeImgList = routeImgList;
    }
}
