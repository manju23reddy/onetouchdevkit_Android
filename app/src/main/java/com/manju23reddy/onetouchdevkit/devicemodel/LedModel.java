package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class LedModel implements Parcelable{
    int led_on_off_state;
    int led_mode;

    public LedModel(){

    }

    public LedModel(Parcel in){
        led_on_off_state = in.readInt();
        led_mode = in.readInt();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(led_on_off_state);
        dest.writeInt(led_mode);
    }

    public static Creator<LedModel> CREATOR = new ClassLoaderCreator<LedModel>() {
        @Override
        public LedModel createFromParcel(Parcel source, ClassLoader loader) {
            return new LedModel(source);
        }

        @Override
        public LedModel createFromParcel(Parcel source) {
            return new LedModel(source);
        }

        @Override
        public LedModel[] newArray(int size) {
            return new LedModel[0];
        }
    };
}
