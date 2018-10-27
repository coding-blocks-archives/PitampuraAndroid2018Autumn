package com.codingblocks.workmanager;

import android.arch.lifecycle.Observer;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.jobdispatcher.Constraint;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.State;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
//                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .build();

        Button btnStartWork = findViewById(R.id.btnStartWork);

        Data data = new Data.Builder()
                .putInt("KEY", 6)
                .build();

        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .setConstraints(constraints)
                .setInputData(data)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class,
                1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build();

        btnStartWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WorkManager.getInstance().enqueue(request);

//                WorkContinuation wc = WorkManager.getInstance()
//                        .beginWith(a);
//
//                WorkContinuation wc2 = wc.then(b);
//                WorkContinuation wc3 = wc.then(c);
//
//                wc2.then(d).enqueue();
//
//                wc3.then(e).enqueue();

            }
        });

        WorkManager.getInstance().getStatusByIdLiveData(request.getId()).observe(this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {

                if (workStatus.getState() == State.SUCCEEDED) {
                    Toast.makeText(MainActivity.this, "Work done!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
