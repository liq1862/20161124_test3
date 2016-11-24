package com.example.user.a20161124_test3;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTask task =new MyTask();
        task.execute(5);
    }
    class MyTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            int n = params[0];
            for (int i=0;i<=n;i++)
            {
                Log.d("TASK", String.valueOf(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}

