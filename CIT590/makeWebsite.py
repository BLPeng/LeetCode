#Student:Bolu Peng
#Penn ID:16847239
#I completed the first section by myself
def main():
    content = reading_file('resume.txt')
    #write a dictionary that has key-value pair
    content_detail = arrange_content(content)
    #Write readable HTML context 
    context = writing_html(content_detail)
    write_to_html('resume.html',context)

def reading_file(filename):
    #Extract the content
    lines = open(filename,'r')
    content = []
    for line in lines:
        line = line.strip()
        #If it's an empty line, continue
        if not len(line):
            continue
        else:
            content.append(line)
    lines.close()
    return content

def arrange_content(content):
    #Return a dictionary that has key-value pair
    content_detail = {}
    for i in range(len(content)):
        if i==0 and detecting_name(content[i]):
            content_detail['Name'] = content[i]
        else:
            if detecting_emails(content[i]):
                content_detail['Email'] = content[i]
            elif detecting_courses(content[i]):
                content_detail['Courses'] = extracting_courses(content[i])
            elif detecting_educations(content[i]):
                if 'Education' in content_detail:
                    content_detail['Education'].append(content[i])
                else:
                    content_detail['Education'] = [content[i]]
            else:
                #Match several projects as a list of value to key 'Projects'
                count = i
                while if_it_is_at_end(content[count])==False:
                    if content[count]=='Projects':
                        count += 1
                        continue
                    elif 'Projects' in content_detail:
                        content_detail['Projects'].append(content[count])
                    else:
                        content_detail['Projects'] = [content[count]]
                    count += 1
                break
    return content_detail               

def if_it_is_at_end(line):
    #Check if it is the end of the file
    count = 0
    for i in range(len(line)):
        if line[i]=='-':
            count+=1
            if count>=10:
                return True
    return False

def detecting_name(line):
    line_split = line.split()
    for word in line_split:
        if ord(word[0]) not in range(65,91):
            raise RuntimeError('Firts line has to be just the name with proper capitalization')
    return True

def detecting_educations(line):
    if 'University' in line or 'university' in line:
        if 'Bachelor' in line or 'bachelor' in line:
            return True
        elif 'Master' in line or 'master' in line:
            return True
        elif 'Doctor' in line or 'doctor' in line:
            return True
        else:
            return False
    else:
        return False

def detecting_emails(line):
    if '@' in line:
        index_of_at = line.index('@')
        if line.endswith('.edu'):
            index_of_end = line.index('.edu')
            if ord(line[index_of_at+1]) in range(97,123) and index_of_end > (index_of_at+1):
                return True
            else:
                return False
        elif line.endswith('.com'):
            index_of_end = line.index('.com')
            if ord(line[index_of_at+1]) in range(97,123) and index_of_end > (index_of_at+1):
                return True
            else:
                return False
        else:
            return False
    else:
        return False

def detecting_courses(line):
    if line.startswith('Courses'):
        return True
    else:
        return False

def extracting_courses(line):
    line_split = line.split()
    line_final = []
    for i in range(1,len(line_split)):
        if (ord(line_split[i][0]) in range(65,91)) or (ord(line_split[i][0]) in range(97,123)):
            line_final.append(line_split[i])
        else:
            continue
    return ' '.join(line_final)

def detecting_projects(line):
    if line.startswith('Projects'):
        return True
    else:
        return False

def write_to_html(file_name,content_detail):
    f = open(file_name, 'r+')
    lines = f.readlines()
    f.seek(0)
    f.truncate()
    del lines[-1]
    del lines[-1]
    lines.append('\n')
    lines.append('<div id="page-wrap">\n')
    for element in content_detail:
        lines.append(element)
    lines.append('\n')
    lines.append('</div>\n')
    lines.append('</body>\n')
    lines.append('</html>\n')
    f.writelines(lines)
    f.close()

def surround_block(tag,text):
    content = ''
    if '</' in text:
        content = '<' + tag + '>\n' + text + '</' + tag + '>\n'
    else:
        content = '<' + tag + '>\n' + text+ '\n' + '</' +tag +'>\n'
    return content

def writing_html(content_detail):
    context = []
    context.append(basic_information_section(content_detail['Name'],content_detail['Email'])+'\n')
    context.append(education_section(content_detail['Education'])+'\n')
    context.append(project_section(content_detail['Projects'])+'\n')
    context.append(course_section(content_detail['Courses']))
    return context

def basic_information_section(name,email):
    return surround_block('div',surround_block('h1',name)+surround_block('p','Email: '+email))

def education_section(education):
    content = ''
    for word in education:
        content += surround_block('li',word)
    return surround_block('div',surround_block('h2','Education')+surround_block('ul',content))

def project_section(projects):
    content = ''
    for word in projects:
        content += surround_block('li',surround_block('p',word))
    return surround_block('div',surround_block('h2','Projects')+surround_block('ul',content))

def course_section(courses):
    return surround_block('div',surround_block('h3','Courses')+surround_block('span',courses))

if __name__ == "__main__":
    main()
        
        
