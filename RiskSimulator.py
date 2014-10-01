##
#Name: Sam Kantor
#Assignment: Risk simulator
#
##

import random

TeamARolls = []
TeamBRolls = []

TeamA_Attacking = False
TeamB_Attacking = False

TeamA_LostMen = 0
TeamB_LostMen = 0

keepGoing = True

class Team:

    def __init__ (self):
        self.amount = int(input("How many men are in the team: "))

def isAttacking (): #Returns which team is attacking

    global TeamA_Attacking
    global TeamB_Attacking
    
    while True:
        userInput = input('Please enter \'A\' if TeamA is attacking or \'B\' if B is attacking: ')
        if len(userInput) == 1:
            if (userInput) == 'a':
                TeamA_Attacking = True
                break
            elif (userInput) == 'b':
                TeamA_Attacking = False
                break
            else:
                print("try again, only 1 character")
    if TeamA_Attacking:
        TeamB_Attacking = False
    elif TeamA_Attacking == False:
        TeamB_Attacking = True

def CompareRolls(A_Roll, B_Roll): #Compare Rolls between teams

    global TeamA_LostMen
    global TeamB_LostMen
    
    TeamA_LostMen = 0 #Reset
    TeamB_LostMen = 0

    if TeamA_Attacking:
        for n in range (2,0,-1): #Decreasing for loop
            if B_Roll[n] >= A_Roll[n]:
                TeamA_LostMen += 1
            else:
                TeamB_LostMen += 1
    if TeamB_Attacking:
        for n in range (2,0,-1): 
            if A_Roll[n] >= B_Roll[n]:
                TeamB_LostMen += 1
            else:
                TeamA_LostMen += 1

def AddRolls (TeamARolls, TeamBRolls): #Adding Rolls

    if TeamA_Attacking: #If A is attacking
        if TeamA.amount > TeamB.amount: #and if A has more men, then roll 3 
            for x in range (0,3):
                TeamARolls.append(random.randint(1,6))
            for x in range (0,2):
                TeamBRolls.append(random.randint(1,6))
            TeamBRolls.append(0) #Adds a third empty roll for comparing
        elif TeamA.amount <= TeamB.amount: #If A has less then B, roll 2 die
            for x in range (0,2):
                TeamARolls.append(random.randint(1,6))
            TeamARolls.append(0)
            for x in range (0,2):
                TeamBRolls.append(random.randint(1,6))
            TeamBRolls.append(0) #Adds a third empty roll for comparing
    elif TeamB_Attacking:
        if TeamB.amount > TeamA.amount:
            for x in range (0,3):
                TeamBRolls.append(random.randint(1,6))
            for x in range (0,2):
                TeamARolls.append(random.randint(1,6))
            TeamARolls.append(0) #Adds a third empty roll for comparing
        elif TeamB.amount <= TeamA.amount:
            for x in range (0,2):
                TeamBRolls.append(random.randint(1,6))
            TeamBRolls.append(0)
            for x in range (0,2):
                TeamARolls.append(random.randint(1,6))
            TeamARolls.append(0) #Adds a third empty roll for comparing
    
TeamA = Team()
TeamB = Team()

isAttacking()

#How many rounds you want to simulate
NumberofRounds = input("How many rounds would you like to simulate: ")  #you should add error exceptions here.

#Main for loop


for i in range (int(NumberofRounds)):

    AddRolls(TeamARolls, TeamBRolls)

    #print (TeamARolls, TeamBRolls) #<---- Used to debug
    TeamARolls.sort() #Sorts by biggest to smallest
    TeamBRolls.sort()

    CompareRolls(TeamARolls, TeamBRolls)

    print ("")
    print ("----------------------------")
    print ("Next round")
    print ("")

    print ("A rolled: ", TeamARolls,"B rolled: ",TeamBRolls) #Prints roll's
    
    for x in range (3):
        TeamARolls.pop()
        TeamBRolls.pop()

    print("The amount of men Team A lost this round is: ", TeamA_LostMen)
    print("The amount of men Team B lost this round is: ", TeamB_LostMen)

    TeamA.amount -= TeamA_LostMen
    TeamB.amount -= TeamB_LostMen
    
    print ("Team A has ", TeamA.amount, " men left")
    print ("Team B has ", TeamB.amount, " men left")

    #Checks amount of men on eac team to determine if sim can continue
    if TeamA.amount <= 1 or TeamB.amount <= 1:
        print ("Too little men to proceed")
        break
    
    print ("")
    user_input = input("Would you like to continue the simulation?(Press y to continue): ")
    if not user_input == 'y':
        break

        
