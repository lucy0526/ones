package cn.itcast.travel.service;

public interface FavoriteService {
    public boolean isFavorite(String tid, int uid);

    void add(String tid, int uid);
}
