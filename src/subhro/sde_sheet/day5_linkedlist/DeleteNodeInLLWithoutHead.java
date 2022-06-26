package subhro.sde_sheet.day5_linkedlist;

import subhro.sde_sheet.Other.LinkedList.IMPL.ListNode;

/**
 * Description - Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
 *
 * Video - https://www.youtube.com/watch?v=icnp4FJdZ_c&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=31&ab_channel=takeUforward
 *
 * Question - https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInLLDifferent {
    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }

        if(node.next==null){
            node=null;
            return;
        }

        node.val = node.next.val;
        ListNode temp = node.next;

        node.next = temp.next;
        temp=null;
    }
}
