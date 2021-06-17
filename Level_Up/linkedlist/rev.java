public class rev{
    public class ListNode{
        int data=0;
        ListNode next=null;
        ListNode(int val){
            this.data=val;
        }
    }

    public static int length(ListNode node){
        ListNode curr = node;
        int cnt=0;
        while(curr != null){
            cnt++;
            curr=curr.next;
        }
        return cnt;
    }

    public static ListNode[] segregate(ListNode node,int pivotIdx){
        ListNode curr = node;
        while(pivotIdx-- > 0){
            curr=curr.next;
        }
        ListNode pivotNode = curr;
        curr=head;
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp=small,lp=large;
        while(curr != null){
            if(curr != pivotNode){
                if(curr.val < pivotNode.val){
                    sp.next = curr;
                    sp=sp.next;
                }
                else{
                    lp.next=curr;
                    lp=lp.next;
                }
            }
            curr=curr.next;
        }

        sp.next=null;
        lp.next=null;
        return new ListNode[]{small.next,pivotNode,large.next};
    }


    public static ListNode[] mergeElements(ListNode[] left,ListNode pivotNode,ListNode[] right){
        ListNode head=null;
        ListNode tail=null;
        if(left[0] != null && right[0] != null){
            head=left[0];
            tail=right[1];
            left[1].next=pivotNode;
            pivotNode.next=right[0];
        }
        else if(left[0] != null){
            head=left[0];
            tail=pivotNode;
            left[1].next=pivotNode;
        }
        else if(right[0] != null){
            head=pivotNode;
            tail=right[1];
            pivotNode.next=right[0];
        }
        else{
            head=tail=pivotNode;
        }

        return new ListNode[]{head,tail};
    }

    public static ListNode[] quickSort(ListNode node){
        if(node == null || node.next == null) return new ListNode[]{node,node};
        int len = length(node);
        int pivotIdx = len/2;

        ListNode[] list = segregate(node,pivotIdx);
        ListNode[] left = quickSort(list[0]);
        ListNode[] right = quickSort(list[2]);

        return mergeElements(left,list[1],right);
    }
}