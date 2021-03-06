package ltttcode.addtwonumber;

import java.util.LinkedList;
import java.util.List;

/**
 * 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，即第一个结点表示最低位，
 * 最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
 * <p>
 * 　　Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 　　Output: 7 -> 0 -> 8
 * Created by dell on 2017/3/2.
 */
public class AddTwoNumber {

    public static void main(String args[]) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;

        ListNode li1=new ListNode(5);
        ListNode li2=new ListNode(6);
        ListNode li3=new ListNode(4);
        li1.next=li2;
        li2.next=li3;
        addtwo1(l1,li1);

    }

    private static ListNode  addtwo1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode root = new ListNode(0); // 头结点
        ListNode r = root;
        root.next = l1;

        int carry = 0; // 初始进位
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位

            r.next = p1;
            r = p1; // 指向最后一个相加的结点
            p1 = p1.next;
            p2 = p2.next;

        }

        if (p1 == null) {
            r.next = p2;
        } else {
            r.next = p1;
        }

        // 最后一次相加还有进位
        if (carry == 1) {
            // 开始时r.next是第一个要相加的结点
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            // 都加完了还有进位，就要创建一个新的结点
            if (carry == 1) {
                r.next = new ListNode(1);
            }
        }

        return root.next;
    }
}
