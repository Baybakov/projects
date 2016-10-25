import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Node implements Node1{
    private Node left;
    private Node right;
    private Node parent;
    private String name;
    private int value;
    public Node(int v){
        value = v;
        name = "";
    }
    public void addLeft(int v){
        left = new Node(v);
        left.parent = this;
        left.name = name + "0";
    }
    public void addRight(int v){
        right = new Node(v);
        right.parent = this;
        right.name = name + "1";
    }
    public void deleteLeft(){
        left = null;
    }
    public void deleteRight(){
        right = null;
    }
    public Node stepLeft(){
        if(left != null) return left;
        return this;
    }
    public Node stepRight(){
        if(right != null) return right;
        return this;
    }
    public Node stepUp(){
        if(parent == null) return this;
        return parent;
    }
    public Node stepRoot(){
        Node node = this;
        while(node.parent != null) node = node.parent;
        return node;
    }
    public Boolean findName(String s){
        int cnt = 0;
        for(int i = 0; i < Math.min(s.length(), name.length()); i++){
            if(s.charAt(i) == (name.charAt(i))) cnt++;
            else break;
        }
        Node node = this;
        for(int i = 0; i < cnt; i++){
            if(node.parent != null) node = node.parent;
            else return false;
        }
        while(cnt < s.length()){
            if(s.charAt(cnt) == '0'){
                if(node.left != null) node = node.left;
                else return false;
            }
            else{
                if(node.right != null) node = node.right;
                else return false;
            }
            cnt++;
        }
        return true;
    }
    public Boolean findValue(int v){
        if(this.value == v) return true;
        if(v < this.value && left != null) return left.findValue(v);
        if(v > this.value && right != null) return right.findValue(v);
        return false;
    }
    public void writeValue(){
        if (left != null){
            left.writeValue();
        }
        System.out.print(this.value + " ");
        if (right != null){
            right.writeValue();
        }
    }
    public void getValue(ArrayList<Integer> a){
        if (left != null){
            left.getValue(a);
        }
        a.add(this.value);
        if (right != null){
            right.getValue(a);
        }
    }
    public void setValue(ArrayList<Integer> a){
        if (right != null){
            right.setValue(a);
        }
        this.value = a.get(a.size() - 1);
        a.remove(a.size() - 1);
        if (left != null){
            left.setValue(a);
        }
    }
    public void balanced(){
        ArrayList<Integer> a = new ArrayList<Integer>();
        this.getValue(a);
        Collections.sort(a,
                new Comparator<Integer>(){
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );
        this.setValue(a);
    }
}
