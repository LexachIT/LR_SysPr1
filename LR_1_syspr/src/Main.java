import java.util.Scanner;

class Main {
    // Функция для поиска основного элемента, присутствующего в заданном массиве
    public static int findMajorityElement(int[] nums) {
        // m хранит мажоритарный элемент (если есть)
        int m = -1;
        // инициализируем счетчик i значением 0
        int i = 0;
        // делаем для каждого элемента nums[j] в массиве
        for (int j = 0; j < nums.length; j++) {
            // если счетчик i становится равным 0
            if (i == 0) {
                // устанавливаем текущий кандидат в nums[j]
                m = nums[j];
                // сбрасываем счетчик на 1
                i = 1;
            }
            // в противном случае увеличить счетчик, если nums[j] является текущим кандидатом
            else if (m == nums[j]) {
                i++;
            }
            // иначе, уменьшаем значение счетчика, если nums[j] является текущим кандидатом
            else {
                i--;
            }
        }
        return m;
    }

    // Функция для вычисления процента мажоритарности элемента
    public static double calculateMajorityPercentage(int[] nums, int majorityElement) {
        int majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        double percentage = ((double) majorityCount / nums.length) * 100;
        return percentage;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();
        int nums[] = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            nums[i] = input.nextInt();
        }
        System.out.print("Числа:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println("\nМажоритарный элемент: " + findMajorityElement(nums));
        int majorityElement = findMajorityElement(nums);
        if (majorityElement != -1) {
            double majorityPercentage = calculateMajorityPercentage(nums, majorityElement);
            System.out.println("Процент мажоритарности: " + majorityPercentage + "%");
        } else {
            System.out.println("Мажоритарного элемента не найдено.");
        }
    }
}