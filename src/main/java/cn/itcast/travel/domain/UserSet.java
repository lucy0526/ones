package cn.itcast.travel.domain;

import java.util.ArrayList;
import java.util.List;

public class UserSet
{

    public List<User> users = new ArrayList<>();

    public UserSet() {
    }

    public User put(int uid) {
        return new User(uid);
    }


    public User getUserByposition(int position) {
        return users.get(position);
    }

    public User getUser(int uid) {
        for (User user : users) {
            if (user.uid == uid) {
                return user;
            }
        }
        return null;
    }


    public final class User {
        public int uid;
        public List<Set> list = new ArrayList<>();

        private User(int uid) {
            this.uid = uid;
        }

        public User set(int tid, int score) {
            this.list.add(new Set(tid, score));
            return this;
        }

        public void create() {
            users.add(this);
        }

        public Set find(int tid) {
            for (Set set : list) {
                if (set.tid == tid) {
                    return set;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "User{" +
                    "uid='" + uid + '\'' +
                    '}';
        }
    }

    public final class Set implements Comparable<Set> {
        public int tid;
        public int score;

        public Set(int tid, int score) {
            this.tid = tid;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Set{" +
                    "tid='" + tid + '\'' +
                    ", score=" + score +
                    '}';
        }

        @Override
        public int compareTo(Set o) {
            return score > o.score ? -1 : 1;
        }
    }
}
