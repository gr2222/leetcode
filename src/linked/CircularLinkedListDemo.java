package linked;

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        CircularLinked a = new CircularLinked(1, "a");
        CircularLinked b = new CircularLinked(2, "b");
        CircularLinked c = new CircularLinked(3, "c");
        CircularLinked d = new CircularLinked(4, "d");
        list.add(a);
        list.add(c);
        list.add(d);
        list.add(b);
        list.show();
        list.show();
    }
}

class CircularLinkedList {
    CircularLinked frist;

    public void add(CircularLinked circularLinked) {
        if (frist == null) {
            frist = circularLinked;
            frist.next = frist;
        } else {
            CircularLinked temp = frist;
            while (true) {
                if (frist == null || temp.next == frist) {
                    circularLinked.next = frist;
                    temp.next = circularLinked;
                    break;
                } else if (circularLinked.id == temp.next.id) {
                    System.out.println("节点id重复");
                    break;
                } else if (temp.next.id > circularLinked.id) {
                    circularLinked.next = temp.next;
                    temp.next = circularLinked;
                    break;
                }
                temp = temp.next;
            }
        }
    }



    public void show() {
        CircularLinked temp = frist;
        while (true) {
            if (temp.next == frist) {
                System.out.println(temp);
                break;
            } else {
                System.out.println(temp);
            }
            temp = temp.next;
        }
    }

}

class CircularLinked {
    public int id;
    public String name;
    CircularLinked next;

    public CircularLinked(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CircularLinked() {
    }

    @Override
    public String toString() {
        return "CircularLinked{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
