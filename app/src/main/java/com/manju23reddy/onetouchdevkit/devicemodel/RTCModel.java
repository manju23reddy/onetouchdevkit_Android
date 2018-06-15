package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class RTCModel implements Parcelable {
    private int rtc_control;
    private int rtc_alarm_control;
    private int rtc_time_settings;
    private int rtc_time_alarm_settings;

    public RTCModel(){

    }

    public RTCModel(Parcel in){
        rtc_control = in.readInt();
        rtc_alarm_control = in.readInt();
        rtc_time_settings = in.readInt();
        rtc_time_alarm_settings = in.readInt();
    }

    public int getRtc_control(){
        return rtc_control;
    }

    public int getRtc_alarm_control(){
        return rtc_alarm_control;
    }

    public int getRtc_time_settings(){
        return rtc_time_settings;
    }

    public int getRtc_time_alarm_settings(){
        return rtc_time_alarm_settings;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rtc_control);
        dest.writeInt(rtc_alarm_control);
        dest.writeInt(rtc_time_settings);
        dest.writeInt(rtc_time_alarm_settings);
    }

    public final static Creator<RTCModel> CREATOR = new ClassLoaderCreator<RTCModel>() {
        @Override
        public RTCModel createFromParcel(Parcel source, ClassLoader loader) {
            return new RTCModel(source);
        }

        @Override
        public RTCModel createFromParcel(Parcel source) {
            return new RTCModel(source);
        }

        @Override
        public RTCModel[] newArray(int size) {
            return new RTCModel[0];
        }
    };
}
