package com.yurii.rps.springboot_rest_rps;

public class Score {
    int wins;
    int ties;
    int losses;

    //constructor
    public Score(int wins, int ties, int losses) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }

    //default constructor
    public Score() {
        this.wins = 0;
        this.ties = 0;
        this.losses = 0;
    }

    //getter and setter methods
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    //toString method
    @Override
    public String toString() {
        return "Score{" +
                "wins=" + wins +
                ", ties=" + ties +
                ", losses=" + losses +
                '}';
    }

}
