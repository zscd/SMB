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
    }            //返回各分期时间
    public int[] getSvalue(){
        return svalue;
    }             //返回分期状态
    public String getStart(){
        return start;
    }
    public String getEnd(){
        return end;
    }



}
