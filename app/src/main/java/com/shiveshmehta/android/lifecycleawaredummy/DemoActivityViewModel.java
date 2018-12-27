package com.shiveshmehta.android.lifecycleawaredummy;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class DemoActivityViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "My Random Number");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;

    }

    public void createNumber() {
        Log.i(TAG, "Create Random Number");

        Random random = new Random();
//        myRandomNumber = "Number : " + (random.nextInt(10 - 1) + 1);
        myRandomNumber.setValue("Number : " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "Cleared View Model");

    }
}
