package com.manju23reddy.onetouchdevkit;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.manju23reddy.onetouchdevkit.adapters.DeviceListAdapter;
import com.manju23reddy.onetouchdevkit.appdevice.AddNewDeviceActivity;
import com.manju23reddy.onetouchdevkit.applogin.LoginActivity;
import com.manju23reddy.onetouchdevkit.R;
import com.manju23reddy.onetouchdevkit.appsettings.OnTouchDevDeviceSettings;
import com.manju23reddy.onetouchdevkit.devicemodel.DeviceModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OneTouchDevKitMainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.fab_btn_add_new_device)
    FloatingActionButton mAddDeviceBtn;

    @BindView(R.id.txtv_no_device_message)
    TextView mNoDevicesMessageTxt;

    @BindView(R.id.rcv_devices_list)
    RecyclerView mDeviceListRcv;


    DeviceListAdapter mDeviceAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_touch_dev_kit_main);

        ButterKnife.bind(this);
        mAddDeviceBtn.setOnClickListener(this);

        mDeviceAdapter = new DeviceListAdapter(this, mDeviceSelectionCallBacks);
        LinearLayoutManager grd_lyt_manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mDeviceListRcv.setLayoutManager(grd_lyt_manager);
        mDeviceListRcv.setAdapter(mDeviceAdapter);
        mDeviceListRcv.setHasFixedSize(true);

    }

    @Override
    protected void onStop() {
        super.onStop();
        //FirebaseAuth.getInstance().signOut();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_btn_add_new_device:
                Intent device_add_steps = new Intent(getApplicationContext(), AddNewDeviceActivity.class);
                startActivity(device_add_steps);
                break;
        }
    }

    private DeviceListAdapter.DeviceSelectionCallbacks mDeviceSelectionCallBacks = new DeviceListAdapter.DeviceSelectionCallbacks() {
        @Override
        public void onDeviceSelected(int pos) {

        }

        @Override
        public void onDevicesAvailable(boolean state) {

        }

        @Override
        public void launchDeviceSettings(int pos) {
            DeviceModel currentDevice = mDeviceAdapter.getDeviceAtPos(pos);
            Intent launchDeviceSettings = new Intent(getApplicationContext(),
                    OnTouchDevDeviceSettings.class);
            Bundle data = new Bundle();
            data.putParcelable("Device", currentDevice);
            launchDeviceSettings.putExtra("INDATA", data);
            startActivity(launchDeviceSettings);

        }
    };
}
