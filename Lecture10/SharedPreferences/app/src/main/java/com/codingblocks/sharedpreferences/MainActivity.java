package com.codingblocks.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int count = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvCount);
        Button increment = findViewById(R.id.btnIncrement),
                decrement = findViewById(R.id.btnDecrement);

        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        count = sharedPreferences.getInt("COUNT", 0);

        textView.setText(String.valueOf(count));
        increment.setOnClickListener(this);
        decrement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIncrement:
                count++;
                break;
            case R.id.btnDecrement:
                count--;
                break;
        }
        textView.setText(String.valueOf(count));
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("COUNT", count);

        editor.apply();
        super.onStop();
    }
}
