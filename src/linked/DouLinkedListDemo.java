package linked;

public class DouLinkedListDemo {
    public static void main(String[] args) {
        DouLinkedList list = new DouLinkedList();
        DouLinked a = new DouLinked(1, "a");
        DouLinked b = new DouLinked(2, "b");
        DouLinked c = new DouLinked(3, "c");
        DouLinked d = new DouLinked(4, "d");
        DouLinked c1 = new DouLinked(3, "x");

        list.add(c);
        list.add(b);
        list.add(d);
        list.add(a);
        list.show();
        list.dele(1);
        list.show();
        list.add(a);
        list.updele(c1);
        list.show();
    }
}

class DouLinkedList {
    private DouLinked head;

    DouLinkedList() {
        head = new DouLinked();
    }

    public void add(DouLinked douLinked) {
        System.out.println("------add--------");
        DouLinked temp = head;
        while (true) {
            if (temp.next == null) {
                douLinked.next = temp.next;
                temp.next = douLinked;
                douLinked.pre = temp;
                break;
            } else if (temp.next.id == douLinked.id) {
                System.out.println("id 重复不能添加");
                break;
            } else if (temp.next.id > douLinked.id) {
                douLinked.next = temp.next;
                temp.next = douLinked;
                douLinked.pre = temp;
                douLinked.next.pre = douLinked;
                break;
            }
            temp = temp.next;
        }
        System.out.println("------------------");

    }

    public void dele(int id) {
        System.out.println("------dele--------");
        DouLinked temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到id对应的节点");
                break;
            }
            if (temp.id == id) {
                temp.next.pre = temp.pre;
                temp.pre.next = temp.next;
                break;
            }
            temp = temp.next;
        }
        System.out.println("------------------");

    }

    public void updele(DouLinked douLinked) {
        System.out.println("------updele--------");
        DouLinked temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到id对应的节点");
                break;
            }
            if (temp.id == douLinked.id) {
                temp.name = douLinked.name;
                break;
            }
            temp = temp.next;
        }
        System.out.println("------------------");

    }

    public void show() {
        System.out.println("------show--------");
        DouLinked temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                System.out.println(temp.next);
            }
            temp = temp.next;
        }
        System.out.println("------------------");

    }
}

class DouLinked {
    public int id;
    public String name;
    public DouLinked pre;
    public DouLinked next;

    public DouLinked(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DouLinked() {

    }

    @Override
    public String toString() {
        return "DouLinked{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}