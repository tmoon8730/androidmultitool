package com.tea.big.androidmultitool.PresentTeller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tea.big.androidmultitool.MailApp.MailApp;
import com.tea.big.androidmultitool.R;

import java.util.Random;

public class PresentTeller extends AppCompatActivity {
    Button tellerMainButton;
    TextView tellerResult;

    String fortuneList[] = {"Apple iPhone","Star Wars Lightsaber","Android Smart Watch","Google Glass","Samsung VR","Steam Gift Card","Fallout 4","Batman Costume","Hoverboard"};

    int previousIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_teller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tellerMainButton = (Button) findViewById(R.id.presentTellerMainButton);
        tellerResult = (TextView) findViewById(R.id.presentTellerResult);

        tellerMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5:
                int index = new Random().nextInt(fortuneList.length);
                while(index == previousIndex){
                    index = new Random().nextInt(fortuneList.length);
                }
                previousIndex = index;
                tellerResult.setText(fortuneList[index]);
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(view.getContext(),MailApp.class);
                startActivity(intent);
            }
        });
    }

}
