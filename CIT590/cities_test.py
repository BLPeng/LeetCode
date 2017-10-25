#Student name: Bolu Peng
#Penn ID: 16847239
#I accomplish this assignment all by myself

import unittest
from cities import *

class TestCities(unittest.TestCase):

    def test_compute_total_distance(self):
        road_map = read_cities('city-data.txt')
        road_map_temp = road_map[0:3]
        self.assertTrue(compute_total_distance(road_map)-1060.1714633538202<1e-05)
        self.assertTrue(compute_total_distance(road_map_temp)-113.92444731706529<1e-05)

    def test_distance(self):
        self.assertTrue(distance((2,3),(4,7))-4.47213595499958<1e-05)
        self.assertTrue(distance((4,9),(13,7))-9.219544457292887<1e-05)
        self.assertTrue(distance((24,95),(44,162))-69.92138442565336<1e-05)

    def test_find_best_cycle(self):
        # The best one-swap of initial map road_map_temp we can get is to swap the element at index 0 and index 1
        road_map = read_cities('city-data.txt')
        road_map_temp = road_map[0:3]
        road_map_temp = [('Alabama', 'Montgomery', '32.361538', '-86.279118'), ('Alaska', 'Juneau', '58.301935', '-134.41974'), ('Arizona', 'Phoenix', '33.448457', '-112.073844')]
        self.assertEqual(find_best_cycle(road_map_temp),[('Alaska', 'Juneau', '58.301935', '-134.41974'),('Alabama', 'Montgomery', '32.361538', '-86.279118'),('Arizona', 'Phoenix', '33.448457', '-112.073844')])
        # The optimal result of best one-swap can not be smaller than 0 
        self.assertLessEqual(0,compute_total_distance(find_best_cycle(road_map)))

    def test_best_swap_per_turn(self):
        # The best one-swap of initial map road_map_temp_one we can get is to swap the element at index 0 and index 1
        road_map = read_cities('city-data.txt')
        road_map_temp_one = road_map[0:3]
        self.assertEqual(best_swap_per_turn(road_map_temp_one),(0,1))
        # The best one-swap of initial map road_map_temp_two we can get is to swap the element at index 4 and index 6
        road_map_temp_two = [('Missouri', 'Jefferson City', '38.572954', '-92.189283'),
                             ('Montana', 'Helana', '46.595805', '-112.027031'),
                             ('Nebraska', 'Lincoln', '40.809868', '-96.675345'),
                             ('Nevada', 'Carson City', '39.160949', '-119.753877'),
                             ('New Hampshire', 'Concord', '43.220093', '-71.549127'),
                             ('New Jersey', 'Trenton', '40.221741', '-74.756138'),
                             ('New Mexico', 'Santa Fe', '35.667231', '-105.964575'),
                             ('New York', 'Albany', '42.659829', '-73.781339'),
                             ('North Carolina', 'Raleigh', '35.771', '-78.638'),
                             ('North Dakota', 'Bismarck', '48.813343', '-100.779004'),
                             ('Ohio', 'Columbus', '39.962245', '-83.000647')]
        self.assertEqual(best_swap_per_turn(road_map_temp_two),(4,6))
        
    def test_swap_cities(self):
        road_map = read_cities('city-data.txt')
        (new_road_map,new_total_distance) = swap_cities(road_map, 0, 49)
        self.assertEqual(road_map[0],('Alabama','Montgomery','32.361538','-86.279118'))
        self.assertEqual(road_map[49],('Wyoming','Cheyenne','41.145548','-104.802042'))
        self.assertTrue(compute_total_distance(road_map)-1060.1714633538202<1e-05)
        self.assertEqual(new_road_map[0],('Wyoming','Cheyenne','41.145548','-104.802042'))
        self.assertEqual(new_road_map[49],('Alabama','Montgomery','32.361538','-86.279118'))
        self.assertTrue(new_total_distance-1035.330941636721<1e-05)

unittest.main()
