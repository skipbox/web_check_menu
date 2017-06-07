package goals.dream.web_check_menu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.support.design.widget.Snackbar.make;

//<uses-permission android:name="android.permission.INTERNET" />
//<uses-permission android:name="android.permission.WAKE_LOCK"/>
public class MainActivity extends AppCompatActivity {

    private WebView wv1;
    EditText my_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wv1=(WebView)findViewById(R.id.my_webview);
        wv1.setWebViewClient(new MyBrowser());
        ///!@#$%
        wv1.setWebChromeClient(new WebChromeClient());
wv1.getSettings().setJavaScriptEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (Snackbar.LENGTH_INDEFINITE == 1){}
//                Snackbar.make(view, "You can put text here", Snackbar.LENGTH_LONG)
//                        //.setAction("Action", null).show();
//                        // Snackbar.make(view, "You can put text here", Snackbar.LENGTH_SHORT)
//                        .setAction("Action", null).dismiss();

            }

        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.icon_1) {Toast.makeText(this, "icon_1", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        return true;
        }
        if (id == R.id.icon_2) {Toast.makeText(this, "icon_2", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
        return true;
        }
        if (id == R.id.icon_3) {Toast.makeText(this, "icon_3", Toast.LENGTH_SHORT).show();
        return true;
        }
        return super.onOptionsItemSelected(item);
    }
        //button clicks------------------------------------------------------------------
    public void buttonOnClick(View view) {
        int the_id = view.getId();

            if (the_id == R.id.b_wake_check) {
                Toast.makeText(this, "isHeld using boolean isHeld", Toast.LENGTH_SHORT).show();
//https://developer.android.com/training/scheduling/wakelock.html
              // ??????
             // <receiver android:name=".MyWakefulReceiver"></receiver>

            }


        if (the_id == R.id.but_full_count) {
            Toast.makeText(this, "timer_go-disable button", Toast.LENGTH_SHORT).show();
            timer_go();
        }
        if (the_id == R.id.but_sub_count) {
            pause_play_subcount = !pause_play_subcount;

            Toast.makeText(this, "pause_play", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.but_send) {
            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
            //wv1.evaluateJavascript("(function(){return document.getElementById('secretcode').value})();",
            wv1.evaluateJavascript("(function(){return document.getElementById('span_now_epoch').innerHTML})();",
            new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String passed_x) {
            //my_text_log.setText(passed_x);
            //str.replace("\"", "");
            passed_x = passed_x.replace("\"", ""); // removes the quots
            //String new_string = string_xxx.replace("to", "xyz");
            TextView my_tv_data = (TextView) findViewById(R.id.tv_data);
            my_tv_data.setText(passed_x);
            }
            });
            }
        if (the_id == R.id.b_wake_on) {
            //Toast.makeText(this, "b_wake_on", Toast.LENGTH_SHORT).show();


            //Snackbar.make(view, "b_wake_on", Snackbar.LENGTH_INDEFINITE).show();

            Snackbar my_snackbar = Snackbar.make(this.findViewById(android.R.id.content), "snackbar", Snackbar.LENGTH_INDEFINITE);
            my_snackbar.show();



            TextView my_tv_wake_sate = (TextView) findViewById(R.id.tv_wake_state);
            my_tv_wake_sate.setText("wakelock on xxx");
            //String my_url = my_edit_text.getText().toString();
        }
        if (the_id == R.id.b_wake_off) {

            Snackbar my_snackbar = Snackbar.make(this.findViewById(android.R.id.content), "byer bye", Snackbar.LENGTH_INDEFINITE);

            my_snackbar.setDuration(1);
            my_snackbar.show();


            Toast.makeText(this, "b_wake_off_xxx", Toast.LENGTH_SHORT).show();
            TextView my_tv_wake_sate = (TextView) findViewById(R.id.tv_wake_state);
            my_tv_wake_sate.setText("wakelock off xxx");
        }
        if (the_id == R.id.b_main_url_1) {
            Button my_b_main_url_1 = (Button) findViewById(R.id.b_main_url_1);
            String url_1_text = String.valueOf(my_b_main_url_1.getText());
            //Toast.makeText(this, "b_main_url_1" + url_1_text, Toast.LENGTH_SHORT).show();
            wv1.loadUrl(url_1_text);
        }

        if (the_id == R.id.b_main_url_2) {
            Button my_b_main_url_2 = (Button) findViewById(R.id.b_main_url_2);
            String url_2_text = String.valueOf(my_b_main_url_2.getText());
            //Toast.makeText(this, "b_main_url_2" + url_2_text, Toast.LENGTH_SHORT).show();
            wv1.loadUrl(url_2_text);
        }
    }
        //end button clicks------------------------------------------------------------------
