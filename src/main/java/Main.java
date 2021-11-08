public class Main {

    /**
     * Превращаем строковые аргументы командной строки в числа
     * @param args - параметры командной строки, приходят из ОС при запуске программы.
     */
    public static void main(String[] args) {
        // TODO: Предусматреть способ защиты от ввода некоректных данных.
        int[] test = new int[args.length];
        for (int i = 0; i < test.length; i++)
            test[i] = Integer.parseInt(args[i]);

        printArray(test);
        sort(test, 0, test.length -1);
        printArray(test);
    }

    /**
     * Функция сортировки в соответсвии с ТЗ
     * @param array - сортируемый массив
     * @param from - наменьший индекс сортируемого участка
     * @param to - наибольший индекс сортируемого участка
     */
    public static void sort(int[] array, int from, int to){
        if (!(from < to)) return;
        int middle = getMiddle(array, from, to);
        // int[] example = new int [] {52,  3,  6, -100, 12, 6};
        //                             0    1   2    3    4  5
        sort(array, from, middle); // Отправляем на сортировку левую "половину" массива.
        sort(array, middle+1, to); // Отправляем на сортировку правую "половину" массива.
        merge(array, from, middle, to);
    }

    private static void merge(int[] array, int from, int middle, int to) {
        int maxLeft = array [from];
        int maxIndex = -1;
        for (int i = from; i <= middle; i++){
            maxLeft = Math.max(array[i], maxLeft);
            maxIndex = i;
        }
        for (int i = middle+1; i <= to; i++){
            if (array[i] < maxLeft) {
                int tmp = array[i];
                array [i] = maxLeft;
                array [maxIndex] = tmp;
                sort(array, from, to);
                break;
            }
        }
    }

    /**
     * Метод для нахождения "середины" массива.
     * Делим сумму индексов на 2 (среднее арифметическое), округляем в меньшую сторону.
     * @param array
     * @param from
     * @param to
     * @return - возвращает полученный "серединный" индекс.
     */
    static int getMiddle(int[] array, int from, int to){
        return  (int)Math.floor((from + to) / 2);
    }

    private static void printArray(int[] array){
        for (int i : array) System.out.print(i + " ");
        System.out.println();
    }
}
