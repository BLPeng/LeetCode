#Student name: Bolu Peng
#Penn ID: 16847239
#I accomplish this assignment all by myself

# The Three Musketeers Game

# In all methods,
#   A 'location' is a two-tuple of integers, each in the range 0 to 4.
#        The first integer is the row number, the second is the column number.
#   A 'direction' is one of the strings "up", "down", "left", or "right".
#   A 'board' is a list of 5 lists, each containing 5 strings: "M", "R", or "-".
#        "M" = Musketeer, "R" = Cardinal Richleau's man, "-" = empty.
#        Each list of 5 strings is a "row"
#   A 'player' is one of the strings "M" or "R" (or sometimes "-").
#
# For brevity, Cardinal Richleau's men are referred to as "enemy".
# 'pass' is a no-nothing Python statement. Replace it with actual code.

import random
import math

def create_board():
    global board
    """Creates the initial Three Musketeers board and makes it globally
       available (That is, it doesn't have to be passed around as a
       parameter.) 'M' represents a Musketeer, 'R' represents one of
       Cardinal Richleau's men, and '-' denotes an empty space."""
    m = 'M'
    r = 'R'
    board = [ [r, r, r, r, m],
              [r, r, r, r, r],
              [r, r, m, r, r],
              [r, r, r, r, r],
              [m, r, r, r, r] ]

def set_board(new_board):
    """Replaces the global board with new_board."""
    global board
    board = new_board

def get_board():
    """Just returns the board. Possibly useful for unit tests."""
    return board

def string_to_location(s):
    """Given a two-character string (such as 'A5'), returns the designated
       location as a 2-tuple (such as (0, 4))."""
    assert s[0] >= 'A' and s[0] <= 'E'
    assert s[1] >= '1' and s[1] <= '5'
    str_to_num = {'A':0,'B':1,'C':2,'D':3,'E':4}
    num_to_num = {'1':0,'2':1,'3':2,'4':3,'5':4}
    return (str_to_num[s[0]],num_to_num[s[1]])
    

def location_to_string(location):
    """Returns the string representation of a location."""
    assert location[0] >= 0 and location[0] <= 4
    assert location[1] >= 0 and location[1] <= 4
    num_to_str = {0:'A',1:'B',2:'C',3:'D',4:'E'}
    num_to_num = {0:'1',1:'2',2:'3',3:'4',4:'5'}
    return num_to_str[location[0]]+num_to_num[location[1]]

def at(location):
    """Returns the contents of the board at the given location."""
    return board[location[0]][location[1]]

def all_locations():
    """Returns a list of all 25 locations on the board."""
    list = []
    for i in range (0,5):
        for j in range (0,5):
            list.append((i,j))
    return list

def adjacent_location(location, direction):
    """Return the location next to the given one, in the given direction.
       Does not check if the location returned is legal on a 5x5 board."""
    (row, column) = location
    direction_type = {'up':-1,'down':1,'left':-1,'right':1}
    if direction=='up' or direction=='down':
        return (row+direction_type[direction],column)
    else:
        return (row,column+direction_type[direction])

def is_legal_move_by_musketeer(location, direction):
    """Tests if the Musketeer at the location can move in the direction."""
    assert at(location) == 'M'
    if is_within_board(location,direction) == False:
        return False
    
    direction_type = {'up':-1,'down':1,'left':-1,'right':1}
    
    if direction == 'up' or direction == 'down':
        return at((location[0]+direction_type[direction],location[1])) == 'R'
    else:
        return at((location[0],location[1]+direction_type[direction])) == 'R'

def is_legal_move_by_enemy(location, direction):
    """Tests if the enemy at the location can move in the direction."""
    assert at(location) == 'R'
    if is_within_board(location,direction) == False:
        return False

    direction_type = {'up':-1,'down':1,'left':-1,'right':1}
    
    if direction == 'up' or direction == 'down':
        return at((location[0]+direction_type[direction],location[1])) == '-'
    else:
        return at((location[0],location[1]+direction_type[direction])) == '-'

def is_legal_move(location, direction):
    """Tests whether it is legal to move the piece at the location
    in the given direction."""
    if is_within_board(location,direction) == False:
        return False
    
    if at(location) == 'M':
        return is_legal_move_by_musketeer(location, direction)
    elif at(location) == 'R':
        return is_legal_move_by_enemy(location, direction)
    else:
        return False