int alarm_time_total = 0;
   //time clicks------------------------------------------------------------------
    public void button_click_time(View view) {
        int the_id = view.getId();
        Button b_alarm_total_x = (Button)findViewById(R.id.b_alarm_total);
        Button b_alarm_clock_view_x = (Button)findViewById(R.id.b_alarm_clock_view);

        if (the_id == R.id.but_clear) {
        alarm_time_total = 0;
        //b_alarm_total_x.setText("" + alarm_time_total);
        b_alarm_total_x.setText(String.valueOf(DateUtils.formatElapsedTime(alarm_time_total)));
        }
        if (the_id == R.id.b_add_1) {alarm_time_total = alarm_time_total +1;
        b_alarm_total_x.setText(String.valueOf(DateUtils.formatElapsedTime(alarm_time_total)));
        }
        if (the_id == R.id.b_add_10) {alarm_time_total = alarm_time_total +10;
        b_alarm_total_x.setText(String.valueOf(DateUtils.formatElapsedTime(alarm_time_total)));
        }
        if (the_id == R.id.b_add_60) {alarm_time_total = alarm_time_total +60;
        b_alarm_total_x.setText(String.valueOf(DateUtils.formatElapsedTime(alarm_time_total)));
        }
        if (the_id == R.id.b_add_3600) {alarm_time_total = alarm_time_total +3600;
        b_alarm_total_x.setText(String.valueOf(DateUtils.formatElapsedTime(alarm_time_total)));
        }
        if (the_id == R.id.b_add_43200) {alarm_time_total = alarm_time_total +43200;
        b_alarm_total_x.setText(String.valueOf(DateUtils.formatElapsedTime(alarm_time_total)));
        }
    }
    //end time_click--

    //==========================
    private class MyBrowser extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

//timer
Boolean is_timer_running = Boolean.FALSE;
Boolean pause_play_subcount = Boolean.TRUE;
//Button but_sub_count_obj = (Button)findViewById(R.id.but_sub_count);

    public void timer_go(){
        //alert if timer is already running
        is_timer_running = true;
        Button my_but=(Button)findViewById(R.id.but_full_count);
        my_but.setEnabled(false);
        Toast.makeText(MainActivity.this, "button disable to prevent multiple timers = ", Toast.LENGTH_SHORT).show();
        //if(is_timer_running == true){}
        //Toast.makeText(MainActivity.this, "timer running = "+is_timer_running, Toast.LENGTH_SHORT).show();
        new CountDownTimer(999999999, 1000){
            int count_x = 30;
            public void onTick(long millisUntilFinished) {
                Button my_but=(Button)findViewById(R.id.but_full_count);
                my_but.setText(""+millisUntilFinished / 1000);
                if (pause_play_subcount == true){ //only if pause subcount is == to play
                    Button but_sub_count_obj = (Button)findViewById(R.id.but_sub_count);
                    but_sub_count_obj.setTextColor(Color.BLUE);
                    count_x = count_x -1;

                    alarm_count_go();


                    if (count_x <= -1){
                        count_x = 30;
                        Toast.makeText(MainActivity.this, "count_x = "+count_x, Toast.LENGTH_SHORT).show();
                        //speak_this("hello");

                    }
                }
                if (pause_play_subcount == false){
                    Button but_sub_count_obj = (Button)findViewById(R.id.but_sub_count);
                    but_sub_count_obj.setTextColor(Color.rgb(0,128,0));}
//
                Button but_sub_count_obj = (Button)findViewById(R.id.but_sub_count);
                but_sub_count_obj.setText(String.valueOf(count_x));
            }
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }}.start();}

int time_keep = 0;
    public void alarm_count_go(){

       if(time_keep <= 0){time_keep = alarm_time_total;}

      time_keep = time_keep - 1;
      Button b_alarm_clock_view_x = (Button)findViewById(R.id.b_alarm_clock_view);
      b_alarm_clock_view_x.setText(String.valueOf(DateUtils.formatElapsedTime(time_keep)));

    }

}
