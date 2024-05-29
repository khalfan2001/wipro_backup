package com.day12;

class ListNodee {
	 int val;
	 ListNode next;
	 ListNodee(int val) { this.val = val; }
	}
	public class MergingtwoLL {
	 public static ListNode mergeLists(ListNode l1, ListNode l2) {
	 ListNode dummy = new ListNode(-1);
	 ListNode current = dummy;

	 while (l1 != null && l2 != null) {
	 if (l1.val < l2.val) {
	 current.next = l1;
	 l1 = l1.next;
	 } else
	{
	 current.next = l2;
	 l2 = l2.next;
	 }
	 current = current.next;

	}
	 current.next = (l1 != null) ? l1 : l2;
	 return dummy.next;
	 }
	 public static void main(String[] args)
	{
	 ListNode l1 = new ListNode(1);
	 l1.next = new ListNode(3);
	 l1.next.next = new ListNode(5);
	 ListNode l2 = new ListNode(2);
	 l2.next = new ListNode(4);
	 l2.next.next = new ListNode(6);
	 ListNode mergedList = mergeLists(l1, l2);
	 printList(mergedList);
	 }
	 public static void printList(ListNode head)
	{
	 ListNode current = head;
	 while (current != null) {
	 System.out.print(current.val + " ");
	 current = current.next;
	 }
	 }
	}