
print("the code is Run and Executed by KARAN SHAH 1812054 ")

inp="a1"
code='abcdefgh'
inp[0]

code.index(inp[0])
row_pos=int(code.index(inp[0]))+1
col_pos=int(inp[-1])
(row_pos+col_pos)%2


code="abcdefgh"
cell=input("enter a cell label:")
col_pos=int(code.index(cell[0]))+1
row_pos=int(cell[-1])
pos=row_pos+col_pos
print("the cell is white") if pos%2==1 else print("the cell is black")






