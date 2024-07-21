import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search a key
    public TreeNode search(int key) {
        return searchRec(root, key);
    }

    private TreeNode searchRec(TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key < key) {
            return searchRec(root.right, key);
        }
        return searchRec(root.left, key);
    }

    // Pre-order traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // In-order traversal
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // Post-order traversal
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.key + " ");
        }
    }

    // Level-order traversal (BFS)
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.key + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // Find the minimum key
    public TreeNode findMin() {
        return findMinRec(root);
    }

    private TreeNode findMinRec(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMinRec(root.left);
    }

    // Find the maximum key
    public TreeNode findMax() {
        return findMaxRec(root);
    }

    private TreeNode findMaxRec(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findMaxRec(root.right);
    }

    // Delete a leaf node
    public void deleteLeafNode(int key) {
        root = deleteLeafNodeRec(root, key);
    }

    private TreeNode deleteLeafNodeRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteLeafNodeRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteLeafNodeRec(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
        }
        return root;
    }

    // Delete a node with one child
    public void deleteNodeWithOneChild(int key) {
        root = deleteNodeWithOneChildRec(root, key);
    }

    private TreeNode deleteNodeWithOneChildRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteNodeWithOneChildRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNodeWithOneChildRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
        }
        return root;
    }

    // Delete a node with two children
    public void deleteNodeWithTwoChildren(int key) {
        root = deleteNodeWithTwoChildrenRec(root, key);
    }

    private TreeNode deleteNodeWithTwoChildrenRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteNodeWithTwoChildrenRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNodeWithTwoChildrenRec(root.right, key);
        } else {
            root.key = findMinRec(root.right).key;
            root.right = deleteNodeWithTwoChildrenRec(root.right, root.key);
        }
        return root;
    }
}

public class BST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice, key;

        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete Leaf Node");
            System.out.println("3. Delete Node with One Child");
            System.out.println("4. Delete Node with Two Children");
            System.out.println("5. Search");
            System.out.println("6. Find Minimum");
            System.out.println("7. Find Maximum");
            System.out.println("8. Pre-order Traversal");
            System.out.println("9. In-order Traversal");
            System.out.println("10. Post-order Traversal");
            System.out.println("11. Level-order Traversal");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = scanner.nextInt();
                    bst.insert(key);
                    break;
                case 2:
                    System.out.print("Enter key of leaf node to delete: ");
                    key = scanner.nextInt();
                    bst.deleteLeafNode(key);
                    break;
                case 3:
                    System.out.print("Enter key of node with one child to delete: ");
                    key = scanner.nextInt();
                    bst.deleteNodeWithOneChild(key);
                    break;
                case 4:
                    System.out.print("Enter key of node with two children to delete: ");
                    key = scanner.nextInt();
                    bst.deleteNodeWithTwoChildren(key);
                    break;
                case 5:
                    System.out.print("Enter key to search: ");
                    key = scanner.nextInt();
                    TreeNode result = bst.search(key);
                    if (result != null) {
                        System.out.println("Key found: " + result.key);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 6:
                    TreeNode min = bst.findMin();
                    System.out.println("Minimum key: " + min.key);
                    break;
                case 7:
                    TreeNode max = bst.findMax();
                    System.out.println("Maximum key: " + max.key);
                    break;
                case 8:
                    System.out.println("Pre-order Traversal:");
                    bst.preOrder();
                    break;
                case 9:
                    System.out.println("In-order Traversal:");
                    bst.inOrder();
                    break;
                case 10:
                    System.out.println("Post-order Traversal:");
                    bst.postOrder();
                    break;
                case 11:
                    System.out.println("Level-order Traversal:");
                    bst.levelOrderTraversal();
                    break;
                case 12:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}