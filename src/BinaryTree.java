import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTree {
    public BinaryTree() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.help();
        Boolean ok = false;
        Node node = new Node(0);
        for(;;){
            String s = reader.readLine();
            if(s.length() >= 4 && s.substring(0, 4).equals("new ")){
                int v = Integer.parseInt(s.substring(4));
                node = new Node(v);
                ok = true;
                System.out.println("Дерево создано!");
            }
            else if(s.equals("exit")) break;
            else if(s.equals("help")) this.help();
            else if(!ok){
                System.out.println("Дерево ещё не создано! Неверная команда!");
            }
            else if(s.length() >= 6 && s.substring(0, 6).equals("add l ")){
                int v = Integer.parseInt(s.substring(6));
                node.addLeft(v);
                System.out.println("Левый узел добавлен!");
            }
            else if(s.length() >= 6 && s.substring(0, 6).equals("add r ")){
                int v = Integer.parseInt(s.substring(6));
                node.addRight(v);
                System.out.println("Правый узел добавлен!");
            }
            else if(s.equals("del l")){
                node.deleteLeft();
                System.out.println("Левый узел удален!");
            }
            else if(s.equals("del r")){
                node.deleteRight();
                System.out.println("Правый узел удален!");
            }
            else if(s.equals("step l")){
                node = node.stepLeft();
                System.out.println("Переход влево выполнен!");
            }
            else if(s.equals("step r")){
                node = node.stepRight();
                System.out.println("Переход вправо выполнен!");
            }
            else if(s.equals("step u")){
                node = node.stepUp();
                System.out.println("Переход вверх выполнен!");
            }
            else if(s.equals("step root")){
                node = node.stepRoot();
                System.out.println("Переход к корню выполнен!");
            }
            else if(s.length() >= 6 && s.substring(0, 6).equals("findn ")){
                String t = s.substring(6);
                if(node.findName(t)) System.out.println("Узел с именем " + t + " найден!");
                else System.out.println("Узел с именем " + t + " не найден!");
            }
            else if(s.length() >= 6 && s.substring(0, 6).equals("findv ")){
                int v = Integer.parseInt(s.substring(6));
                if(node.findValue(v)) System.out.println("Узел в текущем поддереве со значением " + v + " найден!");
                else System.out.println("Узел в текущем поддереве со значением " + v + " не найден!");
            }
            else if(s.equals("write")){
                node.writeValue();
                System.out.println();
            }
            else if(s.equals("balanced")){
                node.balanced();
                System.out.println("Текущее поддерево сбалансированно по значениям!");
            }
            else{
                System.out.println("Комманда введена неверно!");
            }
        }
    }
    public void help(){
        System.out.println("Управление:");
        System.out.println("new value - создание нового дерева со значением value в корне");
        System.out.println("add l value - добавить левый узел со значением value");
        System.out.println("add r value - добавить правый узел со значением value");
        System.out.println("del l - удалить левый узел");
        System.out.println("del r - удалить правый узел");
        System.out.println("step l - перейти к левому узлу");
        System.out.println("step r - перейти к правому узлу");
        System.out.println("step u - перейти к узлу-родителю");
        System.out.println("step root - перейти к корню дерева");
        System.out.println("findn name - найти узел с именем name");
        System.out.println("findv value - найти узел со значением value в бинарном поддереве с корнем в текущем узле");
        System.out.println("write - вывести все значение поддерева с корнем в текущем узле");
        System.out.println("balanced - балансировка значений поддерева с корнем в текущем узле");
        System.out.println("exit - выход из программы");
        System.out.println("help - вывод справки");
    }
}
