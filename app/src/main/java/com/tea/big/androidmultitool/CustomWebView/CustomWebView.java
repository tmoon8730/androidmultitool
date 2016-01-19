package com.tea.big.androidmultitool.CustomWebView;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.tea.big.androidmultitool.R;

public class CustomWebView extends AppCompatActivity {

    Button b1;
    EditText ed1;

    private WebView wv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        b1 = (Button)findViewById(R.id.webViewBtn);
        ed1 = (EditText)findViewById(R.id.editText);

        wv1=(WebView)findViewById(R.id.mainWebView);
        wv1.setWebViewClient(new MyBrowser());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String url = ed1.getText().toString();
                if(url.substring(0,6) != "http://")
                {
                    url = "http://" + url;
                }
                ed1.setText(url);

                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(url);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Loading Email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                wv1.loadUrl("http://inbox.google.com");
                ed1.setText("http://inbox.google.com");
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            try {
                view.loadUrl(url);
                System.out.println("Loading URL: " + url);
            }catch(Exception e){
                System.out.println("Error loading URL: " + url + "\n" + e.getClass());
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Infate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode){
                case KeyEvent.KEYCODE_BACK:
                    if(wv1.canGoBack()){
                        wv1.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode,event);
    }
}


