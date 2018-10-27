package com.codingblocks.workmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        //While you get the application context here, you can't do any UI related task
        //with it, So defer the UI processing off to Service/Broadcast
//        getApplicationContext()

        //get the input data
        Data inputData = getInputData();
        int input = inputData.getInt("KEY", 0);


        Log.e("TAG", "doWork: Input Data : " + input);
        Log.e("TAG", "doWork: was executed");
        return Result.SUCCESS;
    }
}
