class LinkedList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    ListNode head;
    ListNode tail;

    public LinkedList() {
    }

    public int get(int index) {
        int i = 0;
        ListNode curr = head;
        while(curr != null) {
            if(i == index) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
        if(tail == null) {
            tail = head;
        }
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val);
        if(tail != null) {
            tail.next = newTail;
        }
        tail = newTail;
        if(head == null) {
            head = tail;
        }
    }

    public boolean remove(int index) {
        if(index < 0 || head == null) return false;
        int i = 0;
        ListNode curr = head;
        
        if(index == 0) {
            head = head.next;
            if (head == null) tail = null;
            return true;
        }

        while(curr != null && i < index - 1) {
            curr = curr.next;
            i++;
        }

        if(curr == null || curr.next == null) return false;

        // If we are removing the tail, update tail
        if (curr.next == tail) {
            tail = curr;
        }

        curr.next = curr.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        ListNode curr = head;

        while(curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        return values;
    }
}


