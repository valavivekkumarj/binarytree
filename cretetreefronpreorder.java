import java.util.LinkedList;
import java.util.Queue;

public class cretetreefronpreorder {

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

    // tree class
    static class tree {
        static int index = -1;

        // tree implement method
        public static Node buildTree(int nodes[]) {

            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newnode = new Node(nodes[index]);
            newnode.left = buildTree(nodes);
            newnode.right = buildTree(nodes);

            return newnode;
        }
    }
    // ===================================================================

    // get the node data in preorder from the given tree

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    // =================================================

    // get the node data in inorder from the given tree

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    // ===============================================================

    // // get the node data in postorder from the given tree

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    // level order traversal BFS traversal
    public static void bfsLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node current = q.remove();

            if (current == null) {
                System.out.println();

                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(current.data);
                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }

    // =========================================================================
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        tree t = new tree();
        Node root = t.buildTree(nodes);
        System.out.println(root.data);

        System.out.println("========================================");
        System.out.println("preorder");
        preorder(root);
        System.out.println("===============");
        System.out.println("inprder");
        inorder(root);
        System.out.println("postorder");
        postorder(root);

        System.out.println("bfs ==> level order traversal");
        bfsLevelOrder(root);
    }
}