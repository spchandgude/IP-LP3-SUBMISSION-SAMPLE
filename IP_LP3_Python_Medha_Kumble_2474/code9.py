class check(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def is_BST(root):
    stack = []
    prev = None
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        if prev and root.val <= prev.val:
            return False
        prev = root
        root = root.right
    return (True)

r=int(input('Enter the root node:'))
rl=int(input('Enter the left node:'))
rr=int(input('Enter the right node:'))

root = check(r)  
root.left = check(rl)  
root.right = check(rr) 
 
result = is_BST(root)
print(result)

