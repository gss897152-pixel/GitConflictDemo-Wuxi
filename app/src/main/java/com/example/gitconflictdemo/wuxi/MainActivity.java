package com.example.gitconflictdemo.wuxi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_one).setOnClickListener(view ->
                Toast.makeText(this, R.string.button_one_clicked, Toast.LENGTH_SHORT).show());
        findViewById(R.id.button_two).setOnClickListener(view ->
                Toast.makeText(this, R.string.button_two_clicked, Toast.LENGTH_SHORT).show());
    }
}
