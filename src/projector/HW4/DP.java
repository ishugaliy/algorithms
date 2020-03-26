package projector.HW4;

public class DP {

    public static void main(String[] args) {
        System.out.println("----------put golden bars to bag-----------");
        System.out.println(maxBarsWeightInBag(new int[]{49, 90, 34, 96, 12, 65, 34}, 200)); // 200
        System.out.println(maxBarsWeightInBag(new int[]{4, 9, 3, 1, 6}, 10));               // 10
        System.out.println(maxBarsWeightInBag(new int[]{5, 3}, 7));                         // 6
        System.out.println(maxBarsWeightInBag(new int[]{186, 419, 83, 408}, 6249));         // 10
        System.out.println();


    }

    /**
     * A. Є М злитків золота [49, 90, 34, 96, 12, 65, 34] (M[2] = 34 кілограми) і мішок розміром 200 кг. Написати програму яка виконає
     * ПОВНИЙ ПЕРЕБІР всіх можливих злитків і виведе максимальну масу золота яку можна покласти в мішок.
     */
    public static int maxBarsWeightInBag(int[] bars, int bagSize) {
        int[] weight = new int[bagSize + 1];
        for (int i = 1; i < weight.length; i++) {
            int curr = 0;
            for (int b : bars) {
                if (b <= i) {
                    curr = Math.max(curr, weight[i - b] + b);
                }
            }
            weight[i] = curr;
        }
        return weight[bagSize];
    }
}
