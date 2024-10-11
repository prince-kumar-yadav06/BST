   class Solution {
     Node nextright = null;

    public void populateNext(Node root) {
        // Base case
        if (root == null) {
            return;
        }

        // First process the right child
        populateNext(root.right);

        // Assign the next right node
        root.next = nextright;

        // Update the next right node to the current root
        nextright = root;

        // Finally process the left child
        populateNext(root.left);
    }

}
