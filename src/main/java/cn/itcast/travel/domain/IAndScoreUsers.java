package cn.itcast.travel.domain;

import java.util.List;

public class IAndScoreUsers {
    private int tid;
    private List<ScoreAndDev> scoreAndDevList;

    public int hashCode() {
        return tid;
    }

    public boolean equals(Object obj) {
        IAndScoreUsers iAndScoreUsers = (IAndScoreUsers) obj;
        return this.tid == iAndScoreUsers.tid;
    }

    public IAndScoreUsers(int tid, List<ScoreAndDev> scoreAndDevSet) {
        this.tid = tid;
        this.scoreAndDevList = scoreAndDevSet;
    }

    public IAndScoreUsers() {
    }

    @Override
    public String toString() {
        return "IAndScoreUsers{" +
                "tid=" + tid +
                ", scoreAndDevSet=" + scoreAndDevList +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public List<ScoreAndDev> getScoreAndDevList() {
        return scoreAndDevList;
    }

    public void setScoreAndDevList(List<ScoreAndDev> scoreAndDevList) {
        this.scoreAndDevList = scoreAndDevList;
    }
}
