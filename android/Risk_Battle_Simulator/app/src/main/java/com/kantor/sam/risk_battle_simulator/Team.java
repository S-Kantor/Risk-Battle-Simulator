package com.kantor.sam.risk_battle_simulator;

import android.widget.EditText;

/**
 * Created by shmuel on 2014-10-02.
 */
public class Team {
    EditText inputTeamA;
    EditText inputTeamB;
    public static java.lang.String amount;

    public void setInt (EditText team)
    {
        amount = team.getText().toString();
    }

}
