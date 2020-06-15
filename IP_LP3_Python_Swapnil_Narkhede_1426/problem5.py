def Remove(duplicate):
    final_list = []
    for x in duplicate:
        if x not in final_list:
            final_list.append(x)
    return final_list


duplicate = ['a','b','a','b','a','c','d']
print(Remove(duplicate))