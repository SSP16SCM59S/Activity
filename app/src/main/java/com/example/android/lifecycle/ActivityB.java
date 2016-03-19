/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.lifecycle.util.StatusTracker;
import com.example.android.lifecycle.util.Utils;

/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class ActivityB extends Activity {
    private int count1;
    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onCreate() called:");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mActivityName = getString(R.string.activity_b_label);
        mStatusView = (TextView)findViewById(R.id.status_view_b);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_b);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        Utils.printStatus(mStatusView, mStatusAllView);

    }

    @Override
    protected void onStart() {

        super.onStart();
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onStart() called:");
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start));
        Utils.printStatus(mStatusView, mStatusAllView);


    }

    @Override
    protected void onRestart() {

        super.onRestart();
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onRestart() called:");
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView, mStatusAllView);

    }

    @Override
    protected void onResume() {

        super.onResume();
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onResume() called:");
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView, mStatusAllView);
        }

    @Override
    protected void onPause() {

        super.onPause();
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onPause() called:");
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView, mStatusAllView);
        }

    @Override
    protected void onStop() {

        super.onStop();
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onStop() called:");
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
        }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        count1++;
        Log.d("sshanka5@hawk.iit.edu", Integer.toString(count1) + " Activity B : onDestroy() called:");
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
        }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityB.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
       }

    public void startActivityC(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }
}
