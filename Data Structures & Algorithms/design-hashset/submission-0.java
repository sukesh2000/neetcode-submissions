class MyHashSet {

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private static int hash(int k) {
        return ((k % 1009) + 1009) % 1009;
    }

    private final ListNode[] set;

    public MyHashSet() {
        set = new ListNode[1010];
    }
    
    public void add(int key) {
        int hashedKey = hash(key);
        ListNode curr = set[hashedKey];
        if (curr == null) {
            set[hashedKey] = new ListNode(key);
            return;
        }
        else if(curr != null) {
            if(curr.key == key){
                return;
            }
        }

        while (curr.next != null) {
            if(curr.next.key == key){
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int hashedKey = hash(key);
        ListNode curr = set[hashedKey];
        if (curr != null) {
            if(curr.key == key) {
                set[hashedKey] = curr.next;
                return;
            }

            while(curr.next != null) {
                if(curr.next.key == key) {
                    curr.next = curr.next.next;
                    return;
                }

                curr = curr.next;
            }
        }
    }
    
    public boolean contains(int key) {
        int hashedKey = hash(key);
        ListNode curr = set[hashedKey];
        if (curr == null) {
            return false;
        }
        else if(curr.key == key){
            return true;
        }

        while(curr.next != null) {
            if(curr.next.key == key){
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */