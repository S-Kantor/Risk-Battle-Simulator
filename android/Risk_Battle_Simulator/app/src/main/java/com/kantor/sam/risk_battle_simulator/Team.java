package com.kantor.sam.risk_battle_simulator;

import android.widget.EditText;


public class Team {
    public java.lang.String amount;

    public void setInt (EditText team)
    {
        amount = team.getText().toString();
    }

}
