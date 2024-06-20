package com.llt.chapter_1.list;

/**
 * @Author LLT
 * @Date 2024-06-20-11:09
 **/
public class DoubleListNode {
    int val;
    DoubleListNode prev, next;

    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode createDoubleLinkedList(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        DoubleListNode head = new DoubleListNode(arr[0]);
        DoubleListNode cur = head;

        for(int i = 1; i < arr.length; i++) {
            DoubleListNode newNode = new DoubleListNode(arr[i]);

            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }


    // Search
    public void search(int[] arr) {
        DoubleListNode head = createDoubleLinkedList(arr);

        for(DoubleListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public void insertFirst(int[] arr, int val) {
        DoubleListNode head = createDoubleLinkedList(arr);

        DoubleListNode newNode = new DoubleListNode(val);

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertLast(int[] arr, int val) {
        DoubleListNode head = createDoubleLinkedList(arr);

        DoubleListNode newNode = new DoubleListNode(val);

        DoubleListNode p = head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        newNode.prev = p;
    }

    public void insert(int[] arr, int val,  int position) {
        DoubleListNode head = createDoubleLinkedList(arr);

        DoubleListNode p = head;

        for(int i = 0; i < position - 1; i++) {
            p = p.next;
        }

        DoubleListNode newNode = new DoubleListNode(val);

        newNode.next = p.next;
        newNode.prev = p;

        p.next.prev = newNode;
        p.next = newNode;
    }


    public DoubleListNode delete(int[] arr, int position) {
        DoubleListNode head = createDoubleLinkedList(arr);

        DoubleListNode p = head;

        for(int i = 0; i < position - 2; i++) {
            p = p.next;
        }

        DoubleListNode toDelete = p.next;

        p.next = toDelete.next;
        toDelete.next.prev = p;

        toDelete.prev =null;
        toDelete.next = null;

        return toDelete;
    }

    public DoubleListNode deleteFirst(int[] arr) {
        DoubleListNode head = createDoubleLinkedList(arr);

        DoubleListNode toDelete = head;
        head = head.next;
        head.prev = null;

        toDelete.next = null;

        return toDelete;
    }

    public DoubleListNode deleteLast(int[] arr) {
        DoubleListNode head = createDoubleLinkedList(arr);

        DoubleListNode p = head;

        while(p.next != null) {
            p = p.next;
        }

        p.prev.next = null;

        p.prev = null;

        return p;
    }
}
