package com.manashkumarbehera.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch s1,s2;
    TextView tv1,tv2;
    CameraManager cameramanager;
    String camid,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        s1=findViewById(R.id.s1);
        tv1=findViewById(R.id.tv1);
        s2=findViewById(R.id.s2);
        tv2=findViewById(R.id.tv2);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                torchfront(b);
            }
        });
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                torchback(b);
            }
        });
    }

    private void torchfront(boolean b) {
        try {
            cameramanager= (CameraManager) getSystemService(CAMERA_SERVICE);
            camid=cameramanager.getCameraIdList()[1];
            cameramanager.setTorchMode(camid,b);
            result=b?" ON":"OFF";
            tv1.setText(result);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void torchback(boolean b) {

        try {
            cameramanager= (CameraManager) getSystemService(CAMERA_SERVICE);
            camid=cameramanager.getCameraIdList()[0];
            cameramanager.setTorchMode(camid,b);
            result=b?" ON":"OFF";
            tv2.setText(result);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        //Coded by Manash Kumar Behera  -
        //Editor - Android Studio , Language - Java & xml -
        //Thank you

    }
}