def has_some_legal_move_somewhere(who):
    """Tests whether a legal move exists for player "who" (which must
    be either 'M' or 'R'). Does not provide any information on where
    the legal move is."""
    direction_type = {0:'up',1:'down',2:'left',3:'right'}

    if who == 'M':
        for i in range(0,5):
            for j in range(0,5):
                if at((i,j)) == 'M':
                    for k in range(0,4):
                        if is_legal_move_by_musketeer((i,j),direction_type[k]):
                            return True                   
    elif who == 'R':
        for i in range(0,5):
            for j in range(0,5):
                if at((i,j)) == 'R':
                    for k in range(0,4):
                        if is_legal_move_by_enemy((i,j),direction_type[k]):
                            return True
    return False

def possible_moves_from(location):
    """Returns a list of directions ('left', etc.) in which it is legal
       for the player at location to move. If there is no player at
       location, returns the empty list, []."""
    direction_type = {0:'up',1:'down',2:'left',3:'right'}
    list = []
    for i in range(0,4):
        if is_legal_move(location, direction_type[i]):
            list.append(direction_type[i])
    return list

def can_move_piece_at(location):
    """Tests whether the player at the location has at least one move available."""
    direction_type = {0:'up',1:'down',2:'left',3:'right'}
    for i in range(0,4):
        if is_legal_move(location,direction_type[i]):
            return True
    return False

def is_legal_location(location):
    """Tests if the location is legal on a 5x5 board."""
    if location[0]>=0 and location[0]<=4:
        if location[1]>=0 and location[1]<=4:
            return True
        else:
            return False
    else:
        return False
    
def is_within_board(location, direction):
    """Tests if the move stays within the boundaries of the board."""
    if is_legal_location(location)==False:
        return False

    direction_type = {'up':-1,'down':1,'left':-1,'right':1}

    if direction == 'up' or direction == 'down':
        return (location[0]+direction_type[direction] >= 0 and location[0]+direction_type[direction] <= 4)
    else:
        return (location[1]+direction_type[direction] >= 0 and location[1]+direction_type[direction] <= 4) 
    
def all_possible_moves_for(player):
    """Returns every possible move for the player ('M' or 'R') as a list
       (location, direction) tuples."""
    list = []
    direction_type = {0:'up',1:'down',2:'left',3:'right'}

    for i in range(0,5):
        for j in range(0,5):
            if player == 'M':
                if at((i,j)) == player:
                    for k in range(0,4):
                        if is_legal_move_by_musketeer((i,j),direction_type[k]):
                            list.append(((i,j),direction_type[k]))
            else:
                if at((i,j)) == player:
                    for k in range(0,4):
                        if is_legal_move_by_enemy((i,j),direction_type[k]):
                            list.append(((i,j),direction_type[k]))
    return list

def make_move(location, direction):
    """Moves the piece in location in the indicated direction."""
    direction_type = {'up':-1,'down':1,'left':-1,'right':1}
    if at(location) == 'M':
        if direction == 'up' or direction == 'down':
            if is_legal_move_by_musketeer(location,direction):
                board[location[0]][location[1]] = '-'
                board[location[0]+direction_type[direction]][location[1]] = 'M'
        else:
            if is_legal_move_by_musketeer(location,direction):
                board[location[0]][location[1]] = '-'
                board[location[0]][location[1]+direction_type[direction]] = 'M'
    elif at(location) == 'R':
        if direction == 'up' or direction == 'down':
            if is_legal_move_by_enemy(location,direction):
                board[location[0]][location[1]] = '-'
                board[location[0]+direction_type[direction]][location[1]] = 'R'
        else:
            if is_legal_move_by_enemy(location,direction):
                board[location[0]][location[1]] = '-'
                board[location[0]][location[1]+direction_type[direction]] = 'R'

