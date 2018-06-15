package com.manju23reddy.onetouchdevkit.devicemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class WiFiMode implements Parcelable {
    private int wifi_always_connected;
    private int wifi_connected_by_event_motion;
    private int wifi_connected_by_event_rtc;
    private int wifi_connected_by_event_button;
    private int wifi_connected_by_event_usb;
    private int wifi_connection_timeout;

    public WiFiMode(){

    }

    public WiFiMode(Parcel in){
        wifi_always_connected = in.readInt();
        wifi_connected_by_event_motion = in.readInt();
        wifi_connected_by_event_rtc = in.readInt();
        wifi_connected_by_event_button = in.readInt();
        wifi_connected_by_event_usb = in.readInt();
        wifi_connection_timeout = in.readInt();
    }

    public int getWifi_always_connected(){
        return wifi_always_connected;
    }

    public int getWifi_connected_by_event_motion(){
        return wifi_connected_by_event_motion;
    }

    public int getWifi_connected_by_event_rtc(){
        return wifi_connected_by_event_rtc;
    }

    public int getWifi_connected_by_event_button(){
        return wifi_connected_by_event_button;
    }

    public int getWifi_connected_by_event_usb(){
        return wifi_connected_by_event_usb;
    }
    public int getWifi_connection_timeout(){
        return wifi_connection_timeout;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(wifi_always_connected);
        dest.writeInt(wifi_connected_by_event_motion);
        dest.writeInt(wifi_connected_by_event_rtc);
        dest.writeInt(wifi_connected_by_event_button);
        dest.writeInt(wifi_connected_by_event_usb);
        dest.writeInt(wifi_connection_timeout);
    }

    public final static Creator<WiFiMode> CREATOR = new ClassLoaderCreator<WiFiMode>() {
        @Override
        public WiFiMode createFromParcel(Parcel source, ClassLoader loader) {
            return new WiFiMode(source);
        }

        @Override
        public WiFiMode createFromParcel(Parcel source) {
            return new WiFiMode(source);
        }

        @Override
        public WiFiMode[] newArray(int size) {
            return new WiFiMode[0];
        }
    };
}
