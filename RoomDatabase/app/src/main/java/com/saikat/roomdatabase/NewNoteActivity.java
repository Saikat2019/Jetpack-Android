package com.saikat.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    public static final String NOTE_ADDED = "new_note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        editText = findViewById(R.id.addText);
        button = findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if(TextUtils.isEmpty(editText.getText())){
                    setResult(RESULT_CANCELED,resultIntent);
                }else {
                    String note = editText.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED,note);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });
    }
}
