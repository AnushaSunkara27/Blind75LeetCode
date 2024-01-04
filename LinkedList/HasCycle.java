package LinkedList;

import java.util.HashSet;

import LinkedList.ReverseLinkedList.ListNode;

public class HasCycle {
    public boolean hasCycleBest(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }


    public boolean hasCycleFirst(ListNode head) {
        ListNode temp = head;
        HashSet<ListNode> hashSet = new HashSet<>();

        while(temp != null) {
            if(hashSet.contains(temp)) return true;
            hashSet.add(temp);
            temp = temp.next;
        }

        return false;
    }
}