def choose_computer_move(who):
    """The computer chooses a move for a Musketeer (who = 'M') or an
       enemy (who = 'R') and returns it as the tuple (location, direction),
       where a location is a (row, column) tuple as usual."""

    """The basic idea of how computer moves if computer is the M role:
       1. The distance of three musketeers will be calculated one by one in four directions,
       the move which will lead to the largest perimeter will be returned
       2. If the current perimeter is already the largest and any further legal move will
       cause a decrease in perimeter, computer will move randomly
       The basic idea of how computer moves if computer is the R role:
       1. The computer will keep moving up if there is a legal move in the board for R
       2: If the legal move for R to move up doesn't exist, computer will move randomly.
       As long as there is a legal move-up, computer will remain moving up"""
    # Calculate the largest perimeter in four directions for each M location
    if who == 'M':
        list = []
        for i in range(0,5):
            for j in range(0,5):
                if at((i,j)) == 'M':
                    list.append([i,j])
                    
        distance_one = distance_of_two_location(list[0],list[1])
        distance_two = distance_of_two_location(list[1],list[2])
        distance_three = distance_of_two_location(list[0],list[2])
        distance = distance_one + distance_two + distance_three
        distance_max = distance
        final_location = []
        
        for i in range(0,3):
            distance_up = distance
            distance_down = distance
            distance_left = distance
            distance_right = distance
            
            if is_legal_move_by_musketeer(((list[i][0],list[i][1])),'up'):
                list[i][0] -= 1
                distance_up = distance_of_two_location(list[0],list[1]) + distance_of_two_location(list[0],list[2]) + distance_of_two_location(list[1],list[2])
                list[i][0] += 1
                if distance_up >= distance_max:
                    final_location = [(list[i][0],list[i][1]),'up']
                    distance_max = distance_up
    
            if is_legal_move_by_musketeer(((list[i][0],list[i][1])),'down'):
                list[i][0] += 1
                distance_down = distance_of_two_location(list[0],list[1]) + distance_of_two_location(list[0],list[2]) + distance_of_two_location(list[1],list[2])
                list[i][0] -= 1
                if distance_down >= distance_max:
                    final_location = [(list[i][0],list[i][1]),'down']
                    distance_max = distance_down
                    
            if is_legal_move_by_musketeer(((list[i][0],list[i][1])),'left'):
                list[i][1] -= 1
                distance_left = distance_of_two_location(list[0],list[1]) + distance_of_two_location(list[0],list[2]) + distance_of_two_location(list[1],list[2])
                list[i][1] += 1
                if distance_left >= distance_max:
                    final_location = [(list[i][0],list[i][1]),'left']
                    distance_max = distance_left
                    
            if is_legal_move_by_musketeer(((list[i][0],list[i][1])),'right'):
                list[i][1] += 1
                distance_right = distance_of_two_location(list[0],list[1]) + distance_of_two_location(list[0],list[2]) + distance_of_two_location(list[1],list[2])
                list[i][1] -= 1
                if distance_right >= distance_max:
                    final_location = [(list[i][0],list[i][1]),'right']
                    distance_max = distance_right
                    
        # If the current perimeter is the largest, computer will randomly select a location and move randomly to a direction
        if distance_max == distance:
            random_direction = {1:'up',2:'down',3:'left',4:'right'}
            random_location = {1:list[0],2:list[1],3:list[2]}
            random_number = random.randint(1,3)
            random_location_x = random_location[random_number][0]
            random_location_y = random_location[random_number][1]
            random_location_direction = random_direction[random.randint(1,4)]
            
            while True:
                if is_legal_move_by_musketeer((random_location_x,random_location_y),random_location_direction) == False:
                    random_number = random.randint(1,3)
                    random_location_x = random_location[random_number][0]
                    random_location_y = random_location[random_number][1]
                    random_location_direction = random_direction[random.randint(1,4)]
                else:
                    break
                
            return ((random_location_x,random_location_y),random_location_direction)
        
        else:
            return (final_location[0],final_location[1])

    else:
        random_direction_for_enemy_list = {1:'up',2:'down',3:'left',4:'right'}
        random_direction_for_enemy = 'up'
        random_location_x = random.randint(0,4)
        random_location_y = random.randint(0,4)
        
        # check if there is a location that could be moved in random_direction_for_enemy
        while True:
            count_direction = 0
            for i in range(0,5):
                for j in range(0,5):
                    if at((i,j)) == 'R':
                        if is_legal_move_by_enemy((i,j),random_direction_for_enemy):
                            count_direction += 1
                            break
            if count_direction >=1:
                break
            else:
                random_direction_for_enemy = random_direction_for_enemy_list[random.randint(1,4)]
                
        # If there is at least a location that could be moved in random_direction_for_enemy, computer choose a random position to execute
        while True:
            if at((random_location_x,random_location_y)) == 'R' and is_legal_move_by_enemy((random_location_x,random_location_y),random_direction_for_enemy):
                break
            else:
                random_location_x = random.randint(0,4)
                random_location_y = random.randint(0,4)
        return ((random_location_x,random_location_y),random_direction_for_enemy)

