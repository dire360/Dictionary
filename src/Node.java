// Dylan Wilson

public class Node {
    String key; // key used for binary search tree
    String firstName, lastName, address, city, state, zip, email, phone;
    Node left;
    Node right;

    public Node (String key, String firstName, String lastName, String address, String city, String state, String zip, String email, String phone){
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
        this.left = null;
        this.right = null;
    }
}
