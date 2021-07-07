package com.example.divakar.vigilvisor;

import android.content.Context;

/**
 * Created by DIVAKAR on 06-11-2016.
 */

public class Contacts {

    private String Question,OptionA,OptionB,OptionC,OptionD;
    public Contacts(String Question,String OptionA,String OptionB,String OptionC,String OptionD)
    {
        this.setQuestion(Question);
        this.setOptionA(OptionA);
        this.setOptionB(OptionB);
        this.setOptionC(OptionC);
        this.setOptionD(OptionD);
        //this.setAnswer(Answer);
    }
    public String getQuestion()
    {
       return Question;
    }
    public void setQuestion(String Question)
    {
        this.Question =Question;
    }
    public String getOptionA()
    {
        return OptionA;
    }
    public void setOptionA(String OptionA)
    {
        this.OptionA =OptionA;
    }
    public String getOptionB()
    {
        return OptionB;
    }
    public void setOptionB(String OptionB)
    {
        this.OptionB =OptionB;
    }
    public String getOptionC()
    {
        return OptionC;
    }
    public void setOptionC(String OptionC)
    {
        this.OptionC =OptionC;
    }
    public String getOptionD()
    {
        return OptionD;
    }
    public void setOptionD(String OptionD)
    {
        this.OptionD =OptionD;
    }
   // public String getAnswer(String Answer){return Answer;}
    //public void setAnswer(String Answer){this.Answer=Answer;}
}
