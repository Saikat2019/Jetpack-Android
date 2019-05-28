package com.saikat.viewmodeldemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private String TAG = "XXXg";
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getMyRandomNumber() {
        Log.d(TAG, "getMyRandomNumber: ");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
        Log.d(TAG, "createNumber: ");
        Random random = new Random();
        myRandomNumber.setValue("Number : " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
    }
}
