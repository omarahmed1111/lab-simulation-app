package com.example.omar2.test4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;



public class MainActivity extends AppCompatActivity {

    private GyroscopeObserver gyroscopeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gyroscopeObserver=new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI/4);
        PanoramaImageView PanoramaImageView = (PanoramaImageView)findViewById(R.id.panorama_image_view);
        PanoramaImageView.setGyroscopeObserver(gyroscopeObserver);
        ImageButton arrow = (ImageButton)findViewById(R.id.arrow);
        View list = findViewById(R.id.list);
        list.setVisibility(View.INVISIBLE);

        arrow.setTag("up");



    }
    @Override
    protected void onPostResume(){
        super.onPostResume();
        gyroscopeObserver.register(this);
    }
    @Override
    protected void onPause(){
        super.onPause();
        gyroscopeObserver.unregister();
    }
    public void first(View view){
        Intent next = new Intent(this,physics.class);
        startActivity(next);

    }
    public void second(View view){
        Intent next = new Intent(this,Main2Activity.class);
        startActivity(next);

    }

    public void arrow(View view){
        ImageButton arrow = (ImageButton)findViewById(R.id.arrow);
        View list = findViewById(R.id.list);
       if(arrow.getTag()=="up"){
           arrow.setImageResource(R.drawable.down);
           arrow.setTag("down");
           arrow.setY(720);
           list.setVisibility(View.VISIBLE);

       }
       else if(arrow.getTag()=="down"){
           arrow.setImageResource(R.drawable.up);
           arrow.setTag("up");
           arrow.setY(900);
           list.setVisibility(View.INVISIBLE);

       }


    }

}
