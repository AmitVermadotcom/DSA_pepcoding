public class quickSortLinkedList{
    public class ListNode{
        int data=0;
        ListNode next=null;
        ListNode(int val){
            this.data=val;
        }
    }

    public static ListNode[] segregate(ListNode head,int pivotIdx){
        ListNode pivotNode = head;
        while(pivotIdx-->0){
            pivotNode=pivotNode.next;
        }
        
        ListNode small=new ListNode(-1);
        ListNode large=new ListNode(-1);

        ListNode curr=head,sp=small,lp=large;
        while(curr != null){
            if(curr != pivotNode){
                if(curr.data <= pivotNode.data){
                    sp.next=curr;
                    sp=sp.next;
                }
                else{
                    lp.next=curr;
                    lp=lp.next;
                }
            }
            curr=curr.next;
        }

        lp.next=null;
        sp.next=null;
        pivotNode.next=null;
        return new ListNode[]{small.next,pivotNode,large.next};
    }

    public static ListNode[] mergeElements(ListNode[] left , ListNode pivotNode,ListNode[] right){
        ListNode head=null;
        ListNode tail=null;
        if(left[0] != null && right[0] != null){
            left[1].next=pivotNode;
            pivotNode.next=right[0];
            head=left[0];
            tail=right[1];
        }
        else if(left[0] != null){
            left[1].next=pivotNode;
            head=left[0];
            tail= pivotNode;
        }
        else if(right[0] != null){
            pivotNode.next=right[0];
            head=pivotNode;
            tail= right[1];
        }
        else{
            head=tail=pivotNode;
        }
        return new ListNode[]{head,tail};
        
    }

    public static int length(ListNode head){
        ListNode node=head;
        int len=0;
        while(node != null){
            node=node.next;
            len++;
        }
        return len;

    }

    public static ListNode[] quickSort(ListNode head){
        if(head == null || head.next == null){
            return new ListNode[]{head,head};
        }
        int len=length(head);
        int pivotIdx=len/2;
        ListNode[] list = segregate(head,pivotIdx);

        ListNode[] left=quickSort(list[0]);
        ListNode[] right=quickSort(list[2]);

        return mergeElements(left,list[1],right);

    }


}