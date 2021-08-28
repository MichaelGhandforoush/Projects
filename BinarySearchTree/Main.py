import Classes

node = Classes.Node(5)
bst = Classes.BinarySearchTree()

bst.insert(12)
bst.insert(26)
bst.insert(261)
bst.insert(6)

gen = bst.preorder(bst.root)
print(next(gen))
print(next(gen))
print(next(gen))
print(next(gen))


