package com.example.divakar.vigilvisor;

/**
 * Created by DIVAKAR on 08-11-2016.
 */

public class ContactsPoll {
    private String Question,OptionA,OptionB,OptionC,OptionD;
    public ContactsPoll(String Question)
    {
        this.setQuestion(Question);
    }
    public String getQuestion()
    {
        return Question;
    }
    public void setQuestion(String Question)
    {
        this.Question =Question;
    }




}
