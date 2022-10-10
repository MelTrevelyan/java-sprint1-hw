
public class StepTracker {

    int goal = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    /* @param month - месяц, выбранный пользователем; @param day - день месяца, указанный пользователем;
    @param steps - введенное количество шагов.
    Сохраняем значение шагов в массиве.
    */
    public void saveStepsInDay(int month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным.");
        } else if (month < 0) {
            System.out.println("Номер месяца не может быть отрицательным.");
        } else if (day <= 0) {
            System.out.println("Номер дня должен быть больше нуля");
        } else {
            monthToData[month].dayData[day - 1] = steps;
            System.out.println("Ваши данные успешно сохранены");
        }
    }

    public void changeTheGoal(int newGoal) {
        if (newGoal >= 0) {
            goal = newGoal;
            System.out.println("Ваша новая цель установлена!");
        } else {
            System.out.println("Количество шагов не может быть отрицательным. Цель не изменена.");
        }
    }

    public void showStepsInDay(int month) {
        System.out.println("Количество пройденных шагов по дням: ");
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            System.out.println("день " + (i + 1) + ": " + monthToData[month].dayData[i] + ", ");
        }
    }
    /* Сравниваем количество шагов каждого дня одного месяца.
    @return максимальное количество шагов за день в выбранном месяце.
     */
    public int getMaxSteps(int month) {
        int max = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            if (monthToData[month].dayData[i] > monthToData[month].dayData[max]) {
                max = i;
            }
        }
        return monthToData[month].dayData[max];
    }
    /* Получаем сумму шагов за каждый день в выбранном месяце
    Делим сумму на количество дней (30)
    @return среднее значение шагов за выбранный месяц
     */
    public double getAverageSteps(int month) {
        double sum = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            sum += monthToData[month].dayData[i];
        }
        return sum / 30;
    }

    public double getDistance(int month) {
        Converter converter = new Converter();
        double distance = converter.convertTheDistance(sumMonthSteps(month));
        return distance;
    }

    public double getKilocalories(int month) {
        Converter converter = new Converter();
        double energy = converter.convertToCalories(sumMonthSteps(month));
        return energy;
    }

    public int sumMonthSteps(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            sum += monthToData[month].dayData[i];
        }
        return sum;
    }

    public int getBestSeries(int month) {
        int maxSeries = 0;
        int series = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            if (monthToData[month].dayData[i] >= goal) {
                series = series + 1;
                if (series > maxSeries) {
                    maxSeries = series;
                }
            } else {
                series = 0;
            }
        }
        return maxSeries;
    }


    class MonthData {
        int[] dayData = new int[30];
    }
}



