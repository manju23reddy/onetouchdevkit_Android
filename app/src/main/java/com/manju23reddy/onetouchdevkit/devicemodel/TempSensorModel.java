package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class TempSensorModel implements Parcelable {

    private int sensor_temperature_control;
    private int sensor_temperature_threshold_low;
    private int sensor_temperature_threshold_high;
    private int sensor_temperature_value;
    private int sensor_temperature_alarm;

    public TempSensorModel(){

    }

    public TempSensorModel(Parcel in){
        sensor_temperature_control = in.readInt();
        sensor_temperature_threshold_low = in.readInt();
        sensor_temperature_threshold_high = in.readInt();
        sensor_temperature_value = in.readInt();
        sensor_temperature_alarm = in.readByte();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sensor_temperature_control);
        dest.writeInt(sensor_temperature_threshold_low);
        dest.writeInt(sensor_temperature_threshold_high);
        dest.writeInt(sensor_temperature_value);
        dest.writeInt(sensor_temperature_alarm);
    }

    public int getSensor_temperature_control(){
        return sensor_temperature_control;
    }

    public int getSensor_temperature_threshold_low(){
        return sensor_temperature_threshold_low;
    }

    public int getSensor_temperature_threshold_high(){
        return sensor_temperature_threshold_high;
    }

    public int getSensor_temperature_value(){
        return sensor_temperature_value;
    }

    public int getSensor_temperature_alarm(){
        return sensor_temperature_alarm;
    }

    public final static Creator<TempSensorModel> CREATOR = new ClassLoaderCreator<TempSensorModel>() {
        @Override
        public TempSensorModel createFromParcel(Parcel source, ClassLoader loader) {
            return new TempSensorModel(source);
        }

        @Override
        public TempSensorModel createFromParcel(Parcel source) {
            return new TempSensorModel(source);
        }

        @Override
        public TempSensorModel[] newArray(int size) {
            return new TempSensorModel[0];
        }
    };
}
