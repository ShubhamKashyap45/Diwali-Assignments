class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    CircularQueue(int cap) {
        capacity = cap;
        queue = new int[cap];
        front = rear = size = 0;
    }

    boolean isFull() { return size == capacity; }
    boolean isEmpty() { return size == 0; }

    void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue full");
            return;
        }
        queue[rear] = val;
        rear = (rear + 1) % capacity;
        size++;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return;
        }
        front = (front + 1) % capacity;
        size--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return;
        }
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}
