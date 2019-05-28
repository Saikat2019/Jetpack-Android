package com.saikat.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "XXXM";
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        final MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        LiveData<String> mRandomNumber = model.getMyRandomNumber();

        mRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
                Log.d(TAG, "onChanged: ");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createNumber();
            }
        });

        Log.d(TAG, "onCreate: number set");
    }
}
