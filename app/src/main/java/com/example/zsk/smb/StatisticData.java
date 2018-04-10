package com.example.zsk.smb;


public class StatisticData {
    private int score; //睡眠分数
    private String start;
    private String end; //入睡时间、醒来时间
    private String deepsleep, lightsleep; //深睡时长、浅睡时长
    private int[] heartrate; //每分钟心率数据
    private int[] respiratory; //每分钟呼吸速率
    private int apnea; //呼吸暂停次数
    private int unusualrate; //心率异常次数
    private String suggest; //睡眠建议

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDeepsleep() {
        return deepsleep;
    }

    public String getLightsleep() {
        return lightsleep;
    }

    public void setLightsleep(String lightsleep) {
        this.lightsleep = lightsleep;
    }

    public void setDeepsleep(String deepsleep) {
        this.deepsleep = deepsleep;
    }

    public int[] getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int[] heartrate) {
        this.heartrate = heartrate;
    }

    public int getApnea() {
        return apnea;
    }

    public void setApnea(int apnea) {
        this.apnea = apnea;
    }

    public int[] getRespiratory() {

        return respiratory;
    }

    public void setRespiratory(int[] respiratory) {
        this.respiratory = respiratory;
    }

    public int getUnusualrate() {
        return unusualrate;
    }

    public void setUnusualrate(int unusualrate) {
        this.unusualrate = unusualrate;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }
}
