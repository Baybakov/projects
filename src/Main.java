import java.io.IOException;
import java.util.ArrayList;

interface Node1{
    public void addLeft(int v);
    public void addRight(int v);
    public void deleteLeft();
    public void deleteRight();
    public Node1 stepLeft();
    public Node1 stepRight();
    public Node1 stepUp();
    public Node1 stepRoot();
    public Boolean findName(String s);
    public Boolean findValue(int v);
    public void writeValue();
    public void getValue(ArrayList<Integer> a);
    public void setValue(ArrayList<Integer> a);
    public void balanced();
}

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryTree tree = new BinaryTree();
    }
}
