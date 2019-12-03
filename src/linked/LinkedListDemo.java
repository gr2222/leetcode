package linked;

public class LinkedListDemo {
    public static void main(String[] args) {
        Linke linke1 = new Linke(1, "a");
        Linke linke2 = new Linke(2, "b");
        Linke linke3 = new Linke(3, "c");
        Linke linke4 = new Linke(4, "d");
        Linke linke5 = new Linke(4, "e");
        LinkeList linkeList = new LinkeList();
        linkeList.add(linke1);
        linkeList.add(linke3);
        linkeList.add(linke4);
        linkeList.add(linke2);
        linkeList.show();
        linkeList.updele(linke5);
        linkeList.show();
        linkeList.dele(1);
        linkeList.dele(2);
        linkeList.dele(3);
        linkeList.dele(4);
        linkeList.show();
        linkeList.add(linke1);
        linkeList.add(linke4);
        linkeList.add(linke3);
        linkeList.add(linke2);
        linkeList.show();

        fz(linkeList.getHead());

    }

    public static void fz(Linke head) {
        Linke nei = new Linke();
        Linke temp = head.next;
        Linke ss = new Linke();
        while (true) {
            if (temp == null) {
                break;
            } else {
                ss = temp.next;
                temp.next = nei.next;
                nei.next = temp;
            }
            temp = ss;
        }
        while (true){
            if (nei.next==null){
                break;
            } else{
                System.out.println(nei.next);
            }
            nei = nei.next;
        }
    }
}

class LinkeList {
    Linke haed;

    public LinkeList() {
        haed = new Linke();
    }

    public Linke getHead() {
        return haed;
    }

    public void add(Linke linke) {
        Linke temp = haed;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.id > linke.id) {
                break;
            } else if (temp.next.id.equals(linke.id)) {
                flag = true;
                System.out.println("重复添加失败");
            }
            temp = temp.next;
        }
        if (!flag) {
            linke.next = temp.next;
            temp.next = linke;
        }
    }

    public void show() {
        System.out.println("----------show---------");
        Linke temp = haed.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("---------------------");
    }

    public void updele(Linke linke) {
        Linke temp = haed.next;
        while (true) {
            if (temp.id.equals(linke.id)) {
                temp.name = linke.name;
                break;
            }
            if (temp.next == null) {
                System.out.println("没有此元素可以修改");
                break;
            }
            temp = temp.next;
        }
    }

    public void dele(int did) {
        Linke temp = haed;
        while (true) {
            if (temp.next.id.equals(did)) {
                temp.next = temp.next.next;
                break;
            } else if (temp.next.next == null) {
                System.out.println("----------dele---------");
                System.out.println("没有此元素可以删除");
                System.out.println("---------------------");

                break;
            }

            temp = temp.next;
        }
    }
}


class Linke {
    public Integer id;
    public String name;
    public Linke next;

    public Linke(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Linke() {
    }

    @Override
    public String toString() {
        return "Linke{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}