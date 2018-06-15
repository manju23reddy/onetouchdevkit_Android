package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class MotionSensorModel implements Parcelable {
    private int sensor_motion_control;
    private int sensor_motion_wakeup_control;
    private int sensor_motion_wakeup_threshold;
    private int sensor_motion_calibration_control;
    private int sensor_motion_value;

    public MotionSensorModel(){

    }


    public MotionSensorModel(Parcel inMode){
        sensor_motion_control = inMode.readInt();
        sensor_motion_wakeup_control = inMode.readInt();
        sensor_motion_wakeup_threshold = inMode.readInt();
        sensor_motion_calibration_control = inMode.readInt();
        sensor_motion_value = inMode.readInt();
    }

    public int getSensor_motion_control(){
        return sensor_motion_control;
    }

    public int getSensor_motion_wakeup_control(){
        return sensor_motion_wakeup_control;
    }

    public int getSensor_motion_wakeup_threshold(){
        return sensor_motion_wakeup_threshold;
    }

    public int getSensor_motion_calibration_control(){
        return sensor_motion_calibration_control;
    }

    public int getSensor_motion_value(){
        return sensor_motion_value;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(sensor_motion_control);
        dest.writeInt(sensor_motion_wakeup_control);
        dest.writeInt(sensor_motion_wakeup_threshold);
        dest.writeInt(sensor_motion_calibration_control);
        dest.writeInt(sensor_motion_value);
    }

    public static final Creator<MotionSensorModel> CREATOR = new ClassLoaderCreator<MotionSensorModel>() {
        @Override
        public MotionSensorModel createFromParcel(Parcel source, ClassLoader loader) {
            return new MotionSensorModel(source);
        }

        @Override
        public MotionSensorModel createFromParcel(Parcel source) {
            return new MotionSensorModel(source);
        }

        @Override
        public MotionSensorModel[] newArray(int size) {
            return new MotionSensorModel[0];
        }
    };
}
