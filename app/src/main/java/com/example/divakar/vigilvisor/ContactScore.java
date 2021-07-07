package com.example.divakar.vigilvisor;

/**
 * Created by DIVAKAR on 19-11-2016.
 */

public class ContactScore {

    private String PRN,Score;
    public ContactScore(String PRN,String Score)
    {
        this.setPRN(PRN);
        this.setScore(Score);
     //   this.setOptionB(OptionB);
       // this.setOptionC(OptionC);
        //this.setOptionD(OptionD);
        //this.setAnswer(Answer);
    }
    public String getPRN()
    {
        return PRN;
    }
    public void setPRN(String PRN)
    {
        this.PRN =PRN;
    }
    public String getScore()
    {
        return Score;
    }
    public void setScore(String Score)
    {
        this.Score =Score;
    }


}
