package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class RGBModel implements Parcelable{
    private int rgb_group_mode_control;
    private int rgb_group_control;
    private int rgb_group_color;
    private int rgb_group_mode;
    private int rgb_led_control;
    private int rgb_led_mode;

    public RGBModel(){

    }
    public RGBModel(Parcel in){
        rgb_group_mode_control = in.readInt();
        rgb_group_control = in.readInt();
        rgb_group_color = in.readInt();
        rgb_group_mode = in.readInt();
        rgb_led_control = in.readInt();
        rgb_led_mode = in.readInt();
    }

    public int getRgb_group_mode_control(){
        return rgb_group_mode_control;
    }

    public int getRgb_group_control(){
        return rgb_group_control;
    }

    public int getRgb_group_color(){
        return rgb_group_color;
    }

    public int getRgb_group_mode(){
        return rgb_group_mode;
    }

    public int getRgb_led_control(){
        return rgb_led_control;
    }

    public int getRgb_led_mode(){
        return rgb_led_mode;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rgb_group_mode_control);
        dest.writeInt(rgb_group_control);
        dest.writeInt(rgb_group_color);
        dest.writeInt(rgb_group_mode);
        dest.writeInt(rgb_led_control);
        dest.writeInt(rgb_led_mode);
    }

    public final static Creator<RGBModel> CREATOR = new ClassLoaderCreator<RGBModel>() {
        @Override
        public RGBModel createFromParcel(Parcel source, ClassLoader loader) {
            return new RGBModel(source);
        }

        @Override
        public RGBModel createFromParcel(Parcel source) {
            return new RGBModel(source);
        }

        @Override
        public RGBModel[] newArray(int size) {
            return new RGBModel[0];
        }
    };
}
