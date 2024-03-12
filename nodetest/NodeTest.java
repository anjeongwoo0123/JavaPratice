package nodetest;
import java.util.*;
public class NodeTest {
    public static void main(String args[]){
        LinkedList list = new LinkedList();

        list.addFirst(25);
        list.addList(15);
        list.addList(35);
        list.addList(21);
        list.addList(7);
        list.addList(23);
        list.removeFirst();
        list.middleadd(2, 34);
    
       list.PrintNode(); //printNode 공부하기
    }
}
