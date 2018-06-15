package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceModel implements Parcelable{

    private String device_name;
    private String device_key;

    private LedModel led;
    private MotorModel motor;
    private BuzzerModel buzzer;
    private RGBModel rgb;
    private TempSensorModel tempsensor;
    private MotionSensorModel motionsensor;
    private RTCModel rtc;
    private WiFiMode wifimode;

    public DeviceModel(){
        led = new LedModel();
        motor = new MotorModel();
        buzzer = new BuzzerModel();
        rgb = new RGBModel();
        tempsensor = new TempSensorModel();
        motionsensor = new MotionSensorModel();
        rtc = new RTCModel();
        wifimode = new WiFiMode();
    }

    public DeviceModel(Parcel in){
        device_name = in.readString();
        device_key = in.readString();
        led = in.readParcelable(LedModel.class.getClassLoader());
        motor = in.readParcelable(MotorModel.class.getClassLoader());
        buzzer = in.readParcelable(MotorModel.class.getClassLoader());
        rgb = in.readParcelable(MotorModel.class.getClassLoader());
        tempsensor = in.readParcelable(TempSensorModel.class.getClassLoader());
        motionsensor = in.readParcelable(MotionSensorModel.class.getClassLoader());
        rtc = in.readParcelable(RTCModel.class.getClassLoader());
        wifimode = in.readParcelable(WiFiMode.class.getClassLoader());
    }

    public String getDevice_name(){
        return device_name;
    }

    public String getDevice_key(){
        return device_key;
    }

    public void setDevice_name(String deviceName){
        device_name = deviceName;
    }

    public void setDevice_key(String deviceKey){
        device_key = deviceKey;
    }

    public LedModel getLed(){
        return led;
    }

    public MotorModel getMotor() {
        return motor;
    }

    public BuzzerModel getBuzzer() {
        return buzzer;
    }

    public RGBModel getRgb() {
        return rgb;
    }

    public TempSensorModel getTempsensor() {
        return tempsensor;
    }

    public MotionSensorModel getMotionsensor() {
        return motionsensor;
    }

    public RTCModel getRtc() {
        return rtc;
    }

    public WiFiMode getWifimode() {
        return wifimode;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(device_name);
        dest.writeString(device_key);
        dest.writeParcelable(led, flags);
        dest.writeParcelable(motor, flags);
        dest.writeParcelable(buzzer, flags);
        dest.writeParcelable(rgb, flags);
        dest.writeParcelable(tempsensor, flags);
        dest.writeParcelable(motionsensor, flags);
        dest.writeParcelable(rtc, flags);
        dest.writeParcelable(wifimode, flags);

    }

    public final static Creator<DeviceModel> CREATOR = new ClassLoaderCreator<DeviceModel>() {
        @Override
        public DeviceModel createFromParcel(Parcel source, ClassLoader loader) {
            return new DeviceModel(source);
        }

        @Override
        public DeviceModel createFromParcel(Parcel source) {
            return new DeviceModel(source);
        }

        @Override
        public DeviceModel[] newArray(int size) {
            return new DeviceModel[0];
        }
    };
}
