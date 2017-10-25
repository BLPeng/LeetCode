#Student name: Bolu Peng
#Penn ID: 16847239
#I accomplish this assignment all by myself

import unittest
from three_musketeers import *

left = 'left'
right = 'right'
up = 'up'
down = 'down'
M = 'M'
R = 'R'
_ = '-'

class TestThreeMusketeers(unittest.TestCase):

    def setUp(self):
        set_board([ [_, _, _, M, _],
                    [_, _, R, M, _],
                    [_, R, M, R, _],
                    [_, R, _, _, _],
                    [_, _, _, R, _] ])

    def test_create_board(self):
        create_board()
        self.assertEqual(at((0, 0)), 'R')
        self.assertEqual(at((0, 4)), 'M')

    def test_set_board(self):
        self.assertEqual(at((0, 0)), '-')
        self.assertEqual(at((1, 2)), 'R')
        self.assertEqual(at((1, 3)), 'M')

    def test_get_board(self):
        self.assertEqual([ [_, _, _, M, _],
                           [_, _, R, M, _],
                           [_, R, M, R, _],
                           [_, R, _, _, _],
                           [_, _, _, R, _] ],
                         get_board())

    def test_string_to_location(self):
        self.assertEqual(string_to_location('A1'),(0,0))
        self.assertEqual(string_to_location('E5'),(4,4))
        self.assertEqual(string_to_location('B3'),(1,2))
        self.assertEqual(string_to_location('D2'),(3,1))

    def test_location_to_string(self):
        self.assertEqual(location_to_string((0,0)),'A1')
        self.assertEqual(location_to_string((4,4)),'E5')
        self.assertEqual(location_to_string((1,2)),'B3')
        self.assertEqual(location_to_string((3,1)),'D2')

    def test_at(self):
        self.assertEqual(at((0,1)),'-')
        self.assertEqual(at((2,2)),'M')
        self.assertEqual(at((4,3)),'R')

    def test_all_locations(self):
        self.assertEqual(all_locations(),[(0,0),(0,1),(0,2),(0,3),(0,4),(1,0),(1,1),(1,2),(1,3),(1,4),(2,0),(2,1),(2,2),(2,3),(2,4),(3,0),(3,1),(3,2),(3,3),(3,4),(4,0),(4,1),(4,2),(4,3),(4,4)])

    def test_adjacent_location(self):
        self.assertEqual(adjacent_location((1,3),'left'),(1,2))
        self.assertEqual(adjacent_location((2,5),'up'),(1,5))
        self.assertEqual(adjacent_location((3,2),'down'),(4,2))
        self.assertEqual(adjacent_location((4,3),'right'),(4,4))
        
    def test_is_legal_move_by_musketeer(self):
        self.assertTrue(is_legal_move_by_musketeer((2,2),'up'))
        self.assertTrue(is_legal_move_by_musketeer((1,3),'left'))
        self.assertFalse(is_legal_move_by_musketeer((2,2),'down'))
        self.assertFalse(is_legal_move_by_musketeer((0,3),'up'))
        self.assertFalse(is_legal_move_by_musketeer((1,3),'up'))
        
    def test_is_legal_move_by_enemy(self):
        self.assertTrue(is_legal_move_by_enemy((1,2),'up'))
        self.assertTrue(is_legal_move_by_enemy((2,1),'left'))
        self.assertFalse(is_legal_move_by_enemy((4,3),'down'))
        self.assertFalse(is_legal_move_by_enemy((2,3),'up'))
        self.assertFalse(is_legal_move_by_enemy((3,1),'up'))

    def test_is_legal_move(self):
        self.assertFalse(is_legal_move((0,3),'up'))
        self.assertFalse(is_legal_move((4,3),'down'))
        self.assertTrue(is_legal_move((2,2),'left'))
        self.assertFalse(is_legal_move((1,4),'up'))

    def test_has_some_legal_move_somewhere(self):
        set_board([ [_, _, _, M, _],
                    [_, R, _, M, _],
                    [_, _, M, _, R],
                    [_, R, _, _, _],
                    [_, _, _, R, _] ] )
        self.assertFalse(has_some_legal_move_somewhere('M'))
        self.assertTrue(has_some_legal_move_somewhere('R'))
        set_board([ [R, R, R, R, M],
                    [R, R, R, R, R],
                    [R, R, M, R, R],
                    [R, R, R, R, R],
                    [M, R, R, R, R] ])
        self.assertTrue(has_some_legal_move_somewhere('M'))
        self.assertFalse(has_some_legal_move_somewhere('R'))
        set_board([ [_, _, _, _, M],
                    [_, _, _, _, _],
                    [_, _, M, _, _],
                    [_, _, _, _, _],
                    [M, _, R, _, _] ])
        self.assertFalse(has_some_legal_move_somewhere('M'))
        self.assertTrue(has_some_legal_move_somewhere('R'))
        

    def test_possible_moves_from(self):
        self.assertEqual(possible_moves_from((0,3)),[])
        self.assertEqual(possible_moves_from((1,3)),['down','left'])
        self.assertEqual(possible_moves_from((2,2)),['up','left','right'])
        self.assertEqual(possible_moves_from((4,3)),['up','left','right'])


    def test_can_move_piece_at(self):
        set_board([ [_, _, _, M, R],
                    [_, _, _, M, M],
                    [_, _, R, _, _],
                    [_, _, _, _, _],
                    [_, _, _, _, _] ] )
        self.assertTrue(can_move_piece_at((0,3)))
        self.assertFalse(can_move_piece_at((1,3)))
        self.assertTrue(can_move_piece_at((1,4)))
        self.assertFalse(can_move_piece_at((0,4)))

    def test_is_legal_location(self):
        self.assertTrue(is_legal_location((4,2)))
        self.assertTrue(is_legal_location((0,0)))
        self.assertFalse(is_legal_location((-1,2)))
        self.assertFalse(is_legal_location((3,5)))

    def test_is_within_board(self):
        self.assertTrue(is_within_board((0,3),'down'))
        self.assertFalse(is_within_board((1,4),'right'))
        self.assertFalse(is_within_board((0,4),'up'))
        self.assertFalse(is_within_board((3,0),'left'))
        
    def test_all_possible_moves_for(self):
        set_board([ [_, _, R, M, R],
                    [_, _, _, M, M],
                    [_, _, _, _, _],
                    [_, _, _, _, _],
                    [_, _, _, _, _] ] )
        self.assertEqual(all_possible_moves_for('M'),[((0,3),'left'),((0,3),'right'),((1,4),'up')])
        self.assertEqual(all_possible_moves_for('R'),[((0,2),'down'),((0,2),'left')]) 
        
    def test_make_move(self):
        make_move((1,3),'down')
        self.assertEqual(at((1,3)),'-')
        self.assertEqual(at((2,3)),'M')
        make_move((2,1),'left')
        self.assertEqual(at((2,0)),'R')
        self.assertEqual(at((2,1)),'-')
        
    def test_choose_computer_move(self):
        self.assertEqual(choose_computer_move('M'),((2,2),'left'))
        # In the board, the 'M' located at (2,2) will move left so that the sum of distance between (0,3) and (1,3), (0,3) and (2,2), (1,3) and (2,2) is the largest 
        self.assertIn(choose_computer_move('R'),all_possible_moves_for('R')) 
        
    def test_distance_of_two_location(self):
        self.assertEqual(distance_of_two_location((0,0),(1,1)),math.sqrt(2))
        self.assertEqual(distance_of_two_location((1,3),(4,2)),math.sqrt(10))
        self.assertEqual(distance_of_two_location((2,2),(3,4)),math.sqrt(5))

    def test_is_enemy_win(self):
        set_board([ [_, _, R, M, R],
                    [_, _, _, M, _],
                    [_, _, _, M, _],
                    [_, _, _, _, _],
                    [_, _, _, _, _] ] )
        self.assertTrue(is_enemy_win())

unittest.main()
