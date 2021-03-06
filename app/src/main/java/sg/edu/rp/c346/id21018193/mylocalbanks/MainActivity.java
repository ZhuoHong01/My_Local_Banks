package sg.edu.rp.c346.id21018193.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;

    String wordClicked = "";
    private String ContextMenuInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.textViewBank1);
        registerForContextMenu(dbs);
        ocbc = findViewById(R.id.textViewBank2);
        registerForContextMenu(ocbc);
        uob = findViewById(R.id.textViewBank3);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact The Bank");

        if(v == dbs){

            if(menu.equals("Website")){
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com"));
                startActivity(intentCall);
            }
            else if(menu.equals("Contact The Bank")){
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("18001111111"));
                startActivity(intentCall);
            }
            wordClicked = "dbs";
        }
        else if(v == ocbc){
            if(menu.equals("Website")){
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intentCall);
            }
            else if(menu.equals("Contact The Bank")){
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("18003633333"));
                startActivity(intentCall);
            }
            wordClicked = "ocbc";
        }
        else if(v == uob){
            if(menu.equals("Website")){
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com"));
                startActivity(intentCall);
            }
            else if(menu.equals("Contact The Bank")){
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("18002222121"));
                startActivity(intentCall);
            }
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText("????????????");
            ocbc.setText("????????????");
            uob.setText("????????????");
            return true;
        } else {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}