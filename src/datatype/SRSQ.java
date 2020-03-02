package datatype;

import java.util.Arrays;

// Sharding range sum query
public final class SRSQ implements IRSQ {

    private final int[] src;
    private final int shardSize;
    private final int[] shards;

    public SRSQ(int[] src) {
        this.src = Arrays.copyOf(src, src.length);
        this.shardSize = (int) Math.sqrt(this.src.length);
        this.shards = initShards();
    }

    @Override
    public final void increment(int idx) {
        src[idx]++;
        shards[idx / shardSize]++;
    }

    @Override
    public final void decrement(int idx) {
        src[idx]--;
        shards[idx / shardSize]--;
    }

    @Override
    public final long sum(int from, int to) {
        long sum = 0;
        int shardFromIdx = from / shardSize;
        int shardToIdx = to / shardSize;
        if (shardFromIdx != shardToIdx) {
            sum += rangeSum(src, from, Math.min((shardFromIdx + 1) * shardSize, src.length));
            sum += rangeSum(shards, shardFromIdx + 1, shardToIdx);
            sum += rangeSum(src, shardToIdx * shardSize, to + 1);
        } else {
            sum = rangeSum(src, from, to + 1);
        }
        return sum;
    }

    private int[] initShards() {
        int[] shards = new int[src.length / shardSize + 1];
        for (int i = 0; i < src.length; i++) {
            shards[i / shardSize] += src[i];
        }
        return shards;
    }

    private long rangeSum(int[] arr, int from, int to) {
        long sum = 0;
        for (int i = from; i < to; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

