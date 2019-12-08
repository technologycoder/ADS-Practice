package practice.ds.tree;

public class BinarySearchTree extends BinaryTree {
    public void insert(int[] data) {

        for (int i = 0; i < data.length; ++i) {

            insert(data[i]);
        }

    }

    public boolean exists(int data) {

        return exists(root, data);

    }

    private boolean exists(Node node, int data) {

        if (node != null) {
            if (node.data == data) {
                return true;
            } else if (node.data > data) {
                return exists(node.left, data);
            } else if (node.data < data) {
                return exists(node.right, data);
            }
        }
        return false;

    }

    public int findMin(Node node) {

        int min = -1;

        if (node != null) {
            min = node.data;
        }

        Node iter = node;

        while (iter != null) {
            if (iter.data < min) {
                min = iter.data;
            }
            iter = iter.left;
        }

        return min;

    }

    public int findMinRecursive(Node node) {

        if (node.left == null) {
            return node.data;
        } else {
            return findMinRecursive(node.left);
        }
    }

    public boolean delete(int data) {

        return this.delete(root, data);
    }

    public boolean delete(Node node, int data) {

        Node iter = node;

        Node parent = null;

        while (iter != null) {

            if (iter.data == data) {

                // node with no children
                if (iter.left == null && iter.right == null) {

                    if (parent == null) {
                        root = null;

                    } else if (parent.left != null && parent.left.data == data) {

                        parent.left = null;

                    } else if (parent.right != null && parent.right.data == data) {

                        parent.right = null;
                    }
                } else if (iter.left != null && iter.right != null) {
                    // node with both children present

                    int min = this.findMin(iter.right);

                    boolean success = this.delete(min);
                    if (!success) {
                        System.out.println(String.format("Not able to delete %s from right sub tree", min));
                    }

                    iter.data = min;

                } else if (iter.left != null) { // node with left child

                    if (parent == null) {
                        root = iter.left;
                    } else if (parent.left != null && parent.left.data == data) {

                        parent.left = iter.left;

                    } else if (parent.right != null && parent.right.data == data) {

                        parent.right = iter.left;
                    }

                } else if (iter.right != null) { // node with right child

                    if (parent == null) {
                        root = iter.right;

                    } else if (parent.left != null && parent.left.data == data) {

                        parent.left = iter.right;

                    } else if (parent.right != null && parent.right.data == data) {

                        parent.right = iter.right;
                    }

                }

                return true;

            } else if (iter.data > data) {
                parent = iter;
                iter = iter.left;
            } else if (iter.data < data) {
                parent = iter;
                iter = iter.right;
            }
        }

        return false;

    }

    @Override
    public void insert(int data) {

        if (root == null) {
            root = new Node(data);
        } else {
            insert(root, data);
        }

    }

    private void insert(Node node, int data) {

        if (node != null) {

            if (node.data >= data) {

                if (node.left == null) {
                    node.left = new Node(data);
                } else {
                    insert(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(data);
                } else {
                    insert(node.right, data);
                }

            }

        }

    }

}
