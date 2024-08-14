package Queues;


public class AnimalShelter {
    QueueArray<Dog> dogs = new QueueArray<>(5);
    QueueArray<Cat> cats = new QueueArray<>(5);
    int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogs.enQueue((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.enQueue((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return cats.deQueue();
        } else if (cats.isEmpty()) {
            return dogs.deQueue();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dogs.deQueue();
        } else {
            return cats.deQueue();
        }
    }

    public Dog dequeueDog() {
        return dogs.deQueue();
    }

    public Cat dequeueCat() {
        return cats.deQueue();
    }
}

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class QueueArray<T extends Animal> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueArray(int capacity) {
        queue = (T[]) new Animal[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enQueue(T animal) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = animal;
        size++;
    }

    public T deQueue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T animal = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return animal;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}