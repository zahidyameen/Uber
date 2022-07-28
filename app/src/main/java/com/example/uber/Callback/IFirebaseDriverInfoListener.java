package com.example.uber.Callback;

import com.example.uber.Model.DriverGeoModel;

public interface IFirebaseDriverInfoListener {
    void onDriverInfoLoadSuccess(DriverGeoModel driverGeoModel);
}
