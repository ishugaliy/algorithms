package datatype.heap;

public class MinHeap implements Heap {

    private int[] arr = new int[16];
    private int size = 0;

    @Override
    public void add(int value) {
        grow();
        size++;
        arr[size] = value;
        siftUp(size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int v) {
        assertSize();
        int idx = indexOf(v);
        if (idx == -1) {
            return;
        }
        int last = arr[size--];
        arr[idx] = last;
        siftDown(idx);
        // wasn't siftDown, still on [idx] position, siftUp to check parent
        if (arr[idx] == last) {
            siftUp(idx);
        }
    }

    @Override
    public int poll() {
        assertSize();
        int root = arr[1];
        arr[1] = arr[size];
        siftDown(1);
        size--;
        return root;
    }

    @Override
    public int peek() {
        assertSize();
        return arr[1];
    }

    protected void siftUp(int idx) {
        int parent = idx / 2;
        while(idx > 1 && arr[parent] > arr[idx]) {
            swap(parent, idx);
            idx = parent;
            parent = idx / 2;
        }
    }

    protected void siftDown(int root) {
        int child = root * 2;
        while (child <= size) {
            if (child + 1 <= size
                    && arr[child] > arr[child + 1] // select for swap smallest child
                    && arr[child + 1] < arr[root]) {
                child += 1;
            }
            if (arr[child] >= arr[root]) {
                break;
            }
            swap(child, root);
            root = child;
            child = root * 2;
        }
    }

    private void assertSize() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        }
    }

    private void grow() {
        if (size == arr.length - 1) {
            int[] extArr = new int[arr.length * 2];
            System.arraycopy(arr, 0, extArr, 0, size + 1);
            arr = extArr;
        }
    }

    private void swap(int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private int indexOf(int v) {
        int idx = -1;
        for (int i = 1; i <= size; i++) {
            if (arr[i] == v) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
