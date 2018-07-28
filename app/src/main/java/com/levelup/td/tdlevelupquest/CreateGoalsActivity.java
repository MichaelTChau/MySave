package com.levelup.td.tdlevelupquest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;

public class CreateGoalsActivity extends AppCompatActivity {

    private int count = 0;
    ImageView iv;
    CardView c1;
    CardView c2;
    CardView c3;
    CardView c4;
    Button done;
    EditText t1;
    EditText t2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_create_goals);

        LaunchActivity.initDrawer(CreateGoalsActivity.this,this);

        iv = findViewById(R.id.addButton);
        c1 = findViewById(R.id.card1);
        c2 = findViewById(R.id.card2);
        c3 = findViewById(R.id.card3);
        c4 = findViewById(R.id.card4);
        //For transferring to cardview page
        done = findViewById(R.id.doneButton);
        t1=findViewById(R.id.hint_field_11);
        t2=findViewById(R.id.hint_field_21);


        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (count==0){
                    count=1;
                    c2.setVisibility(View.VISIBLE);
                }
                else if (count==1){
                    count=2;
                    c3.setVisibility(View.VISIBLE);
                }
                else if (count==2){
                    count=3;
                    c4.setVisibility(View.VISIBLE);
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AnalyzeSpendingActivity.class);
                String value1 = t1.getText().toString();
                int value2 = Integer.parseInt(t2.getText().toString());
                intent.putExtra("tview1", value1);
                intent.putExtra("tview2", value2);
                startActivity(intent);
            }
        });



    }
}
