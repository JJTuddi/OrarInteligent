package com.orar.timp;

public class Counter {
    int timestamp, endingTimeStamp;
    private int timpToTimeStamp(Timp timp) {
        return timp.getSecunde() + timp.getMinute() * 60 + timp.getHour() * 3600;
    }

    public Counter(Timp timp, int nMin) {
        this.endingTimeStamp = timpToTimeStamp(timp) + 60 * nMin;
        timestamp = timpToTimeStamp(timp);
    }

    public void setTimeStamp(int newTimeStamp) {
        timestamp = newTimeStamp;
    }

    public int getTimeStampDifference() {
        return endingTimeStamp - timestamp;
    }

    public static int getSeconds(int timestampDif) {
        return timestampDif % 60;
    }

    public static int getMinutes(int timestampDif) {
        return (timestampDif / 60) % 60;
    }
}
