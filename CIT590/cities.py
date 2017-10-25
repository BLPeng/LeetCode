#Student name: Bolu Peng
#Penn ID: 16847239
#I accomplish this assignment all by myself

import math
import random

def main():
    road_map = read_cities('city-data.txt')
    road_map_final = road_map[:]
    print_cities(road_map)
    count = 0
    while count < 3:
        # Randomly shuffle the list
        random.shuffle(road_map)
        road_map = find_best_cycle(road_map)
        count += 1
        print()
        print('The total distance of iteration',count,'is',compute_total_distance(road_map))
        # Record the optimal results from the 3 iterations
        if compute_total_distance(road_map) < compute_total_distance(road_map_final):
            road_map_final = road_map[:]
    # Print the optimal result from the 3 iterations
    print_map(road_map_final)

def read_cities(file_name):
    road_map_initial = []
    city_data = open(file_name,'r')
    for line in city_data:
        line_s = line.strip()
        city = line_s.split('\t')
        tuple = (city[0],city[1],city[2],city[3])
        road_map_initial.append(tuple)
    city_data.close()
    return road_map_initial

def print_cities(road_map):
    list = []
    for i in range(0,len(road_map)):
        list.append((road_map[i][0],road_map[i][1],str(round(float(road_map[i][2]),2)),str(round(float(road_map[i][3]),2))))
    print(list)

def compute_total_distance(road_map):
    total_distance = 0
    for i in range(0,len(road_map)-1):
        total_distance += distance((float(road_map[i][2]),float(road_map[i][3])),(float(road_map[i+1][2]),float(road_map[i+1][3])))
    total_distance += distance((float(road_map[len(road_map)-1][2]),float(road_map[len(road_map)-1][3])),(float(road_map[0][2]),float(road_map[0][3])))
    return total_distance

def distance(location_one, location_two):
    return math.sqrt(math.pow((location_one[0]-location_two[0]),2)+math.pow((location_one[1]-location_two[1]),2))

def find_best_cycle(road_map):
    count = 50
    while count > 0:
        # Find the one-sawp that decreases the distance most in each of the 50 iterations
        (index1,index2) = best_swap_per_turn(road_map)
        previous_distance = compute_total_distance(road_map)
        # Update a new map that has a shorter total distance than previous one's
        (road_map,new_total_distance) = swap_cities(road_map, index1, index2)
        current_distance = compute_total_distance(road_map)
        count -= 1
        # If the difference between current distance and previous distance is smaller than 0.1, then we assume no further swap can decrease the total distance
        if abs(current_distance-previous_distance)<0.1:
            break
    return road_map

def best_swap_per_turn(road_map):
    shortest_total_distance = compute_total_distance(road_map)
    # Swap every possible two positions in the list to find out the best one-swap that decrease the total distance most
    index1 = -1
    index2 = -1
    for i in range(0,len(road_map)-1):
        for j in range(i+1,len(road_map)):
            (new_road_map,new_total_distance) = swap_cities(road_map, i, j)
            if new_total_distance < shortest_total_distance:
                shortest_total_distance = new_total_distance
                index1 = i
                index2 = j
    return (index1,index2)

def swap_cities(road_map, index1, index2):
    if index1 == index2:
        return (road_map, compute_total_distance(road_map))
    new_road_map = road_map[:]
    # Swap position
    temp = new_road_map[index1]
    new_road_map[index1] = new_road_map[index2]
    new_road_map[index2] = temp
    new_total_distance = compute_total_distance(new_road_map)
    return (new_road_map,new_total_distance)

def print_map(road_map):
    list = []
    for i in range(0,len(road_map)-1):
        print()
        print('Distance:',road_map[i][0],road_map[i][1],'--->',road_map[i+1][0],road_map[i+1][1],'is',distance((float(road_map[i][2]),float(road_map[i][3])),(float(road_map[i+1][2]),float(road_map[i+1][3]))))
    print()
    print('Distance:',road_map[len(road_map)-1][0],road_map[len(road_map)-1][1],'--->',road_map[0][0],road_map[0][1],'is',distance((float(road_map[len(road_map)-1][2]),float(road_map[len(road_map)-1][3])),(float(road_map[0][2]),float(road_map[0][3]))))
    print()
    print('The smallest total cost/distance is',compute_total_distance(road_map))

if __name__ == '__main__':
    main()


        
        
