#Student:Bolu Peng
#Penn ID:16847239
#I completed the unittest section all by myself

import unittest
from makeWebsite import *

class TestHTML(unittest.TestCase):

    def test_arrange_content(self):
        content = ['Neal Fan',
                   'Western University - Master of Science in Chemical Engineering',
                   'Sichuan University - Bachelor of Engineering in Polymer Materials',
                   'neal@all.edu',
                   'Courses :- CBE254, CIT590, ENM503',
                   'Projects',
                   'Published JACS',
                   'National Level Innovative Experiment',
                   '-------------']
        content_detail = {'Name':'Neal Fan',
                         'Education':['Western University - Master of Science in Chemical Engineering',
                         'Sichuan University - Bachelor of Engineering in Polymer Materials'],
                         'Email':'neal@all.edu',
                         'Courses':'CBE254, CIT590, ENM503',
                         'Projects':['Published JACS','National Level Innovative Experiment']}
        self.assertEqual(arrange_content(content),content_detail)

    def test_if_it_is_at_end(self):
        line_one = '-----------'
        line_two = 'Neal Fan'
        self.assertTrue(if_it_is_at_end(line_one))
        self.assertFalse(if_it_is_at_end(line_two))

    def test_detecting_name(self):
        name_one = 'Neal Fan'
        name_two = 'neal Fan'
        name_three = '123'
        self.assertTrue(detecting_name(name_one))
        self.assertRaises(RuntimeError,detecting_name,name_two)
        self.assertRaises(RuntimeError,detecting_name,name_three)

    def test_detecting_educations(self):
        education_one = 'Sichuan University - Bachelor of Engineering in Polymer Materials'
        education_two = 'Sichuan University - Polymer Materials'
        education_three = 'Sichuan - Bachelor of Engineering in Polymer Materials'
        self.assertTrue(detecting_educations(education_one))
        self.assertFalse(detecting_educations(education_two))
        self.assertFalse(detecting_educations(education_three))

    def test_detecting_emails(self):
        email_one = 'neal@all.edu'
        email_two = 'neal@all'
        email_three = 'neal@.edu'
        email_four = 'neal@all.org'
        self.assertTrue(detecting_emails(email_one))
        self.assertFalse(detecting_emails(email_two))
        self.assertFalse(detecting_emails(email_three))
        self.assertFalse(detecting_emails(email_four))

    def test_detecting_courses(self):
        self.assertTrue(detecting_courses('Courses'))
        self.assertFalse(detecting_courses('ABC'))

    def test_extracting_courses(self):
        course_one = 'Courses :- CBE254, CIT590, ENM503'
        course_two = 'Courses - Chemical Reaction Engineering, Introduction to Probability'
        self.assertEqual(extracting_courses(course_one),'CBE254, CIT590, ENM503')
        self.assertEqual(extracting_courses(course_two),'Chemical Reaction Engineering, Introduction to Probability')

    def test_detecting_projects(self):
        self.assertTrue(detecting_projects('Projects'))
        self.assertFalse(detecting_projects('ABC'))

    def test_surround_block(self):
        tag = 'h1'
        text = 'Neal Fan'
        self.assertEqual(surround_block('h1','Neal Fan'),'<h1>\nNeal Fan\n</h1>\n')

    def test_writing_html(self):
        content_detail = {'Name':'Neal Fan',
                         'Education':['Western University - Master of Science in Chemical Engineering',
                         'Sichuan University - Bachelor of Engineering in Polymer Materials'],
                         'Email':'neal@all.edu',
                         'Courses':'CBE254, CIT590, ENM503',
                         'Projects':['Published JACS','National Level Innovative Experiment']}
        context = ['<div>\n<h1>\nNeal Fan\n</h1>\n<p>\nEmail: neal@all.edu\n</p>\n</div>\n\n',
                   '<div>\n<h2>\nEducation\n</h2>\n<ul>\n<li>\nWestern University - Master of Science in Chemical Engineering\n</li>\n<li>\nSichuan University - Bachelor of Engineering in Polymer Materials\n</li>\n</ul>\n</div>\n\n',
                   '<div>\n<h2>\nProjects\n</h2>\n<ul>\n<li>\n<p>\nPublished JACS\n</p>\n</li>\n<li>\n<p>\nNational Level Innovative Experiment\n</p>\n</li>\n</ul>\n</div>\n\n',
                   '<div>\n<h3>\nCourses\n</h3>\n<span>\nCBE254, CIT590, ENM503\n</span>\n</div>\n']
        self.assertEqual(writing_html(content_detail),context)

    def test_basic_information_section(self):
        name = 'Neal Fan'
        email = 'neal@all.edu'
        self.assertEqual(basic_information_section(name,email),'<div>\n<h1>\nNeal Fan\n</h1>\n<p>\nEmail: neal@all.edu\n</p>\n</div>\n')

    def test_education_section(self):
        education = ['Western University - Master of Science in Chemical Engineering',
                     'Sichuan University - Bachelor of Engineering in Polymer Materials']
        education_for_HTML = '<div>\n<h2>\nEducation\n</h2>\n<ul>\n<li>\nWestern University - Master of Science in Chemical Engineering\n</li>\n<li>\nSichuan University - Bachelor of Engineering in Polymer Materials\n</li>\n</ul>\n</div>\n'
        self.assertEqual(education_section(education),education_for_HTML)

    def test_project_section(self):
        project = ['Published JACS','National Level Innovative Experiment']
        project_for_HTML = '<div>\n<h2>\nProjects\n</h2>\n<ul>\n<li>\n<p>\nPublished JACS\n</p>\n</li>\n<li>\n<p>\nNational Level Innovative Experiment\n</p>\n</li>\n</ul>\n</div>\n'
        self.assertEqual(project_section(project),project_for_HTML)

    def test_course_section(self):
        course = 'CBE254, CIT590, ENM503'
        course_for_HTML = '<div>\n<h3>\nCourses\n</h3>\n<span>\nCBE254, CIT590, ENM503\n</span>\n</div>\n'
        self.assertEqual(course_section(course),course_for_HTML)
        
unittest.main()
