package projector.HW4;

import java.util.Arrays;

public class Recursion2 {

    public static void main(String[] args) {
        System.out.println("----------max golden bars weight in bag-----------");
        System.out.println(maxBarsWeightInBag(new int[]{49, 90, 34, 96, 12, 65, 34}, 200)); // 198
        System.out.println(maxBarsWeightInBag(new int[]{4, 9, 3, 1, 6}, 10));               // 10
        System.out.println(maxBarsWeightInBag(new int[]{5, 3}, 7));                         // 5
        System.out.println();
    }

    /**
     * A. Є М злитків золота [49, 90, 34, 96, 12, 65, 34] (M[2] = 34 кілограми) і мішок розміром 200 кг. Написати програму яка виконає
     * ПОВНИЙ ПЕРЕБІР всіх можливих злитків і виведе максимальну масу золота яку можна покласти в мішок.
     */
    public static int maxBarsWeightInBag(int[] bars, int bagSize) {
        // only one bar left, check if we can put it to the bag
        if (bars.length == 1) return bars[0] <= bagSize ? bars[0] : 0;

        int firstBar = bars[0];
        int[] barsLeft = Arrays.copyOfRange(bars, 1, bars.length);
        if (firstBar <= bagSize) {
            return Math.max(
                    maxBarsWeightInBag(barsLeft, bagSize),
                    maxBarsWeightInBag(barsLeft, bagSize - firstBar) + firstBar);
        } else {
            return maxBarsWeightInBag(barsLeft, bagSize);
        }
    }

    /**
     *  B. На лекції ми розглянули задачу про рюкзак: для заданої множини предметів, кожен з яких має вагу і цінність,
     *  визначити які з предметів слід взяти, так, щоб сумарна вага не перевищувала задану,
     *  а сумарна цінність була максимальною. Як зміниться рек-на формула для цієї задачі
     *  (A[i][j] = max(A[i-1][j], A[i-1][j-m[i]] + c[i])) якщо кожен товар є в необмеженій кількості?
     *   Товар Вага Вартість
     *   1    6     30
     *   2    3     14
     *   3    4     16
     *   4    2     9
     *
     *   Якщо кожен товар є в необмеженій кількості, то оптимально буде взяти товар номер 1 і дві штуки товара номер 4
     *   (загальна вартість: 48). Якщо кажен товар є в одному екземплярі, тоді оптимальним буде набір з 1 та 3 (вартість: 46).
     *
     *   Відповідь:
     *       рекулентна формула буде => A[i][j] = max(A[i-1][j], A[i][j-m[i]] + c[i])
     *       у другому випаду, коли ми беремо цю річ у рюкзак, потрібно розглянути випадок
     *       [i]-го рядку (з урахуванням цієї речі), а не [i-1] рядку, де знаходится максимальна сума для i-1 речей та ваги j.
     *       A[i][j-m[i]] + c[i] замість A[i-1][j-m[i]] + c[i]
     */
}
