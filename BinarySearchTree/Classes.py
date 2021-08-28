class Node:

    def __init__(self, data):
        self.parent = None
        self.left = None
        self.right = None
        self.data = data

class BinarySearchTree:
    def __init__(self):
        self.root = None


    def insert(self, data):
        if self.root == None:
            self.root = Node(data)
        else:
            self.InsertNode(self.root, data)

    def InsertNode(self, current, data):
        if data < current.data:
            if current.left == None:
                current.left = Node(data)
                current.left.parent = current
            else:
                self.InsertNode(current.left, data)
        else:
            if current.right == None:
                current.right = Node(data)
                current.right.parent = current
            else:
                self.InsertNode(current.right, data)


    def __contains__(self, root, data):
        if root == None:
            return False
        if root.data == data:
            return True
        elif data < root.data:
            return self.__contains__(root.left, data)
        else:
            return self.__contains__(root.right, data)


    def findParent(self, data, root):
        if data == root.data:
            return None
        if data < root.data:
            if root.left == None:
                 return None
            elif root.left.data == data:
                return root
            else:
                return self.findParent(data, root.left)
        else:
            if root.rigth == None:
                return None
            elif root.right.data == data:
                return root
            else:
                return self.findParent(data, root.right)

    def __findNode(self, root, value):
        if root == None:
            return None
        if root.data == value:
            return root
        elif value < root.data:
            return self.__findNode(root.left, value)
        else:
            return self.__findNode(root.right, value)

    def findMin(self, root):
        if root.left == None:
            return root.data
        self.findMin(root.left)

    def findMax(self, root):
        if root.right == None:
            return root.data
        self.findMax(root.right)

    def preorder(self, root):
        if root != None:
            yield root.data
            for i in self.preorder(root.left):
                yield i
            for i in self.preorder(root.right):
                yield i

    def postorder(self, root):
        if root != None:
            for i in self.postorder(root.left):
                yield i
            for i in self.postorder(root.right):
                yield i
            yield root.data

    def inorder(self, root):
        if root != None:
            for i in self.inorder(root.left):
                yield i
            yield root.data
            for i in self.inorder(root.right):
                yield i
    def delete(self, data):
        root = self.__findNode(self.root, data)

        if self.__contains__(root,data):

            if root.left == None and root.right == None:
                if root.parent.data < root.data:
                    root.parent.right = None
                else:
                    root.parent.left = None
            elif root.left == None and root.right != None:
                if root.data > root.parent.data:
                    root.parent.right = root.right
                    root.right.parent = root.parent
                else:
                    root.parent.left = root.right
                    root.right.parent = root.parent
            elif root.left != None and root.right == None:
                if root.data > root.parent.data:
                    root.parent.right = root.left
                    root.left.parent = root.parent
                else:
                    root.parent.left = root.left
                    root.left.parent = root.parent
            else:




