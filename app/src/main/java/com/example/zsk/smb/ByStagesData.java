package com.example.zsk.smb;


public class ByStagesData {
    private String start;
    private String end;
    private float[] stime;
    private int[] svalue;

    public void setStart(String s){
        start = s;
    }
    public void setEnd(String s){
        end = s;
    }
    public void setStime(float[] s){
        stime = s;
    }
    public void setSvalue(int[] s){
        svalue = s;
    }

    public int getCount(){
        return stime.length;
    }
    public float[] getWeight(){
        return stime;
    }
    public int[] getSvalue(){
        return svalue;
    }
    public String getStart(){
        return start;
    }
    public String getEnd(){
        return end;
    }



}
