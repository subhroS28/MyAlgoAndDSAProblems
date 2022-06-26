package subhro.sde_sheet.day5_linkedlist;

import subhro.sde_sheet.Other.LinkedList.IMPL.ListNode;
import subhro.sde_sheet.Other.LinkedList.RemoveDuplicatesFromSortedList;

/**
 * Question - https://leetcode.com/problems/reverse-nodes-in-k-group/
 *            Little Variant - https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 *
 * Video - https://www.youtube.com/watch?v=EKgNMFCShO8&ab_channel=Pepcoding
 *         with helper video - https://www.youtube.com/watch?v=TOztSNeXZuw&ab_channel=Pepcoding
 *
 * Blog - https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseNodesInKGroup {
    private ListNode tempHead, tempTail;

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }

        int length = lengthOfLinkedList(head);
        ListNode newHead = null, newTail = null, curr = head;

        while (length >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);

                curr = fwd;
            }

            if(newHead==null){
                newHead = tempHead;
            }else{
                newTail.next = tempHead;
            }
            newTail = tempTail;

            tempHead = null;
            tempTail = null;
            length -= k;
        }

        newTail.next = curr;
        return newHead;
    }

    private void addFirst(ListNode node){
        if(tempHead==null){
            tempHead = tempTail = node;
        }else{
            node.next = tempHead;
            tempHead = node;
        }
    }

    private int lengthOfLinkedList(ListNode head){
        ListNode node = head;
        int length = 0;

        while(node != null){
            length++;
            node = node.next;
        }

        return length;
    }
}
