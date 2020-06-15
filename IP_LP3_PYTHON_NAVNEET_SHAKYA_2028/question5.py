def RemoveduplicateFromString(str ,n):
	index =0
    for i in range(0,n):
    	for j in range(0,i+1):
    		if (str[i]==str[j]):
    			break
	    if (j == i):
	    	str[index] = str[i]
		index = index+1
	return " ".join(str[:index])
str = "ababacd"
n = len(str)
print(RemoveduplicateFromString(list(str),n))

