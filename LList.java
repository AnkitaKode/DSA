 class LList {

    Node head;
    
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }   
    }

    public void addFirst(String data){
        Node newNode=new Node(data);
        
        if(head==null){
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void addLast(String data){
        Node newNode=new Node(data);

        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }

        curr.next=newNode;

    }

    public void printList(){
        Node currNode=head;
        while(currNode.next!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
    }

    public static void main(String[] args) {
        LList list=new LList();
        list.addFirst("Hello");
        list.addLast("Java");
        list.addFirst("World");
        list.addLast("Java8");
        list.printList();
    }
    
}
