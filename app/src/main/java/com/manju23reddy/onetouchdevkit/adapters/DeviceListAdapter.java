package com.manju23reddy.onetouchdevkit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.manju23reddy.onetouchdevkit.R;
import com.manju23reddy.onetouchdevkit.devicemodel.DeviceModel;

import java.util.ArrayList;

/**
 * Created by mreddy3 on 3/30/2018.
 */

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceViewHolder> {

    public interface DeviceSelectionCallbacks{
        void onDeviceSelected(int pos);
        void onDevicesAvailable(boolean state);
        void launchDeviceSettings(int pos);
    }

    ArrayList<DeviceModel> mDeviceList = null;
    DeviceSelectionCallbacks mDeviceSelectionCallBacks = null;

    Context mContext;

    DatabaseReference mDevicesRef = null;

    boolean misDeviceAvailableNotified;

    public class DeviceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mDeviceNameTxtView;
        ImageView mSettingsBtn;

        public DeviceViewHolder(View view){
            super(view);

            mDeviceNameTxtView = view.findViewById(R.id.txtv_device_name);
            mSettingsBtn = view.findViewById(R.id.btn_settings);

            mSettingsBtn.setOnClickListener(this);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.btn_settings:
                    mDeviceSelectionCallBacks.launchDeviceSettings(getAdapterPosition());
                    break;

                    default:
                        mDeviceSelectionCallBacks.onDeviceSelected(getAdapterPosition());
                        break;
            }


        }

    }



    public DeviceListAdapter(Context context, DeviceSelectionCallbacks callbacks){
        mContext = context;
        mDeviceSelectionCallBacks = callbacks;

        mDeviceList = new ArrayList<>();

        mDevicesRef = FirebaseDatabase.getInstance().getReference();


        mDevicesRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("devices").
                addChildEventListener(childEventListener);

        misDeviceAvailableNotified = false;
    }

    @Override
    public int getItemCount() {
        return mDeviceList.size();
    }

    public DeviceModel getDeviceAtPos(int pos){
        return mDeviceList.get(pos);
    }

    public void insertDevice(DeviceModel device){
        mDeviceList.add(device);
        notifyDataSetChanged();
    }



    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        DeviceModel device = mDeviceList.get(position);
        holder.mDeviceNameTxtView.setText(device.getDevice_name());

    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int lyt_id = R.layout.device_list_item_view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(lyt_id, parent, false);
        return new DeviceViewHolder(view);
    }
    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            DeviceModel device = dataSnapshot.getValue(DeviceModel.class);
            device.setDevice_key(dataSnapshot.getKey());
            insertDevice(device);
            if (!misDeviceAvailableNotified){
                misDeviceAvailableNotified = true;
                mDeviceSelectionCallBacks.onDevicesAvailable(mDeviceList.size() > 0);
            }
            Log.d("Device", dataSnapshot.toString());


        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            DeviceModel device = dataSnapshot.getValue(DeviceModel.class);
            for(DeviceModel curDevice : mDeviceList){
                if (curDevice.getDevice_name().equalsIgnoreCase(curDevice.getDevice_name())){
                    mDeviceList.remove(curDevice);
                    notifyDataSetChanged();
                    break;
                }
            }

            if (mDeviceList.size() <= 0){
                mDeviceSelectionCallBacks.onDevicesAvailable(mDeviceList.size() > 0);
                misDeviceAvailableNotified = false;
            }
        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
