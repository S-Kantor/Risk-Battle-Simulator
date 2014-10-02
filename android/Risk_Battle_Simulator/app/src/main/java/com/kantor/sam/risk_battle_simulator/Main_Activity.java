package com.kantor.sam.risk_battle_simulator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
    }


    public void startSim (View view) {

        Toast startSim = Toast.makeText(getApplicationContext(),"Starting Simulation now!", Toast.LENGTH_LONG);
        //startSim.show();
        EditText inputTeamA;
        EditText inputTeamB;

        inputTeamA = (EditText) findViewById(R.id.enterTeamA);
        inputTeamB = (EditText) findViewById(R.id.enterTeamB);

        //String TeamA_Amount = inputTeamA.getText().toString();
        //String TeamB_Amount = inputTeamB.getText().toString();

        //Toast output = Toast.makeText(getApplicationContext(), (TeamA_Amount + " "  + TeamB_Amount), Toast.LENGTH_LONG);
        //output.show();

        Team teamA = new Team();
        Team teamB = new Team();
        teamA.setInt(inputTeamA);
        teamB.setInt(inputTeamB);

        Toast output = Toast.makeText(getApplicationContext(), teamA.amount + teamA.amount, Toast.LENGTH_LONG);
        output.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
