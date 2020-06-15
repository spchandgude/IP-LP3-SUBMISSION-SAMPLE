def not_poor(str1):
	string_not = str1.find('not')
	string_poor = str1.find('poor')
if string_poor>string_not and string_not>0 and string_poor>0:
	str1 = str1.replace(str1[string_not:(string_poor+4)],'good')
	return str1
else:
	return str1
print("The lyrics is not that poor !")
print("The lyrics is poor!")