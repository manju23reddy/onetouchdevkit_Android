package com.manju23reddy.onetouchdevkit.appsettings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.manju23reddy.onetouchdevkit.R;

public class OnTouchDevDeviceSettings extends AppCompatActivity implements View.OnClickListener{

    Switch mLedSettingsOnOffSwitch;
    Switch mMotorSettingsOnOffSwitch;
    Switch mBuzzerSettingsOnOffSwitch;
    Switch mRGBSettingsOnOffSwitch;
    Switch mTempSensorSettingsOnOffSwitch;
    Switch mMotionSensorSettingsOnOffSwitch;

    LinearLayout mLedSettingsLyt;
    LinearLayout mMotoSettingsLyt;
    LinearLayout mBuzzerSettingsLyt;
    LinearLayout mRGBSettingsLyt;
    LinearLayout mTempSensorSettingsLyt;
    LinearLayout mMotionSensorSettingsLyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch_dev_device_settings);

        mLedSettingsOnOffSwitch = findViewById(R.id.switch_led_on_off);
        mMotorSettingsOnOffSwitch = findViewById(R.id.switch_motor_on_off);
        mBuzzerSettingsOnOffSwitch = findViewById(R.id.switch_buzzer_on_off);
        mRGBSettingsOnOffSwitch = findViewById(R.id.switch_rgb_on_off);
        mTempSensorSettingsOnOffSwitch = findViewById(R.id.switch_temp_sensor_on_off);
        mMotionSensorSettingsOnOffSwitch = findViewById(R.id.switch_motion_sensor_on_off);

        mLedSettingsOnOffSwitch.setOnClickListener(this);
        mMotorSettingsOnOffSwitch.setOnClickListener(this);
        mBuzzerSettingsOnOffSwitch.setOnClickListener(this);
        mRGBSettingsOnOffSwitch.setOnClickListener(this);
        mTempSensorSettingsOnOffSwitch.setOnClickListener(this);
        mMotionSensorSettingsOnOffSwitch.setOnClickListener(this);

        mLedSettingsLyt = findViewById(R.id.lyt_led_settings);
        mMotoSettingsLyt = findViewById(R.id.lyt_motor_settings);
        mBuzzerSettingsLyt = findViewById(R.id.lyt_buzzer_settings);
        mRGBSettingsLyt = findViewById(R.id.lyt_rgb_settings);
        mTempSensorSettingsLyt = findViewById(R.id.lyt_temp_sensor_settings);
        mMotionSensorSettingsLyt = findViewById(R.id.lyt_motion_sensor_settings);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.switch_led_on_off:
                mLedSettingsLyt.setVisibility(mLedSettingsOnOffSwitch.isChecked() ? View.VISIBLE : View.GONE);
                break;
            case R.id.switch_motor_on_off:
                mMotoSettingsLyt.setVisibility(mMotorSettingsOnOffSwitch.isChecked() ? View.VISIBLE : View.GONE);
                break;
            case R.id.switch_buzzer_on_off:
                mBuzzerSettingsLyt.setVisibility(mBuzzerSettingsOnOffSwitch.isChecked() ? View.VISIBLE : View.GONE);
                break;
            case R.id.switch_rgb_on_off:
                mRGBSettingsLyt.setVisibility(mRGBSettingsOnOffSwitch.isChecked() ? View.VISIBLE : View.GONE);
                break;
            case R.id.switch_temp_sensor_on_off:
                mTempSensorSettingsLyt.setVisibility(mTempSensorSettingsOnOffSwitch.isChecked() ? View.VISIBLE : View.GONE);
                break;
            case R.id.switch_motion_sensor_on_off:
                mMotionSensorSettingsLyt.setVisibility(mMotionSensorSettingsOnOffSwitch.isChecked() ? View.VISIBLE : View.GONE);
                break;
            default:
                break;

        }
    }
}
