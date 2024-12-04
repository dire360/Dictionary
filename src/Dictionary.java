// Dylan Wilson

public class Dictionary {

    Node root;
    
    public Dictionary() {
        root = null;
    }

    // add method for adding an entry into the dictionary string key is used for primary key
    public void add(String key, String firstName, String lastName, String address, String city, String state, String zip, String email, String phone){
        Node newNode = new Node (key, firstName, lastName, address, city, state, zip, email, phone);
        // if root is not empty add data 
        if (root == null) {
            root = newNode;
            System.out.println("added");
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                System.out.println("key aready exists, can not add.");
                return;
            }
        }

        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        
        System.out.println("added");
    } // end add method

    // delete method case 2
    public void delete(String key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, String key) {
        if (root == null) {
            System.out.println("key not found");
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                System.out.println("Deleted");
                return root.right;
            }
            if (root.right == null) {
                System.out.println("Deleted");
                return root.left;
            }

            // Node with 2 children, find the smallest in subtree to replace.
            root.key = findMin(root.right).key;
            root.right = deleteRec(root.right, root.key);
            System.out.println("Deleted");
        }
        return root;
    }

    // find min used for finding the smallest of 2 leaf nodes
    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    // modify method case 3
    public void modify(String Key, String field, String newValue) {
        Node node = search(root, Key);
        if (node != null) {
            switch (field) {
                case "firstname":
                    node.firstName = newValue;
                    break;
                case "lastname":
                    node.lastName = newValue;
                    break;
                case "address":
                    node.address = newValue;
                    break;
                case "city":
                    node.city = newValue;
                    break;
                case "state":
                    node.state = newValue;
                    break;
                case "zip":
                    node.zip = newValue;
                    break;
                case "email":
                    node.email = newValue;
                    break;
                case "phone":
                    node.phone = newValue;
                    break;
                default: System.out.println("input not valid");
            }
            System.out.println("Modified");
        } else {
            System.out.println("key not found");
        }
    }

    // search method case 4
    public Node search(Node root, String key) {
        if (root == null || root.key.equals(key)) {
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    // print method case 5
    public void printPreOrder(Node node) {
        if (node != null) {
            printNode(node);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printInOrder (Node node) {
        if (node != null) {
            printInOrder(node.left);
            printNode(node);
            printInOrder(node.right);
        }
    }

    public void printPostOrder (Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            printNode(node);
        }
    }

    public void printNode (Node node) {
        System.out.printf("Key: %s, Name: %s %s, Address: %s, %s, %s %s, Email: %s, Phone: %s%n",
          node.key, node.firstName, node.lastName, node.address, node.city, node.state, node.zip, node.email, node.phone);
    }
    // Getter for root public
    public Node getRoot() {
        return root;
    }

}


