#Student Name: Bolu Peng
#Penn ID: 16847239
#I worked this assignment out all by myself

import random

def main():
    # initialize two variables
    computer_score = 0
    human_score = 0

    # Human plays against computer, if either of them reaches or exceeds 50 scores or both of them reach or exceed 50 scores but with one's score higher than the other's, jump out of the loop
    # If both of computer and human reach or exceed 50 and their scores are equal, continue loop until one's score is higher than the other's after human finishes his/her last turn
    while True:
        
        computer_score += computer_move(computer_score, human_score)
        human_score += human_move(computer_score, human_score)
        
        if (is_game_over(computer_score, human_score)==True):
            break
        
    show_results(computer_score, human_score)

def instructions():
    # Instructions for human player
    print()
    print("#","WELCOME TO THE PIG GAME!","#")
    print()
    print("#","Computer takes the first turn to play","#")
    print()
    print("#","As long as computer rolls a number other than 6, computer may roll 2,3,4,6,8 times per turn according to how far it is behind or ahead human","#")
    print()
    print("#","Each time computer rolls, its score for this turn will be added by the number rolled out and its current score will be displayed on the screen","#")
    print()
    print("#","Human takes the second turn to play","#")
    print()
    print("#","As long as human rolls a number other than 6, human may choose not to roll or roll as many times as human wants to during human's turn","#")
    print()
    print("#","Each time human rolls, human's score for this turn will be added by the number rolled out and human's current score, the conputer's current score as well as how many human's score is behind or ahead than computer's will be displayed on the screen","#")
    print()
    print("#","If computer rolls a 6 during its turn, computer's current turn stops. Computer's accumulated score for this turn will be resetted as 0. If human rolls a 6 during human's turn, human's current turn stops. Human's accumulated score for this turn will be resetted as 0","#")
    print()
    print("#","Computer's overall score is accumulated by the rolls of its own turns. Human's overall score is accumulated by the rolls of human's own turns")
    print()
    print("#","If either computer's of human's overall score reaches or exceeds 50, game over. Either side with a score higher than or equal to 50 wins","#")
    print()
    print("#","If both computer's and human's overall scores reach or exceed 50 and computer's score is different from human's, game over. Either side with a higher score wins","#")
    print()
    print("#","If both computer's and human's overall scores reach or exceed 50 and computer shares an equal score with human's, computer and human need to play additional turns until either of them reaches one of the previous two conditions","#")
    print()
    print("#","NOW ENJOY!","#")
    print()

def human_move(computer_score, human_score):
    # Initialize two variables
    human_score_this_turn = 0
    human_score_initial = human_score
    
    while True:
        # Human could decide whether to continue rolling or not
        a = input("Wanna roll?")
        if a.startswith('y') or a.startswith('Y'):
            b = roll()
            # If b==6, human's score accumulation this turn is resetted as 0 and human's turn ends. Function will return the initial value of human_score 
            if (b==6):
                human_score_this_turn = 0
                
                print("Human's current socre is",human_score_initial)
                print("Computer's current score is",computer_score)
                
                if (human_score_initial<computer_score):
                    print("Human is",computer_score-human_score_initial,"scores behind")
                else:
                    print("Human is",human_score_initial-computer_score,"scores ahead")
                    
                break

            # If b!=6, human's score this turn will be accumulated by b 
            else:
                human_score_this_turn += b
                
                print("Human's current socre is",human_score+human_score_this_turn)
                print("Computer's current score is",computer_score)
                
                if (human_score+human_score_this_turn<computer_score):
                    print("Human is",computer_score-human_score-human_score_this_turn,"scores behind")
                else:
                    print("Human is",human_score+human_score_this_turn-computer_score,"scores ahead")
                    
        elif a.startswith('n') or a.startswith('N'):
            break
        
    return human_score_this_turn
    
def computer_move(computer_score, human_score):
    # Initialize three variables
    computer_score_this_turn = 0
    computer_score_initial = computer_score
    count=0
    
    # If computer's current score (sum of computer's score and conmupter's score this turn) is lower than human's current score, computer will launch its AGGRESSIVE MODE:
    # 1.If the difference between computer's current score and human's current score is larger than 15, as long as the roll result is not 6, computer will roll 8 times per turn to catch up with human
    # 2.If the difference between computer's current score and human's current score is larger than 10 and smaller than or equal to 15, as long as the roll result is not 6, computer will roll 6 times per turn to catch up with human
    # 3.If the difference between computer's current score and human's current score is larger than 5 and smaller than or equal to 10, as long as the roll result is not 6, computer will roll 4 times per turn to catch up with human
    # 4.If the difference between computer's current score and human's current score is smaller than 5, as long as the roll result is not 6, computer will roll 3 times per turn to catch up with human
    if (computer_score+computer_score_this_turn<human_score):
        difference = human_score-computer_score-computer_score_this_turn
        if (difference>15):
            count=8
        elif (difference>10):
            count=6
        elif (difference>5):
            count=4
        else:
            count=3
            
        while (count>0):
            b = roll()
            # If b==6, computer's overall score this turn is resetted as 0 and computer's turn ends. Function will return the initial value of computer_score
            if (b==6):
                computer_score_this_turn = 0
                print("Computer's current score is",computer_score_initial)
                break
            
            computer_score_this_turn += b
            # count self-deducted by 1
            count -= 1
            print("Computer's current score is",computer_score+computer_score_this_turn)
            
    # If computer's current score is higher than or equal to human's current score, computer will remain its REGULAR MODE, in this mode, computer will roll 2 times per turn as long as the roll result is not 6 
    else:
        count=2
        while (count>0):
            b = roll()
            # If b==6, computer's overall score this turn is resetted as 0 and computer's turn ends
            if (b==6):
                computer_score_this_turn = 0
                print("Computer's current score is",computer_score_initial)
                break
            
            computer_score_this_turn += b
            count -= 1
            print("Computer's current score is",computer_score+computer_score_this_turn)
            
    return computer_score_this_turn

def is_game_over(computer_score, human_score):
    # If either computer's score or human's score reaches or exceeds 50 or both of computer's and human's score reach or exceed 50 with one's score higher than the other one's, game over
    if ((computer_score>=50 and human_score<50) or (human_score>=50 and computer_score<50)):
        return True
    elif (computer_score>=50 and human_score>=50 and computer_score>human_score):
        return True
    elif (computer_score>=50 and human_score>=50 and human_score>computer_score):
        return True
    else:
        return False
    
def roll():
    # Generate a number from 1 to 6 randomly
    return random.randint(1,6)

def ask_yes_or_no(prompt):
    # Determine whether human player wants to play again or not, any unacceptable input will result in repeatedly asking    
    while (prompt.startswith("y")==False and prompt.startswith("Y")==False and prompt.startswith("n")==False and prompt.startswith("N")==False):
        prompt = input("Play again?")
        
    if (prompt.startswith("y") or prompt.startswith("Y")):
        return True
    else:
        return False
            
def show_results(computer_score, human_score):
    # Show the result
    if (computer_score>human_score):
        print("HUMAN LOSE")
        print("Human's score is",((computer_score-human_score)/computer_score)*100,"% less than computer's")
    else:
        print("HUMAN WIN")
        print("Human's score is",((human_score-computer_score)/computer_score)*100,"% more than computer's")


#Execution steps
instructions()
main()
while True:
    # Play again?
    prompt = input("Play again?")
    if (ask_yes_or_no(prompt)==True):
        instructions()
        main()
    else:
        break
