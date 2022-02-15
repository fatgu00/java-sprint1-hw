

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if(userInput==1){

                System.out.println("Введите месяц");
                int inputMonth = scanner.nextInt();
                System.out.println("Введиет день");
                int inputDay = scanner.nextInt();
                System.out.println("Введиет количество шагов");
                int inputSteps = scanner.nextInt();
                stepTracker.monthData.saveStaps(inputMonth,inputDay,inputSteps);

            }else if(userInput == 2){
                System.out.println("Введите месяц");
                int inputMonth = scanner.nextInt();
                stepTracker.monthData.statistic(inputMonth);

            }else if(userInput==3){
                System.out.println("Введите цель!");

                    int targetStep = scanner.nextInt();
                    stepTracker.saveTargetStep(targetStep);
                    while (targetStep<0){
                        targetStep = scanner.nextInt();
                        stepTracker.saveTargetStep(targetStep);
                    }

            }else {
                System.out.println("Такай команды нет. ");
            }



            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        scanner.close();
        System.out.println("Программа завершена");
    }

    private static void printMenu() {

        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}
