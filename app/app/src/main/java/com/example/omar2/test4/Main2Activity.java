package com.example.omar2.test4;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView table = (ImageView)findViewById(R.id.table);
        table.setTag("empty");
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mix);
        table.startAnimation(animation1);
        table.setScaleX((float)1.0);
        table.setScaleY((float)1.0);
        ImageButton arrow = (ImageButton)findViewById(R.id.arrow);
        View list = findViewById(R.id.list);
        list.setVisibility(View.INVISIBLE);

        arrow.setTag("up");
        TextView target = (TextView)findViewById(R.id.target);
        ImageView water2 = (ImageView)findViewById(R.id.water2);
        water2.setOnLongClickListener(longClickListener);
        target.setOnDragListener(dragListener);
        ImageView sod = (ImageView)findViewById(R.id.sodium);
        sod.setOnLongClickListener(longClickListener);


    }
    public void arrow(View view){
        ImageButton arrow = (ImageButton)findViewById(R.id.arrow);
        View list = findViewById(R.id.list);
        if(arrow.getTag()=="up"){
            arrow.setImageResource(R.drawable.down);
            arrow.setTag("down");
            arrow.setY(1200);
            list.setVisibility(View.VISIBLE);

        }
        else if(arrow.getTag()=="down"){
            arrow.setImageResource(R.drawable.up);
            arrow.setTag("up");
            arrow.setY(1400);
            list.setVisibility(View.INVISIBLE);

        }


    }

    public void react(View view) {
        ImageView table = (ImageView)findViewById(R.id.table);
        if(table.getTag()=="mixna" ||table.getTag()=="mixwater" ) {
            Intent next = new Intent(this, Main3Activity.class);
            startActivity(next);
        }
        else{
            TextView formula = (TextView)findViewById(R.id.formula);
            formula.setText("Put the tools on the table first");
        }

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data,myShadowBuilder,view,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int event = dragEvent.getAction();

            switch (event){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View v = (View)dragEvent.getLocalState();

                    if(v.getId()==(R.id.water2)){
                        ImageView table = (ImageView)findViewById(R.id.table);
                        if(table.getTag()=="empty") {
                            table.setImageResource(R.drawable.table2);
                            table.setTag("water");
                        }
                        else if(table.getTag()=="sodium"){
                            table.setImageResource(R.drawable.tablenawater);
                            table.setTag("mixna");

                        }
                    }
                    if(v.getId()==(R.id.sodium)){
                        ImageView table = (ImageView)findViewById(R.id.table);
                        if(table.getTag()=="empty") {
                            table.setImageResource(R.drawable.tablena);
                            table.setTag("sodium");
                        }
                        else if(table.getTag()=="water"){
                            table.setImageResource(R.drawable.tablenawater);
                            table.setTag("mixwater");

                        }
                    }

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    ImageView table = (ImageView)findViewById(R.id.table);
                    if(table.getTag()=="water") {
                        table.setImageResource(R.drawable.table);
                        table.setTag("empty");
                    }
                    else if(table.getTag()=="sodium"){
                        table.setImageResource(R.drawable.table);
                        table.setTag("empty");

                    }
                    else if(table.getTag()=="mixna"){
                        table.setImageResource(R.drawable.tablena);
                        table.setTag("sodium");

                    }
                    else if(table.getTag()=="mixwater"){
                        table.setImageResource(R.drawable.table2);
                        table.setTag("water");

                    }


                    break;
                case DragEvent.ACTION_DROP:
                    break;

            }
            return true;
        }
    };


    public void equation(View view) {
        ImageView table = (ImageView)findViewById(R.id.table);
        if(table.getTag()=="mixna" ||table.getTag()=="mixwater" ) {
            Intent next = new Intent(this,equation.class);
            startActivity(next);
        }
        else{
            TextView formula = (TextView)findViewById(R.id.formula);
            formula.setText("Put the tools on the table first");
        }

    }

    public void clear(View view) {
        ImageView table = (ImageView)findViewById(R.id.table);
        table.setImageResource(R.drawable.table);
        table.setTag("empty");
    }
}
