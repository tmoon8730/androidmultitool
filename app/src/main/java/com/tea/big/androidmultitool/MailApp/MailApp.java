package com.tea.big.androidmultitool.MailApp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tea.big.androidmultitool.R;

public class MailApp extends AppCompatActivity {

    Button sendButton;
    EditText mailRecipient;
    EditText mailSubject;
    EditText mailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sendButton = (Button) findViewById(R.id.mailAppSendButton);
        mailRecipient = (EditText) findViewById(R.id.mailAppRecipient);
        mailSubject = (EditText) findViewById(R.id.mailAppSubject);
        mailMessage = (EditText) findViewById(R.id.mailAppMessage);



        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                sendEmail(mailRecipient.getText().toString(), mailSubject.getText().toString(), mailMessage.getText().toString());
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Already in the Mail App", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected void sendEmail(String to, String subject, String message){
        Log.i("Send email", "");
        String[] TO = {to};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try{
            startActivity(Intent.createChooser(emailIntent,"Send mail..."));
            finish();
            Log.i("Finished sending email.","");
        }catch(android.content.ActivityNotFoundException ex){
            Toast.makeText(MailApp.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();

        }

    }

}
