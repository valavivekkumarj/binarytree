
public class height_Of_BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class tree {
        // height of tree find
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int leftheight = height(root.left);
            int righthight = height(root.right);

            return Math.max(leftheight, righthight) + 1;
        }

        // ================================================================
        // count node in given binarytree
        public static int countnode(Node root) {
            if (root == null) {
                return 0;
            }

            int leftnode = countnode(root.left);
            int rightnode = countnode(root.right);

            return leftnode + rightnode + 1;
        }

        // ==========================================================================
        // sum of all node in binary tree
        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }

            int leftnodesum = sum(root.left);
            int rightnodesum = sum(root.right);

            return leftnodesum + rightnodesum + root.data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        tree t = new tree();
        int heightoftree = t.height(root);
        System.out.println("height of tree or level of tree  ==  " + heightoftree);
        System.out.println("count of total node ==>>  " + t.countnode(root));
        System.out.println("+===============================================");
        System.out.println("sum of all node ===>  " + t.sum(root));
    }
}
