package cn.itcast.travel.dao;

import cn.itcast.travel.domain.UserSet;

import java.util.List;

public interface UserSetDao {
    public void updateRecommendation(int uid, List<UserSet.Set> recommendations);
    public void deleteAllByUId(int uid);
    public int findAllRecommendByUId(int uid);
}
