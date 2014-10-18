package com.kantor.sam.risk_battle_simulator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class Main_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
    }

    public static Boolean TeamA_Attacking = false;
    public static Boolean TeamB_Attacking = false;

    public void onToggleClicked(View view) {

        String whoIsAttacking;

        ToggleButton toggle = (ToggleButton) findViewById (R.id.toggleAttackingTeam);
        boolean on = toggle.isChecked();

        if (on) {
            TeamA_Attacking = true;
            whoIsAttacking = "Team A is Attacking";
        } else {
            TeamB_Attacking = true;
            whoIsAttacking = "Team B is Attacking";
        }
        Toast test = Toast.makeText(getApplicationContext(), whoIsAttacking, Toast.LENGTH_SHORT);
        test.show();
    }

    public void startSim (View view) {

        //Toast startSim = Toast.makeText(getApplicationContext(),"Starting Simulation now!", Toast.LENGTH_LONG);
        //startSim.show();
        EditText inputTeamA;
        EditText inputTeamB;

        ArrayList <Integer> TeamARolls = new ArrayList<Integer> ();
        ArrayList <Integer> TeamBRolls = new ArrayList<Integer> ();

        inputTeamA = (EditText) findViewById(R.id.enterTeamA);
        inputTeamB = (EditText) findViewById(R.id.enterTeamB);

        Team teamA = new Team();
        Team teamB = new Team();

        String TeamA_amount_str;
        String TeamB_amount_str;

        Integer TeamA_amount_int;
        Integer TeamB_amount_int;

        teamA.setInt(inputTeamA);
        teamB.setInt(inputTeamB);

        TeamA_amount_str = teamA.amount;
        TeamB_amount_str = teamB.amount;

        TeamA_amount_int = Integer.parseInt(TeamA_amount_str);
        TeamB_amount_int = Integer.parseInt(TeamB_amount_str);

        Integer TeamA_Lostmen = 0;
        Integer TeamB_Lostmen = 0;


        Game game = new Game();

        onToggleClicked(view);

        game.addRolls(TeamARolls, TeamBRolls, TeamA_amount_int, TeamB_amount_int,TeamA_Attacking,TeamB_Attacking);
        String listString1 = "";
        String listString2 = "";

        for (Integer s : TeamARolls)
        {
            listString1 += s + "\t";
        }
        for (Integer s : TeamBRolls)
        {
            listString2 += s + "\t";
        }
        
        Toast output2 = Toast.makeText(getApplicationContext(), listString1, Toast.LENGTH_SHORT);
        Toast output3 = Toast.makeText(getApplicationContext(),listString2, Toast.LENGTH_SHORT);
        output2.show();
        output3.show();

        game.compareRolls(TeamARolls, TeamBRolls, TeamA_Lostmen, TeamB_Lostmen);
        TeamA_Lostmen = game.TeamAReturn;
        TeamB_Lostmen = game.TeamBReturn;

        Toast output4 = Toast.makeText(getApplicationContext(), "Team A Lost: " + TeamA_Lostmen.toString(), Toast.LENGTH_SHORT);
        Toast output5 = Toast.makeText(getApplicationContext(), "Team B Lost: " + TeamB_Lostmen.toString(), Toast.LENGTH_SHORT);
        output4.show();
        output5.show();
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
