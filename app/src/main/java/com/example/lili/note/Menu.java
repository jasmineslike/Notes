package com.example.lili.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.amazonaws.mobile.auth.core.IdentityHandler;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.client.AWSMobileClient;

public class Menu extends Activity {

    private Button Note;
    private Button Purchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Create Note Button on click listener
        Note = (Button) findViewById(R.id.btnNote);
        Note.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Create log out Button on click listener
        Purchase = (Button) findViewById(R.id.btnPost);
        Purchase.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.menu_main_singOut:
                signout();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void signout() {
        IdentityManager.getDefaultIdentityManager().signOut();
    }
}
