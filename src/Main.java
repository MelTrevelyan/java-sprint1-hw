import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Введите месяц, за который хотите ввести количество шагов. 1 - Январь," +
                        " 2 - Февраль ... 12 - Декабрь");
                int chosenMonth = scanner.nextInt();
                System.out.println("Введите день, за который хотите ввести количество шагов (от 1 до 30)");
                int chosenDay = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int userSteps = scanner.nextInt();
                tracker.saveStepsInDay((chosenMonth - 1), chosenDay, userSteps);
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 2) {
                System.out.println("За какой месяц вы хотите получить статистику? 1 - январь, 2 - Февраль ..." +
                        " 12 - Декабрь");
                int monthStatistics = scanner.nextInt();
                tracker.showStepsInDay((monthStatistics - 1));
                System.out.println("Общее количество шагов за месяц: " + tracker.sumMonthSteps(monthStatistics - 1));
                System.out.println("Максимальное пройденное количество шагов в месяце: " + tracker.getMaxSteps((monthStatistics - 1)));
                System.out.println("Среднее количество шагов: " + tracker.getAverageSteps((monthStatistics - 1)));
                System.out.println("Пройденная дистанция (в км): " + tracker.getDistance((monthStatistics - 1)));
                System.out.println("Количество сожжённых килокалорий: " + tracker.getKilocalories((monthStatistics - 1)));
                System.out.println("Ваша лучшая серия: " + tracker.getBestSeries((monthStatistics - 1)));
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов");
                int newGoal = scanner.nextInt();
                tracker.changeTheGoal(newGoal);
                printMenu();
                userInput = scanner.nextInt();
            } else {
                System.out.println("Извините, такой команды пока нет.");
                printMenu();
                userInput = scanner.nextInt();
            }
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println(" 1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения.");
    }
}
