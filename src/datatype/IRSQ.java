package datatype;

// Interface range sum query
public interface IRSQ {

    void increment(int idx);
    void decrement(int idx);
    long sum(int from, int to);
}
