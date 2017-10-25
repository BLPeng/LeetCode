##Student Name: Bolu Peng
##Penn ID: 16847239
##I take reference to this website http://bbs.csdn.net/topics/370089561
##to learn how to check the input is number or not 

def safe_landing():
    ## initialize four variables
    altitude = 1000.0
    fuel = 1000.0
    velocity = 0.0
    time = 0
               
    while (altitude>0):
        ## check whether the input is legal or not, the input should be numbers
        while True:
            try:
                consumption = float(input("Please input how much fuel to burn in the next second"))
            except:
                continue
            else:
                break
        ## reset consumption value if it's larger than fuel left or smaller than 0    
        if consumption>fuel:
            consumption = fuel
        if consumption<0:
            consumption = 0
        ## the mathematical section
        velocity += (1.6 - 0.15*consumption)
        altitude -= velocity
        fuel -= consumption
        time += 1
        ## display the current parameters each second
        if (altitude<0):
            print("Current altitude is 0 meter")
        else:
            print("Current altitude is",altitude,"meters")

        print("Current velocity is",velocity,"meters/second")

        if (fuel<0):
            print("Current fuel is 0 liter")
        else:
            print("Current fuel is",fuel,"liters")
        
    ## tell the player if it's safe landing or not
    if (velocity<10 and velocity>=0):
        print("Safe landing!")
        print("The landing velocity is",velocity,"meters/second")
        print("Landing duration",time,"seconds")
        print("Fuel left",fuel,"liters")
    else:
        print("Landing was unsuccessful")
        print("The landing velocity is",velocity,"meters/second")
        print("Landing duration",time,"seconds")
        print("Fuel left",fuel,"liters")
        
## main function section
safe_landing()
## wanna play again?
while True:
    b = input("Wanna play again?")
    if b.startswith('y') or b.startswith('Y'):
        safe_landing()
    elif b.startswith('n') or b.startswith('N'):
        break
 
 
