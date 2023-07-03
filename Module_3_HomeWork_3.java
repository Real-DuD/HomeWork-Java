public class Module_3_HomeWork_3 {
    static class MyBinaryTree<K, V>{
        private class Node {
            private Node left = null;
            private Node right = null;
            private K Key;
            private V Value;
            public Node(K Key, V Value) {
                this.Key = Key;
                this.Value = Value;
                this.left = this.right = null;
            }
            public Node(Node left) {
                this.left = left;
            }
        }
        private int size = 0;
        private Node root;
        public Node GetNode(Object key) {
            Node curNode = root;
            Comparable<K> cKey = (Comparable<K>) key;
            while (curNode != null) {
                int cmp = cKey.compareTo(curNode.Key);
                if (cmp < 0) {
                    curNode = curNode.left;
                }
                if (cmp > 0) {
                    curNode = curNode.right;
                }
                if (cmp == 0) {
                    return curNode;
                }
            }
            return null;
        }

        public V Get(Object key) {
            Node curNode = GetNode(key);
            if(curNode == null) {
                return null;
            }
            return curNode.Value;
        }

        public V Put(K key, V value) {
            if (root == null) {
                root = new Node(key, value);
                size++;
                return null;
            }
            return PutHelper(key, value, root);

        }

        private V PutHelper(K key, V value, Node node) {
            Comparable<K> cKey = (Comparable<K>) key;
            int cmp = cKey.compareTo(node.Key);
            if (cmp < 0) {
                if (node.left == null) {
                    node.left = new Node(key, value);
                    size++;
                    return null;
                }
                return PutHelper(key, value, node.left);
            }
            if (cmp > 0) {
                if (node.right == null) {
                    node.right = new Node(key, value);
                    size++;
                    return null;
                }
                return PutHelper(key, value, node.right);
            }
            if (cmp == 0) {
                V oldValue = node.Value;
                node.Value = value;
                return oldValue;
            }
            return null;
        }

        public  void PrintTree() {
            if (root == null) {
                System.out.println("The tree is empty");
            }
            System.out.println("The root is " + root.Value);
            LER(root);
        }

        private void LER(Node node) {
            if (node.left != null) {
                LER(node.left);
            }
            System.out.println(node.Value);
            if (node.right != null) {
                LER(node.right);
            }
        }

        private Node GetParent(Object key){
            Comparable<K> cKey = (Comparable<K>) key;
            Node child = root;
            Node parent = root;
            while (child != null) {
                int cmp = cKey.compareTo(child.Key);
                if (cmp < 0) {
                    parent = child;
                    child = child.left;
                }
                if (cmp > 0) {
                    parent = child;
                    child = child.right;
                }
                if (cmp == 0) {
                    return parent;
                }
            }
            return null;
        }
        public V Remove(Object key) {
            Node child = GetNode(key);
            if (child == null) {
                return null;
            }
            if (size == 1) {
                root = null;
                size--;
                return child.Value;
            }
            Node parent = GetParent(key);
            if (child.left != null && child.right != null) {
                Node successor = GetSuccessor(child.right);
                Node succParent = GetParent(successor.Key);
                RemoveHelper(successor, succParent);
                child.Key = successor.Key;
                V oldValue = child.Value;
                child.Value = successor.Value;
                return oldValue;
            } else if (child == root) {
                if (child.left != null) {
                    root = child.left;
                }
                if (child.right != null) {
                    root = child.right;
                }
                size--;
                return child.Value;
            } else {
                return RemoveHelper(child, parent);
            }


        }
        private Node GetSuccessor(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        private V RemoveHelper(Node child, Node parent) {
            if (child.left == null && child.right == null) {
                if (parent.left == child){
                    parent.left = null;
                }
                if (parent.right == child){
                    parent.right = null;
                }
                size--;
                return child.Value;
            }
            if (child.left == null) {
                if (parent.left == child){
                    parent.left = child.right;
                }
                if (parent.right == child){
                    parent.right = child.right;
                }
                size--;
                return child.Value;
            }
            if (child.right == null) {
                if (parent.left == child){
                    parent.left = child.left;
                }
                if (parent.right == child){
                    parent.right = child.left;
                }
                size--;
                return child.Value;
            }
            return null;
        }
    }
}