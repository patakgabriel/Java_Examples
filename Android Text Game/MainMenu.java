package com.example.gabriel.makedecision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button buttonNewGame = findViewById(R.id.button_NewGame);
        final Button buttonAbout = findViewById(R.id.button_About);

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToPage(1);
            }
        });
        buttonAbout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                goToPage(2);
            }
        });
    }

    private void goToPage(int a) {

        Intent intent1 = new Intent(this, Actions.class);
        Intent intent2 = new Intent(this, About.class);
        if(a == 1) {
            startActivity(intent1);
        } else if(a == 2){
            startActivity(intent2);
        }
    }
}
