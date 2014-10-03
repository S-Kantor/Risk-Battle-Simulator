package com.kantor.sam.risk_battle_simulator;

import android.widget.EditText;


public class Team {
    EditText inputTeamA;
    EditText inputTeamB;
    public static java.lang.String amount;

    public void setInt (EditText team)
    {
        amount = team.getText().toString();
    }

}
