package com.jaskaranbir.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaska
 */
public class Question implements java.io.Serializable {
    
    private String category;
    private int value;
    private String question;
    private String[] options;
    private String rOption;
    private boolean valid;
    
    public Question() {
       this("", 0, "", new String[]{}, "");
    }
    
    public Question(String category, int value, String question, String[] options, String rOption) {        
        this.category = category;
        this.value = value;
        this.question = question;
        this.options = options;
        this.rOption = rOption;
        valid = true;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return options;
    }

    public void setAnswers(String[] answers) {
        this.options = answers;
    }
    
    public String getROption(){
        return rOption;
    }
    
    public void setInvalid() {
        valid = false;
    }
    
    public boolean isValid() {
        return valid;
    }
    
}