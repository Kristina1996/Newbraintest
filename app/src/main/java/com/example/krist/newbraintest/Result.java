package com.example.krist.newbraintest;

/**
 * Created by krist on 05.06.2018.
 */

public class Result {

    private String id_user;
    private String id_test;
    private int score;

    public Result(){

    }

    public Result(String id_user, String id_test, int score){
        id_user = id_user;
        id_test = id_test;
        score = score;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_test() {
        return id_test;
    }

    public void setId_test(String id_test) {
        this.id_test = id_test;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
