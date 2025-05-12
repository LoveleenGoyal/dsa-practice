import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {

    /*
    
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {

        LinkedList<Node>list = new LinkedList<>();
        LinkedList<Integer>level = new LinkedList<>();
        Map<Integer,Integer>nodeMap = new TreeMap<>();

        list.add(root);
        level.add(0);

        while(!list.isEmpty()){
            Node curr = list.poll();
            int curr_Level = level.poll();

            if(!nodeMap.containsKey(curr_Level)){
                nodeMap.put(curr_Level,curr.data);
            }

            if(curr.left != null){
                list.add(curr.left);
                level.add(curr_Level-1);

            }
            if(curr.right != null){
                list.add(curr.right);
                level.add(curr_Level+1);
            }

        }

        for(Map.Entry<Integer,Integer>entry:nodeMap.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}