package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class BuzzerModel implements Parcelable {
    private int buzzer_control;
    private int buzzer_mode;

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(buzzer_control);
        dest.writeInt(buzzer_mode);
    }

    public BuzzerModel(){

    }

    public BuzzerModel(Parcel in){
        buzzer_control = in.readInt();
        buzzer_mode = in.readInt();
    }

    public int getBuzzer_control(){
        return buzzer_control;
    }

    public int getBuzzer_mode(){
        return buzzer_mode;
    }

    public static Creator<BuzzerModel> CREATOR = new ClassLoaderCreator<BuzzerModel>() {
        @Override
        public BuzzerModel createFromParcel(Parcel source, ClassLoader loader) {
            return new BuzzerModel(source);
        }

        @Override
        public BuzzerModel createFromParcel(Parcel source) {
            return new BuzzerModel(source);
        }

        @Override
        public BuzzerModel[] newArray(int size) {
            return new BuzzerModel[0];
        }
    };
}
