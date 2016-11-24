package com.example.user.a20161124_test3;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        MyTask task =new MyTask();
        task.execute(5);
    }
    class MyTask extends AsyncTask<Integer, Integer, Integer> {
                                //開始,執行,結束
        @Override
        protected Integer doInBackground(Integer... params) {
            int n = params[0];
            for (int i=0;i<=n;i++)
            {
                Log.d("TASK", String.valueOf(i));
                publishProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 100;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            tv.setText(String.valueOf(integer));
        }
    }
}

