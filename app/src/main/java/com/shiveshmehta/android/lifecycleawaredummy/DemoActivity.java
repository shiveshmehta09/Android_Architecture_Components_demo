package com.shiveshmehta.android.lifecycleawaredummy;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Log.i(TAG, "Lifecycle Owner OnCreate");

        getLifecycle().addObserver(new DemoActivityObserver());

        final TextView textView = findViewById(R.id.textViewRandomNumber);
        Button buttonFetch = findViewById(R.id.buttonFetch);
//        DemoActivityViewModel myNumber = new DemoActivityViewModel();
        final DemoActivityViewModel mViewModel = ViewModelProviders.of(this).get(DemoActivityViewModel.class);
        LiveData<String> myRandomNumber = mViewModel.getNumber();

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                Log.i(TAG, "my Random Number set");

            }
        });

        buttonFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.createNumber();
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Lifecycle Owner onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Lifecycle Owner onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "Lifecycle Owner onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Lifecycle Owner onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "Lifecycle Owner onStop");

    }


}
