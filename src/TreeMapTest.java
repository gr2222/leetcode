import java.util.TreeMap;

/**
 * @author maitentai
 * @version 1.0
 * @date 2019-09-18 14:36
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Object,Object> stdtree = new TreeMap<>();
        stdtree.put("sadsa", new ListNode(1));
        stdtree.put("sadaw", new ListNode(2));

        ListNode sadsa = (ListNode)stdtree.get("sadsa");
        ListNode sadsw = (ListNode)stdtree.get("sadaw");

    }
}
