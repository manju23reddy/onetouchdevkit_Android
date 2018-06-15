package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class MotorModel implements Parcelable {
    int motor_on_off_status;
    private int motor_mode;


    public MotorModel(){

    }
    public MotorModel(Parcel in ){
        motor_on_off_status = in.readInt();
        motor_mode = in.readInt();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(motor_on_off_status);
        dest.writeInt(motor_mode);
    }

    public int getMotor_on_off_status(){
        return motor_on_off_status;
    }

    public int getMotor_mode(){
        return motor_mode;
    }

    public static Creator<MotorModel> CREATOR = new ClassLoaderCreator<MotorModel>() {
        @Override
        public MotorModel createFromParcel(Parcel source, ClassLoader loader) {
            return new MotorModel(source);
        }

        @Override
        public MotorModel createFromParcel(Parcel source) {
            return new MotorModel(source);
        }

        @Override
        public MotorModel[] newArray(int size) {
            return new MotorModel[0];
        }
    };
}
