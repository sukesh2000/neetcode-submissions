class MyHashMap {

    private static class ListNode {
        int[] key;
        ListNode next;

        ListNode(int key, int value) {
            this.key = new int[]{key, value};
        }
    }

    private static int hash(int k) {
        return ((k % size) + size) % size;
    }
    
    private final ListNode[] map;
    private static final int size = 1009; 
    
    public MyHashMap() {
        map = new ListNode[size];
        for (int i=0; i<size; i++) {
            map[i] = new ListNode(-1, 0);
        }
    }

    public void put(int key, int value) {
        int hashedKey = hash(key);
        ListNode curr = map[hashedKey];

        while (curr.next != null) {
            if (curr.next.key[0] == key) {
                curr.next.key[1] = value;
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key, value);
    }

    public int get(int key) {
        int hashedKey = hash(key);
        ListNode curr = map[hashedKey];

        while (curr.next != null) {
            if (curr.next.key[0] == key) {
                return curr.next.key[1];
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hashedKey = hash(key);
        ListNode curr = map[hashedKey];

        while (curr.next != null) {
            if (curr.next.key[0] == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */