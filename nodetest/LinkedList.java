package nodetest;

import java.util.*;

public class LinkedList {
    private Node head; //노드의 머리부분 , 처음
    private Node tail; //노드의 꼬리부분 , 마지막
    private int size = 0; //초기 노드의 크기

    private class Node{
        private Object data; // 노드의 값(데이터)가 저장
        private Node next; //다음 노드를 연결

        public Node(Object input){ //생성자, 자료를 받아서 생성
            this.data = input; //노드안에 데이터는 input이 됨
            this.next = null; // 다음 
        }
    
        public String toString(){ //노드의 내용 출력
            return String.valueOf(this.data);
        }  
    }
    /*public class ListIterator{
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        LisrIterator() {
            next = head;
            nextIndex = 0;
        }
    
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
    }
    public ListIterator listIterator() {
        return new ListIterator();
    }*/

   
    public void addFirst(Object input){ //맨 앞에 노드 추가
        Node newNode = new Node(input); //노드 생성
        newNode.next = head; // 원래 head노드가 새 노드의 다음으로 감
        head = newNode; // 새로운 노드는 맨 앞에 노드가 됨
        size++; //노드를 추가했으니 사이즈 +1
        if(head.next == null){ //새 노드 말고 다른 노드가 없을 경우
            tail = head; //처음와 끝은 같은 노드
        }
    }

    public void addList(Object input){
        Node newNode = new Node(input);
        if(size == 0){
            addFirst(input);
        }
        else{
            tail.next = newNode; // 새 노드를 원래 있던 마지막 노드의 다음으로 
            tail= newNode; //새 노드를 마지막 노드로 설정
            size++; // 사이즈 +1
        }
    }

    public Node node(int index){ //찾고싶은 노드의 인덱스를 입력
            Node x = head; //처음부터  
            for(int i = 0; i < index; i++){//찾으려는 index 값까지 반복
                x = x.next; //반복하면서 노드 이동
            }
            return x; //찾은 노드를 리턴
        }
    

    public void middleadd(int k, Object input){
         if(k == 0){ //인덱스가 0,처음에 넣는 상황이면 addFirst 메소드 사용
            addFirst(input);
         }
        else{// 1-3-5-7 에서 2번째에 2라는 값을 넣고 싶으면 1을 임시노드로, 3을 임시노드로 설정 후 2를 사이에 놓고 다시 연결해줌
            Node temp1 = node(k-1); //인덱스 앞에 있던 노드를 임시 노드로
            Node temp2 = temp1.next; //임시노드 다음노드를 임시 노드2로

            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;

            if(newNode.next == null){ //새 노드 삽입전에 원래 있던 노드가 1개인 경우에
                tail = newNode; // 꼬리노드는 새로 만든 노드
            }
        }
    }

    public String toString(){
         if(head == null){
            return "-1"; //아무 노드가 없으면 -1 리턴
        }

        Node temp = head;
        String str = " ";

        while (temp.next != null) { //처음노드부터 끝 노드까지
            str += temp.data +", "; //노드의 데이터를 계속 저장
            temp = temp.next; //마지막 노드까지 이동             
        }
        str += temp.data; //마지막 노드의 데이터까지 str에 저장
        return str; //저장된 문자열 리턴
    }

    public Object removeFirst(){ //void로 만들어서 삭제만 해도 되나 삭제한 데이터를 리턴을 해보기로함
        Node temp = head; //헤드 노드를 임시노드로
        head = head.next; //헤드 노드를 헤드 다음노드로 연결, 2번째 노드가 1번째로

        Object returnData = temp.data; //삭제한 헤드 노드의 데이터
        temp = null; // 임시 데이터 비우기
        size--; // 삭제했으니 사이즈 -1
        return returnData; //삭제한 데이터를 리턴
    }
        
    public Object remove(int k){ //헤드와 테일 외의 노드 삭제
        if(k==0){
            return removeFirst();
        }
        Node temp = node(k-1);
        Node Deleted = temp.next;

        temp.next = temp.next.next;
        Object returnData = Deleted.data;

        if(Deleted == tail){ //삭제하려는 값이 맨 뒤라면
            tail = temp; // node(k-1),삭제하려는 노드의 앞 노드를 꼬리로 설정
        }
        Deleted = null;
        size--;
        return returnData;
    }

    public int size(){
        return size;
    }

    public int indexOf(Object data){ //원하는 데이터를 입력하면 인덱스를 알려줌
        Node temp = head; 
        int index = 0;

        while(temp.data != data){//노드의 데이터가 내가 원하는 데이터일 때 까지
            temp = temp.next; //다음 노드로 옮김
            index ++; //인덱스를 증가시키기
        }

        if(temp == null){ //찾는 데이터가 없으면 -1 리턴
            return -1;
        }
        return index; //알고싶은 인덱스 리턴
    }
    public void PrintNode(){ //기본적인 for문 출력
        for(int i = 0; i < size ; i++){
            System.out.print(node(i).data + " ");
        }
    }


    /*public boolean hasNext(){
        return next.Index < size();
    }*/

}   
