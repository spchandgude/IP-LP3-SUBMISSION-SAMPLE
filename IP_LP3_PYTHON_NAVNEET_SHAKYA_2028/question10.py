def selctionSort(alist):
	for fillslot in range(len(alist)-1,0,1):
		PosofMax = 0
	for location in range(1,fillslot+1):
		if alist[location] > alist[PosofMax]:
			PosofMax = location
		temp = alist[fillslot]
       alist[fillslot] = alist[PosOfMax]
       alist[PosOfMax] = temp
 
alist = [14,46,43,27,57,41,45,21,70]
selectionSort(alist)
print(alist)

