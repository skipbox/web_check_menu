package goals.dream.web_check_menu;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
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

import java.util.Date;
import java.util.GregorianCalendar;

import static android.R.attr.color;
import static android.R.attr.name;
import static android.R.attr.toAlpha;
import static android.support.design.widget.Snackbar.make;

//<uses-permission android:name="android.permission.INTERNET" />
//<uses-permission android:name="android.permission.WAKE_LOCK"/>
public class MainActivity extends AppCompatActivity {

    public WebView wv1;
    EditText my_edit_text;
    String url_1 = "http://dreamgoals.info/cl_post_doug/time_check.php?email_x=email_111222&pass_x=pass_111222";
    String url_2 = "http://dreamgoals.info/cl_post_doug/time_check.php?email_x=email_replace&pass_x=pass_replace";
    String time_now_from_button = "time_now_from_button goes here";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wv1=(WebView)findViewById(R.id.my_webview);
        wv1.setWebViewClient(new MyBrowser());
        ///!@#$%
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.getSettings().setJavaScriptEnabled(true);

        Button b_main_url_1_x = (Button)findViewById(R.id.b_main_url_1);
        b_main_url_1_x.setText(url_1);

        set_android_time();

        //Toast.makeText(this, "timer_go-disable button", Toast.LENGTH_SHORT).show();
        //timer_go();


                //playButton.setVisibility(View.GONE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (Snackbar.LENGTH_INDEFINITE == 1){}
//                Snackbar.make(view, "You can put text here", Snackbar.LENGTH_LONG)
//                        //.setAction("Action", null).show();
//                        // Snackbar.make(view, "You can put text here", Snackbar.LENGTH_SHORT)
//                        .setAction("Action", null).dismiss();
                   close_snackbar();
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


            String id_to_read = "span_android_time";
            wv1.evaluateJavascript("(function(){return document.getElementById('"+id_to_read+"').innerHTML})();",
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
            //set the button text to show what the id is your reading
            Button my_b_main_url_1 = (Button) findViewById(R.id.but_send);
            my_b_main_url_1.setText(id_to_read);

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
            //my_snackbar.setActionTextColor(0xff2195f3);
            //.setDuration(4000).show();
            my_snackbar.setDuration(1);
            my_snackbar.show();


            Toast.makeText(this, "b_wake_off_xxx", Toast.LENGTH_SHORT).show();
            TextView my_tv_wake_sate = (TextView) findViewById(R.id.tv_wake_state);
            my_tv_wake_sate.setText("wakelock off xxx");
        }
        if (the_id == R.id.b_main_url_1) {
            Button my_b_main_url_1 = (Button) findViewById(R.id.b_main_url_1);
            my_b_main_url_1.setText(url_1);
            //String url_1_text = String.valueOf(my_b_main_url_1.getText());
            //Toast.makeText(this, "b_main_url_1" + url_1_text, Toast.LENGTH_SHORT).show();


            //Toast.makeText(this, "time_now_from_button ---" + time_now_from_button, Toast.LENGTH_SHORT).show();
            wv1.loadUrl(url_1+"&android_x="+time_now_from_button);

        }

        if (the_id == R.id.b_main_url_2) {
            Button my_b_main_url_2 = (Button) findViewById(R.id.b_main_url_2);
            my_b_main_url_2.setText(url_2);
            //Toast.makeText(this, "b_main_url_2" + url_2_text, Toast.LENGTH_SHORT).show();
            wv1.loadUrl(url_2);
        }

        if (the_id == R.id.but_android_time) {
            // Define a time value of 5 seconds
            Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;

            // Define our intention of executing AlertReceiver
            Intent alertIntent = new Intent(this, AlertReceiver.class);

            // Allows you to schedule for your application to do something at a later date
            // even if it is in he background or isn't active
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            // set() schedules an alarm to trigger
            // Trigger for alertIntent to fire in 5 seconds
            // FLAG_UPDATE_CURRENT : Update the Intent if active
            alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                    PendingIntent.getBroadcast(this, 1, alertIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT));
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


                    set_android_time();
                    Button but_android_time_x = (Button)findViewById(R.id.but_android_time);
                    time_now_from_button = String.valueOf(but_android_time_x.getText());


                    if (count_x <= -1){
                        count_x = 30;
                        Toast.makeText(MainActivity.this, "count_x = "+count_x, Toast.LENGTH_SHORT).show();
                        wv1.loadUrl(url_1+"&android_x="+time_now_from_button);
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
    public void close_snackbar(){
            Snackbar my_snackbar = Snackbar.make(this.findViewById(android.R.id.content), "byer bye", Snackbar.LENGTH_INDEFINITE);
            //my_snackbar.setActionTextColor(0xff2195f3);
            //.setDuration(4000).show();
            my_snackbar.setDuration(1);
            my_snackbar.show();
    }

    public void set_android_time(){
        Date my_date = new Date();
        CharSequence sss = DateFormat.format("yyyy-MM-dd hh:mm:ss", my_date.getTime());
        time_now_from_button = (String.valueOf(sss));
        Button but_android_time_x = (Button)findViewById(R.id.but_android_time);
        but_android_time_x.setText(String.valueOf(sss));
    }

}
