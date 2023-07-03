public class Module_3_HomeWork_4 {
    static class MyBinaryTree_<K> {
        private class Node {
            private Node left = null;
            private Node right = null;
            private K Key;
            public Node(K Key) {
                this.Key = Key;
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
        public boolean Contains(Object key) {
            Node curNode = GetNode(key);
            if (curNode == null) {
                return false;
            }
            return true;
        }
        public K Add(K key) {
            if (root == null) {
                root = new Node(key);
                size++;
                return null;
            }
            return AddHelper(key, root);
        }
        private K AddHelper(K key, Node node) {
            Comparable<K> cKey = (Comparable<K>) key;
            int cmp = cKey.compareTo(node.Key);
            if (cmp < 0) {
                if (node.left == null) {
                    node.left = new Node(key);
                    size++;
                    return null;
                }
                return AddHelper(key, node.left);
            }
            if (cmp > 0) {
                if (node.right == null) {
                    node.right = new Node(key);
                    size++;
                    return null;
                }
                return AddHelper(key, node.right);
            }
            if (cmp == 0) {
                K oldKey = node.Key;
                node.Key = key;
                return oldKey;
            }
            return null;
        }
        public void PrintTree() {
            if (root == null) {
                System.out.println("The tree is empty");
            }
            System.out.println("The root is " + root.Key);
            LER(root);
        }
        private void LER(Node node) {
            if (node.left != null) {
                LER(node.left);
            }
            System.out.println(node.Key);
            if (node.right != null) {
                LER(node.right);
            }
        }
        private Node GetParent(Object key) {
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
        public boolean Remove(Object key) {
            Node child = GetNode(key);
            if (child == null) {
                return false;
            }
            if (size == 1) {
                root = null;
                size = 0;
                return true;
            }
            Node parent = GetParent(key);
            if (child.left != null && child.right != null) {
                Node successor = GetSuccessor(child.right);
                Node succParent = GetParent(successor.Key);
                RemoveHelper(successor, succParent);
                child.Key = successor.Key;
                return true;
            } else if (child == root) {
                if (child.left != null) {
                    root = child.left;
                }
                if (child.right != null) {
                    root = child.right;
                }
                size--;
                return true;
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
        private boolean RemoveHelper(Node child, Node parent) {
            if (child.left == null && child.right == null) {
                if (parent.left == child) {
                    parent.left = null;
                }
                if (parent.right == child) {
                    parent.right = null;
                }
                size--;
                return true;
            }
            if (child.left == null) {
                if (parent.left == child) {
                    parent.left = child.right;
                }
                if (parent.right == child) {
                    parent.right = child.right;
                }
                size--;
                return true;
            }
            if (child.right == null) {
                if (parent.left == child) {
                    parent.left = child.left;
                }
                if (parent.right == child) {
                    parent.right = child.left;
                }
                size--;
                return true;
            }
            return false;
        }
    }
}