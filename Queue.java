public class Queue {
    int queue[] = new int[5];
    int size;
    int front;
    int rear;

    public void enqueue(int data) {
        queue[rear] = data;
        rear = (rear + 1) % 5; 
        size++;
    }

    public void dequeue(){
        front = (front + 1) % 5; 
        size--;
    }

    public void show(){
        System.out.println("Elements: ");
        for(int i = 0; i < size; i++){
            System.out.print(queue[(front + i) % 5] + " ");
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(9);
        q.enqueue(7);

        q.dequeue();
        q.dequeue();

        q.enqueue(1);
        q.enqueue(8);

        System.out.println(q.isEmpty());
        System.out.println("Size: " + q.getSize());
        q.show();
    }
}
