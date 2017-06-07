package goals.dream.web_check_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        if (id == R.id.icon_1) {Toast.makeText(this, "icon_1_page killed", Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(MainActivity.this, MainActivity.class));
        finish();
        return true;
        }
        if (id == R.id.icon_2) {Toast.makeText(this, "icon_2", Toast.LENGTH_SHORT).show();
        //(new Intent(Main2Activity.this, Main2Activity.class));
        return true;
        }
        if (id == R.id.icon_3) {Toast.makeText(this, "icon_3", Toast.LENGTH_SHORT).show();
        return true;
        }
        return super.onOptionsItemSelected(item);
    }
//button clicks >> button_click_act_2----------------------------------------------------------
    public void button_click_act_2(View view) {
        int the_id = view.getId();
        if (the_id == R.id.b_url_1) {
            Toast.makeText(this, "b_url_1", Toast.LENGTH_SHORT).show();

        }
        if (the_id == R.id.b_url_2) {
            Toast.makeText(this, "b_url_2", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.b_url_3) {
            Toast.makeText(this, "b_url_3", Toast.LENGTH_SHORT).show();
        }
    }

}
