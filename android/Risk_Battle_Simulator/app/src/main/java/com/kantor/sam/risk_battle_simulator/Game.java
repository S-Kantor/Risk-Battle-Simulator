package com.kantor.sam.risk_battle_simulator;

import android.view.View;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Random;


class Game {

    public Boolean TeamA_Attacking = false;
    public Boolean TeamB_Attacking = false;

    /*public String whoIsAttacking (String temp)
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
    }*/

    public void compareRolls (int[] A_roll, int[] B_roll) {
        Integer TeamA_LostMen = 0;
        Integer TeamB_LostMen = 0;

        for (int i = 2; i > 0; i--) {
            if (TeamA_Attacking) {
                if (B_roll[i] >= A_roll[i]) {
                    TeamA_LostMen += 1;
                } else {
                    TeamA_LostMen += 1;
                }
            } else {
                if (A_roll[i] >= B_roll[i]) {
                    TeamB_LostMen += 1;
                } else {
                    TeamA_LostMen += 1;
                }
            }
        }
    }

    public void addRolls (ArrayList<Integer> TeamARolls, ArrayList<Integer> TeamBRolls,
                          Integer teamA_amount, Integer teamB_amount, boolean TeamA_Attacking, boolean TeamB_Attacking)
    {
        //whoIsAttacking()

        int x;
        Random rand = new Random();
        if (TeamA_Attacking)
        {
            if (teamA_amount > teamB_amount)
            {
                for (x = 1; x <= 3; x=x+1)
                {
                    TeamARolls.add(rand.nextInt(6) + 1);
                }
                for (x = 1; x <= 2; x=x+1)
                {
                    TeamBRolls.add(rand.nextInt(6) + 1);
                }
                TeamBRolls.add(0);
            }
            if (teamA_amount <= teamB_amount)
            {
                for (x = 1; x <= 2; x=x+1)
                {
                    TeamARolls.add(rand.nextInt(6) + 1);
                }
                TeamARolls.add(0);
                for (x = 1; x <= 2; x=x+1)
                {
                    TeamBRolls.add(rand.nextInt(6) + 1);
                }
                TeamBRolls.add(0);
            }
        }
        if (TeamB_Attacking)
        {

            if (teamB_amount > teamA_amount)
            {
                for (x = 1; x <= 3; x=x+1)
                {
                    TeamBRolls.add(rand.nextInt(1) + 6);
                }
                for (x = 1; x <= 2; x=x+1)
                {
                    TeamARolls.add(rand.nextInt(1) + 6);
                }
            }
            if (teamB_amount <= teamA_amount)
            {
                for (x = 1; x <= 2; x++)
                {
                    TeamBRolls.add(rand.nextInt(1) + 6);
                }
                TeamBRolls.add(0);
                for (x = 1; x <= 2; x++)
                {
                    TeamARolls.add(rand.nextInt(1) + 6);
                }
                TeamARolls.add(0);
            }

        }

    }





}
