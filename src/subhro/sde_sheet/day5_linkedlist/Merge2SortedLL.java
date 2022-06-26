package subhro.sde_sheet.Other.LinkedList;

import subhro.sde_sheet.Other.LinkedList.IMPL.LinkedListNode;

/**
 * Question - https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 *            https://leetcode.com/problems/merge-two-sorted-lists/
 *
 *  Approach - 1. Using extra space - TC - O(N+M) SC - O(N+M)
 *             2. IN-PLACE - TC - O(N+M) SC - O(1)
 *
 *  Video - https://www.youtube.com/watch?v=Xb4slcp1U38&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29&ab_channel=takeUforward
 */
public class Merge2SortedLL {

    //In place
    public Node sortedMerge(Node head1, Node head2) {
        if(head1 == null || head2 == null){
            return head1==null?head2:head1;
        }

        Node temp = new Node(-1);
        Node newHead = temp;

        while(head1 != null && head2 != null){
            if(head1.data>head2.data){
                temp.next = head2;
                head2 = head2.next;
            }else{
                temp.next = head1;
                head1 = head1.next;
            }
            temp = temp.next;
        }

        temp.next = head1==null?head2:head1;

        return newHead.next;
    }

    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        LinkedListNode<Integer> temp = null,combinedHead = null;

        if(head1.data <= head2.data){
            temp = head1;
            head1 = head1.next;
        }else{
            temp = head2;
            head2 = head2.next;
        }
        combinedHead = temp;

        while(head2 !=null && head1 != null){
            if (head1.data > head2.data) {
                temp.next = head2;
                head2 = head2.next;
            } else {
                temp.next = head1;
                head1 = head1.next;
            }

            temp = temp.next;
        }

        if(head2 == null){
            temp.next = head1;
        }

        if(head1 == null){
            temp.next = head2;
        }

        return combinedHead;
    }
}
