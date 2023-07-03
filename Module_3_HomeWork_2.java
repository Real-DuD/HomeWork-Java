public class Module_3_HomeWork_2 {
    public static class MyLinkedList<T> {

        private class Node {
            public T element;

            public Node next;

            public Node(T element) {
                this.element = element;
                this.next = null;
            }

            public Node(T element, Node next) {
                this.element = element;
                this.next = next;
            }

            @Override
            public String toString() {
                return element.toString();
            }
        }

        private int size;

        private Node head;

        public MyLinkedList() {
            this.size = 0;
            this.head = null;
        }

        private Node GetNode(int index) {
            if (index < -1 || index > size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }

        public boolean Add(T element) {
            if (head == null) {
                head = new Node(element);
                size++;
                return true;
            }
            Node currentNode = head;
            for (; currentNode.next != null; currentNode = currentNode.next) {
            }
            currentNode.next = new Node(element);
            size++;
            return true;
        }

        public boolean Add(int index, T element) {
            if (index == size + 1) {
                Add(element);
                return true;
            }
            if (index < 0 || index > size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (head == null) {
                head = new Node(element);
                size++;
                return true;
            }
            Node currentNode = GetNode(index - 1);
            Node newNode = new Node(element);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
            return true;
        }

        public int IndexOf(T element) {
            int index = 0;
            Node currentNode = head;
            for (; currentNode.element != element; currentNode = currentNode.next) {
                index++;
            }
            return index;
        }

        public Node remove(int index) {
            if (index < 0 || index > size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (index == size) {
                Node currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                Node returnNode = currentNode.next;
                currentNode.next = null;
                size--;
                return returnNode;
            }
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            Node returnNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            size--;
            return returnNode;
        }

        public int remove(T element) {
            int index = IndexOf(element);
            remove(index);
            return index;
        }

        @Override
        public String toString() {
            if (head == null) {
                return "";
            }
            Node currentNode = head;
            String res = "";
            for (; currentNode.next != null; currentNode = currentNode.next) {
                res += currentNode.toString() + " ";
            }
            return res + currentNode.toString();
        }
    }


    public static void main(String[] args) {
        MyLinkedList MyList = new MyLinkedList();
        MyList.Add("1");
        MyList.Add("1");
        MyList.Add("2");
        MyList.Add("3");
        MyList.Add("5");
        System.out.println(MyList.toString());
        MyList.Add(5, "8");
        MyList.Add(6, "13");
        MyList.Add(7,"21");
        MyList.Add(8,"34");
        MyList.Add(9,"55");
        System.out.println(MyList.toString());
        MyList.remove(0);
        MyList.remove(1);
        System.out.println(MyList.toString());
        MyList.Add(0, "1");
        MyList.Add(2, "2");
        System.out.println(MyList.toString());
        MyList.remove("3");
        MyList.remove("8");
        System.out.println(MyList.toString());
        MyList.Add(3, "3");
        MyList.Add(5, "8");
        System.out.println(MyList.toString());
    }
}