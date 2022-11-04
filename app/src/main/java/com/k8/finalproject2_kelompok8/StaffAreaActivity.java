package com.k8.finalproject2_kelompok8;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.paperdb.Paper;

public class StaffAreaActivity extends AppCompatActivity {

    private Button StaffLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_area);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(StaffAreaActivity.this, "Welcome to staff area!", Toast.LENGTH_SHORT).show();
            }
        },2000); // will trigger your code after 5 seconds


        StaffLogoutButton = (Button) findViewById(R.id.nav_staff_logout);

        StaffLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().destroy();

                Intent intent = new Intent(StaffAreaActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}