class MyHashMap {

    private static final int size = 1009;
    private final ListNode[] map;

    public MyHashMap() {
        map = new ListNode[size];
        for (int i = 0; i < size; i++) {
            map[i] = new ListNode(-1, 0);
        }
    }

    private static int hash(int k) {
        return ((k % size) + size) % size;
    }

    public void put(int key, int value) {
        int hashedKey = hash(key);
        ListNode curr = map[hashedKey];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.value = value;
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
            if (curr.next.key == key) {
                return curr.next.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hashedKey = hash(key);
        ListNode curr = map[hashedKey];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    private static class ListNode {
        int key, value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
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