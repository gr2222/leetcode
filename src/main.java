
import java.util.*;

public class main {
    public static void main(String[] args) {
        int[] a = {9,6,4,2,3,5,7,0,1};
        int i = missingNumber(a);
    }
    private static int suns;
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        String str = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            str += chars[i];
        }
        return str.equals(s);
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        } else {
            Integer res = 0;
            Integer num = x;
            while (num != 0) {
                res = res * 10 + num % 10;
                num /= 10;
            }
            return x == res;
        }

    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        Integer num = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'M':
                    num += 1000;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'I':
                    num += 1;
                    break;
            }
            if (i < chars.length - 1) {
                if ((chars[i] == 'I') && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                    num -= 2;
                }
                if ((chars[i] == 'X') && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                    num -= 20;
                }
                if ((chars[i] == 'C') && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                    num -= 200;
                }
            }
        }
        System.out.println(num);
        return num;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String s = strs[0];
        String a = "";
        for (int i = 0; i < strs.length - 1; i++) {
            if ((strs[i].length() > strs[i + 1].length())) {
                if (s.length() > strs[i + 1].length()) {
                    s = strs[i + 1];
                }
            } else {
                if (s.length() > strs[i].length()) {
                    s = strs[i];
                }
            }
        }
        System.out.println("s=" + s);
        if (s.equals("")) {
            return s;
        } else {
            for (int i = 0; i < s.length(); i++) {
                int im = 0;
                for (int n = 0; n < strs.length; n++) {
                    if (s.charAt(i) == strs[n].charAt(i)) {
                        im += 1;
                    } else {
                        break;
                    }
                }
                if (im == strs.length) {
                    a += s.charAt(i);
                } else {
                    break;
                }
            }
        }
        System.out.println("a=" + a);
        return a;
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.size() == 0) {
                stack.push(chars[i]);
            } else if ((stack.peek() == '(' && chars[i] == ')')
                    || (stack.peek() == '{' && chars[i] == '}')
                    || (stack.peek() == '[' && chars[i] == ']')) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();


        return 0;
    }

    /**
     * ArrayList 遍历 小助手
     */
    public static void arrayList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        System.out.printf("Before add:arrayList.size() = %d\n", arrayList.size());

        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        System.out.printf("After add:arrayList.size() = %d\n", arrayList.size());

        System.out.println("Printing elements of arrayList");
        // 三种遍历方式打印元素
        // 第一种：通过迭代器遍历
        System.out.print("通过迭代器遍历:");
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 第二种：通过索引值遍历
        System.out.print("通过索引值遍历:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        // 第三种：for循环遍历
        System.out.print("for循环遍历:");
        for (Integer number : arrayList) {
            System.out.print(number + " ");
        }

        // toArray用法
        // 第一种方式(最常用)
        Integer[] integer = arrayList.toArray(new Integer[0]);

        // 第二种方式(容易理解)
        Integer[] integer1 = new Integer[arrayList.size()];
        arrayList.toArray(integer1);

        // 抛出异常，java不支持向下转型
        //Integer[] integer2 = new Integer[arrayList.size()];
        //integer2 = arrayList.toArray();
        System.out.println();

        // 在指定位置添加元素
        arrayList.add(2, 2);
        // 删除指定位置上的元素
        arrayList.remove(2);
        // 删除指定元素
        arrayList.remove((Object) 3);
        // 判断arrayList是否包含5
        System.out.println("ArrayList contains 5 is: " + arrayList.contains(5));

        // 清空ArrayList
        arrayList.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: " + arrayList.isEmpty());
    }

    public static void stringmedel() {
        String str = "192.168.1.1";
        String[] split = str.split(".", 8);

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    public static void show() {
        String suanshi = "1+(2+3)";
        String replace = suanshi.replace("(2+3)", "5");
        System.out.println(replace);
    }


    public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                } else if (array[i][j] > target) {
                    break;
                }
            }

        }
        return false;
    }

    public static String replaceSpace(StringBuffer str) {

        while (true) {
            int i = str.indexOf(" ");
            if (-1 == i) {
                break;
            }
            str.replace(i, i + 1, "%20");
        }

        return str.toString();
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            digui(listNode, list);
        }
        return list;
    }

    public static void digui(ListNode listNode, ArrayList<Integer> lsit) {
        if (listNode.next == null) {
            return;
        } else {
            digui(listNode.next, lsit);
            lsit.add(listNode.val);
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode gen = new TreeNode(pre[0]);
        Integer getindex = getindex(in, pre[0]);
        int[] zhong = new int[getindex];
        for (int i = 0; i < getindex; i++) {
            zhong[i] = in[i];
        }
        int[] qian = new int[getindex];
        for (int i = 1; i < getindex + 1; i++) {
            qian[i - 1] = pre[i];
        }
        gen.left = reConstructBinaryTree(qian, zhong);
        int[] zhong1 = new int[in.length - getindex];
        for (int i = getindex + 1; i < in.length; i++) {
            zhong[i - getindex - 1] = in[i];
        }
        int[] qian1 = new int[in.length - getindex];
        for (int i = getindex + 1; i < pre.length; i++) {
            qian1[i - getindex - 1] = pre[i];
        }
        gen.right = reConstructBinaryTree(qian1, zhong1);
        return gen;
    }

    public static Integer getindex(int[] a, int index) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == index) {
                return i;
            }
        }
        return null;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int biaoshi = nums[0];
        int j = 1;
        int i = 0;
        while (true) {
            if (j == nums.length) {
                break;
            }
            if (biaoshi == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                biaoshi = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        }
        char[] hay = haystack.toCharArray();

        return 0;
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        if (nums.length > 5) {
            while (true) {
                if (target <= nums[i]) {
                    break;
                }
                if (i + 5 >= nums.length) {
                    break;
                }
                if (nums[i] < target && target <= nums[i + 5]) {
                    break;
                }
                i = i + 5;
            }
        }
        int n = i;
        while (true) {
            if (target <= nums[n]) {
                n = n - 1;
                break;
            }
            if (n + 1 >= nums.length) {
                break;
            }
            if (nums[n] < target && target <= nums[n + 1]) {
                break;
            }
            n++;
        }
        return n + 1;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tou;
        tou = head;
        while (l1 != null && l2 != null) {

            if (l1.val >= l2.val) {
                tou.next = l2;
                l2 = l2.next;
            } else {
                tou.next = l1;
                l1 = l1.next;
            }
            tou = tou.next;
        }
        tou.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        int[] re = new int[digits.length + 1];
        digits[i] = digits[i] + 1;
        if (digits[i] < 10) {
            return digits;
        }
        while (true) {
            if (i - 1 < 0) {
                break;
            }
            if (digits[i] >= 10) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
            i--;
        }
        if (digits[0] == 10) {
            re[0] = 1;
            return re;
        }
        return digits;
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int flag = trips[0][3];
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][3] > flag) {
                flag = trips[i][3];
            }
        }
        for (int i = 1; i < flag + 1; i++) {

        }
        return false;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i1 = l1;
        ListNode i2 = l2;
        while (true) {
            if (i1 == null && i2 == null) {
                break;
            }
            if (i1 == null) {
                i1 = new ListNode(0);
            }
            if (i2 == null) {
                i2 = new ListNode(0);
            }
            i1 = i1.next;
            i2 = i2.next;
        }

        while (l1.next != null) {
            System.out.print(l1.val);
        }
        System.out.println();
        while (l2.next != null) {
            System.out.print(l2.val);
        }
        return null;
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int lt = 0;
        int rt = array.length - 1;
        if (array[lt] < array[rt]) {
            while (lt <= rt) {
                if (array[lt] < array[lt + 1]) {
                    return array[lt];
                }
                if (array[rt] > array[rt - 1]) {
                    return array[rt - 1];
                }
                lt = lt + 1;
                rt = rt - 1;
            }
        } else {
            while (lt <= rt) {
                if (array[lt] > array[lt + 1]) {
                    return array[lt + 1];
                }
                if (array[rt] < array[rt - 1]) {
                    return array[rt];
                }
                lt = lt + 1;
                rt = rt - 1;
            }
        }
        return 0;
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        List<Integer> alist = new ArrayList<Integer>();
        alist.add(1);
        alist.add(1);
        for (int i = 2; i < n; i++) {
            alist.add(alist.get(i - 2) + alist.get(i - 1));
        }
        return alist.get(n - 1);
    }

    public static int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= target; i++) {
            int cup = pre1 + pre2;
            pre1 = pre2;
            pre2 = cup;
        }
        return pre2;
    }

    public static void fangfa() {
        Scanner scanner = new Scanner(System.in);
        int lens = scanner.nextInt();
        int[] a = new int[lens];
        for (int i = 0; i < lens; i++) {
            a[i] = scanner.nextInt();
        }
        lens = scanner.nextInt();
        int[][] b = new int[lens][3];
        for (int i = 0; i < lens; i++) {
            b[i][0] = scanner.nextInt();
            b[i][1] = scanner.nextInt();
            b[i][2] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = b[i][0] - 1; j < b[i][1]; j++) {
                if (b[i][2] == a[j]) {
                    sum++;
                }
            }
            System.out.println(sum);
            sum = 0;
        }
    }

    public static int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= target; i++) {
            int cup = pre1 + pre2;
            pre1 = pre2;
            pre2 = cup;
        }
        return pre2;
    }

    public int NumberOf1(int n) {
        return 0;
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            double rult = base;
            for (int i = 0; i < exponent - 1; i++) {
                rult = rult * base;
            }
            return rult;
        } else {
            double rult = base;
            for (int i = 0; i < -exponent - 1; i++) {
                rult = rult * base;
            }
            return 1 / rult;
        }
    }

    public static void reOrderArray(int[] array) {
        List<Integer> a = new ArrayList<Integer>();

    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode la = head;
        ListNode ra = head;
        for (int i = 1; i < k; i++) {
            ra = ra.next;
        }
        while (ra.next != null) {
            ra = ra.next;
            la = la.next;
        }
        return la;
    }

    public static int getValue() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

    public static void test() {
        for (int i = 0; istrue(i); i = addi(i)) {
            System.out.println("C");
        }
    }

    private static boolean istrue(int i) {
        System.out.println("A");
        if (i < 3) {
            return true;
        } else {
            return false;
        }
    }

    private static int addi(int i) {
        System.out.println("b");
        return i++;
    }

    public void jimi() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        int sun = 0;
        String[] split = s.split(", ");
        String[] split1 = s1.split(", ");
        int length = split.length;
        int i = length / 2;
        for (int j = 0; j < i; j++) {
            Tree tree = new Tree(Integer.parseInt(split[1]));

        }


    }

    public void getTree(Tree tree, String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            if (tree.zuo == null) {
                tree.zuo = new Tree(Integer.parseInt(strs[i]));

            }
            if (tree.you == null) {
                tree.you = new Tree(Integer.parseInt(strs[i + 1]));
            }
        }
    }

    class Tree {
        private int zhi;
        Tree zuo;
        Tree you;

        public Tree(int zhi) {
            this.zhi = zhi;
        }

        public int getZhi() {
            return zhi;
        }

        public void setZhi(int zhi) {
            this.zhi = zhi;
        }

        public Tree getZuo() {
            return zuo;
        }

        public void setZuo(Tree zuo) {
            this.zuo = zuo;
        }

        public Tree getYou() {
            return you;
        }

        public void setYou(Tree you) {
            this.you = you;
        }
    }

    public void getss() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            System.out.print(s1[i] + " ");
        }
    }

    public void teet() {
        int i = 12;
        System.out.println(i += i -= i *= i);
    }

    public static String addBinary(String a, String b) {
        char[] chars_A = a.toCharArray();
        char[] chars_B = b.toCharArray();
        for (int i = chars_A.length - 1; i >= 0; i++) {


        }
        return null;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode bian = head;
        while (true) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
            if (head.next == null) {
                break;
            }
        }
        return bian;
    }

    public static ListNode deleteDuplicatespull(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode yidong = new ListNode(8989);
        ListNode result = yidong;
        ListNode next = head.next;

        while (true) {
            if (head.val != next.val) {
                yidong.next = new ListNode(head.val);
                head = head.next;
                next = next.next;
                yidong = yidong.next;
            } else {
                while (true) {
                    if (head.val == next.val) {
                        if (next.next != null) {
                            next = next.next;
                        } else {
                            next = next.next;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (head.next != next) {
                    head = next;
                    if (next != null) {
                        next = next.next;
                    }
                }
            }
            if (head == null || head.next == null) {
                if (head == null) {
                    yidong.next = null;
                } else {
                    yidong.next = new ListNode(head.val);
                }
                break;
            }
        }
        return result.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resulet = head.next;
        ListNode next = head.next;
        ListNode b = null;

        while (true) {
            head.next = next.next;
            next.next = head;
            ListNode a;
            a = head;
            head = next;
            next = a;
            if (b != null) {
                b.next = head;
            }
            b = next;

            if (next.next != null && next.next.next != null) {
                head = head.next.next;
                next = next.next.next;
            } else {
                break;
            }
        }
        return resulet;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int mix = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (mix > prices[i]) {
                mix = prices[i];
            }
            if (prices[i] - mix > max) {
                max = prices[i] - mix;
            }
        }
        return max;
    }

    public static int maxProfitpro(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                max = max + (prices[i] - prices[i - 1]);

            }
        }
        return max;
    }

    public static int maxProfitpro1(int[] prices) {

        return 0;
    }

    public static List<List<Integer>> leetcode_15(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
//        set;
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) {
            if (nums[0] == 0) {
                List<Integer> a = new ArrayList<>();
                a.add(0);
                a.add(0);
                a.add(0);
                result.add(a);
                return result;
            } else {
                return result;
            }
        }
        int k = 0;
        int i = 1;
        int j = nums.length - 1;

        return result;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int i1 = 0;
        int j1 = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < target) {
                i1 = i;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] > target) {
                j1 = i;
                break;
            }
        }
        for (int i = 0; i < i1; i++) {
            for (int j = 0; j < j1; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int atMostNGivenDigitSet(String[] D, int N) {
        String s = String.valueOf(N);
        int length = s.length();
        int result = 0;
        String a = "1";
        for (int i = 1; i < length; i++) {
            result = result + (int) Math.pow(D.length, i);
            a = a + 0;
        }
        Integer N_1 = Integer.valueOf(a);
        char[] chars = s.toCharArray();
        System.out.println(N_1);

        return result;
    }

    public static String strWithout3a3b(int A, int B) {
        if (A > B && A - B > 3) {
            return null;
        }
        if (A < B && B - A > 3) {
            return null;
        }
        return null;
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] peopleList = new int[num_people];
        int i = 0;
        int candiesnum = 1;
        while (true) {
            if (candies >= candiesnum) {
                peopleList[i] = peopleList[i] + candiesnum;
                candies = candies - candiesnum;
            } else {
                peopleList[i] = peopleList[i] + candies;
                break;
            }
            if (i >= peopleList.length - 1) {
                i = -1;
            }
            i++;
            candiesnum++;
        }
        return peopleList;
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] s = A.split(" ");
        String[] s1 = B.split(" ");
        int strLen1 = s.length;
        int strLen2 = s1.length;
        s = Arrays.copyOf(s, strLen1 + strLen2);
        System.arraycopy(s1, 0, s, strLen1, strLen2);
        String a = "";
        for (int i = 0; i < s.length; i++) {
            a = s[i];
            if (s[i].equals(" *")) {
                continue;
            }
            for (int j = i + 1; j < s.length; j++) {
                if (a.equals(s[j])) {
                    s[j] = " *";
                    s[i] = " *";
                }
            }

        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals(" *")) {
                arrayList.add(s[i]);
            }
        }
        String[] strings = arrayList.toArray(new String[arrayList.size()]);
        return strings;
    }

    public static int missingNumber(int[] nums) {
        int sun = 0;
        for (int i = 0; i <= nums.length; i++) {
            sun = sun+i;
        }
        int suns = 0;
        for (int i = 0; i < nums.length; i++) {
            suns = suns + nums[i];
        }
        return sun - suns;
    }



}
