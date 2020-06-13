string=input('Enter the string:')

def removeduplicate(string):
    uniqs=''
    for x in string:
        if not(x in uniqs):
            uniqs=uniqs+x
    return uniqs

print(removeduplicate(string))