package com.shiveshmehta.android.lifecycleawaredummy;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Log.i(TAG,"Lifecycle Owner OnCreate");

        getLifecycle().addObserver(new DemoActivityObserver());

        TextView textView = findViewById(R.id.textViewRandomNumber);
//        DemoActivityViewModel myNumber = new DemoActivityViewModel();
        DemoActivityViewModel mViewModel = ViewModelProviders.of(this).get(DemoActivityViewModel.class);
        String myRandomNumber = mViewModel.getNumber();
        textView.setText(myRandomNumber);

        Log.i(TAG,"my Random Number set");

    }



    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG,"Lifecycle Owner onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG,"Lifecycle Owner onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG,"Lifecycle Owner onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG,"Lifecycle Owner onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG,"Lifecycle Owner onStop");

    }


}
