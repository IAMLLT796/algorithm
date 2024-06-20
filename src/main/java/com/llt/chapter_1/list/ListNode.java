package com.llt.chapter_1.list;

/**
 * @Author LLT
 * @Date 2024-06-19-23:57
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {this.val = x;}

    // input an array and convert to a single linked list
    ListNode createLinkedList(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
}


