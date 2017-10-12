/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaskaranbir.beans;

/**
 *
 * @author jaska
 */
public class Player implements java.io.Serializable {
    
    private String name;
    private int wins;
    
    public Player(String name){
        this.name = name;
        wins = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    
}
