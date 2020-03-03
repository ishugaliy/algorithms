package datatype.rsq;

// Range sum query
public interface RSQ {

    void increment(int idx);
    void decrement(int idx);
    long sum(int from, int to);
}