def distance_of_two_location(location_one, location_two):
    """One more function to calculated the distance between two locations"""
    return math.sqrt((location_one[0]-location_two[0])*(location_one[0]-location_two[0]) + (location_one[1]-location_two[1])*(location_one[1]-location_two[1]))
    
def is_enemy_win():
    """Returns True if all 3 Musketeers are in the same row or column."""
    list = []
    for i in range(0,5):
        for j in range(0,5):
            if at((i,j)) == 'M':
                list.append([i,j])
    if list[0][0] == list[1][0] and list[1][0] == list[2][0]:
        return True
    elif list[0][1] == list[1][1] and list[1][1] == list[2][1]:
        return True
    else:
        return False

#---------- Communicating with the user ----------

def print_board():
    print("    1  2  3  4  5")
    print("  ---------------")
    ch = "A"
    for i in range(0, 5):
        print(ch, "|", end = " ")
        for j in range(0, 5):
            print(board[i][j] + " ", end = " ")
        print()
        ch = chr(ord(ch) + 1)
    print()

def print_instructions():
    print()
    print("""To make a move, enter the location of the piece you want to move,
and the direction you want it to move. Locations are indicated as a
letter (A, B, C, D, or E) followed by an integer (1, 2, 3, 4, or 5).
Directions are indicated as left, right, up, or down (or simply L, R,
U, or D). For example, to move the Musketeer from the top right-hand
corner to the row below, enter 'A5 left' (without quotes).
For convenience in typing, you may use lowercase letters.""")
    print()

def choose_users_side():
    """Returns 'M' if user is playing Musketeers, 'R' otherwise."""
    user = ""
    while user != 'M' and user != 'R':
        answer = input("Would you like to play Musketeer (M) or enemy (R)? ")
        answer = answer.strip()
        if answer != "":
            user = answer.upper()[0]
    return user

def get_users_move():
    """Gets a legal move from the user, and returns it as a
       (location, direction) tuple."""    
    directions = {'L':'left', 'R':'right', 'U':'up', 'D':'down'}
    move = input("Your move? ").upper().replace(' ', '')
    if (len(move) >= 3
            and move[0] in 'ABCDE'
            and move[1] in '12345'
            and move[2] in 'LRUD'):
        location = string_to_location(move[0:2])
        direction = directions[move[2]]
        if is_legal_move(location, direction):
            return (location, direction)
    print("Illegal move--'" + move + "'")
    return get_users_move()

def move_musketeer(users_side):
    """Gets the Musketeer's move (from either the user or the computer)
       and makes it."""
    if users_side == 'M':
        (location, direction) = get_users_move()
        if at(location) == 'M':
            if is_legal_move(location, direction):
                make_move(location, direction)
                describe_move("Musketeer", location, direction)
        else:
            print("You can't move there!")
            return move_musketeer(users_side)
    else: # Computer plays Musketeer
        (location, direction) = choose_computer_move('M')         
        make_move(location, direction)
        describe_move("Musketeer", location, direction)
        
def move_enemy(users_side):
    """Gets the enemy's move (from either the user or the computer)
       and makes it."""
    if users_side == 'R':
        (location, direction) = get_users_move()
        if at(location) == 'R':
            if is_legal_move(location, direction):
                make_move(location, direction)
                describe_move("Enemy", location, direction)
        else:
            print("You can't move there!")
            return move_enemy(users_side)
    else: # Computer plays enemy
        (location, direction) = choose_computer_move('R')         
        make_move(location, direction)
        describe_move("Enemy", location, direction)
        return board

def describe_move(who, location, direction):
    """Prints a sentence describing the given move."""
    new_location = adjacent_location(location, direction)
    print(who, 'moves', direction, 'from',\
          location_to_string(location), 'to',\
          location_to_string(new_location) + ".\n")

def start():
    """Plays the Three Musketeers Game."""
    users_side = choose_users_side()
    board = create_board()
    print_instructions()
    print_board()
    while True:
        if has_some_legal_move_somewhere('M'):
            board = move_musketeer(users_side)
            print_board()
            if is_enemy_win():
                print("Cardinal Richleau's men win!")
                break
        else:
            print("The Musketeers win!")
            break
        if has_some_legal_move_somewhere('R'):
            board = move_enemy(users_side)
            print_board()
        else:
            print("The Musketeers win!")
            break

start()
