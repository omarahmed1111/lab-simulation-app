package com.example.omar2.test4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class equation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);
    }

    public void react(View view) {
        Intent next = new Intent(this,Main3Activity.class);
        startActivity(next);
    }
}
