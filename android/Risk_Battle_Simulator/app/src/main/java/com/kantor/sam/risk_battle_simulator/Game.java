package com.kantor.sam.risk_battle_simulator;

import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;


public class Game {

    Boolean TeamA_Attacking = false;
    Boolean TeamB_Attacking = false;

    /*public void isAttacking ()
    {

    }*/
    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            TeamA_Attacking = true;
        } else {
            TeamB_Attacking = true;
        }
    }

    public String whoIsAttacking (String temp)
    {
        temp = "";

        if(TeamA_Attacking)
        {
            temp = "Team A is attacking";
        }
        if (TeamB_Attacking)
        {
            temp = "Team B is attacking";
        }

        return temp;

    }
}
