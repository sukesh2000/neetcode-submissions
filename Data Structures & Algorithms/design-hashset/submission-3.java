class MyHashSet {

    private final ListNode[] set;
    private final static int size = 1009;

    public MyHashSet() {
        set = new ListNode[size];
        for (int i = 0; i < set.length; i++) {
            set[i] = new ListNode(-1);
        }
    }

    private static int hash(int k) {
        return ((k % size) + size) % size;
    }

    public void add(int key) {
        int hashedKey = hash(key);
        ListNode curr = set[hashedKey];

        while (curr.next != null) {
            if (curr.next.key == key) {
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key);
    }

    public void remove(int key) {
        int hashedKey = hash(key);
        ListNode curr = set[hashedKey];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int hashedKey = hash(key);
        ListNode curr = set[hashedKey];

        while (curr.next != null) {
            if (curr.next.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */