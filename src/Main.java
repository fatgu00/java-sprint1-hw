

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
                int InputMonth = scanner.nextInt();
                System.out.println("Введиет день");
                int InputDay = scanner.nextInt();
                System.out.println("Введиет количество шагов");
                int InputSteps = scanner.nextInt();
                stepTracker.monthData.SaveStaps(InputMonth,InputDay,InputSteps);
                // boolean d=(InputMonth<12)&&(InputDay<30);


                // while (!d){
                    //     System.out.println("Введите месяц");
                    //     InputMonth = scanner.nextInt();
                    //     System.out.println("Введиет день");
                    //     InputDay = scanner.nextInt();
                    //     System.out.println("Введиет количество шагов");
                    //     InputSteps = scanner.nextInt();

                    //     stepTracker.monthData.SaveStaps(InputMonth,InputDay,InputSteps);


                    // }



            }else if(userInput == 2){
                System.out.println("Введите месяц");
                int InputMonth = scanner.nextInt();
                stepTracker.monthData.Statistic(InputMonth);

            }else if(userInput==3){
                System.out.println("Введите цель!");

                    int targetStep = scanner.nextInt();
                    stepTracker.SaveTargetStep(targetStep);
                    while (targetStep<0){
                        targetStep = scanner.nextInt();
                        stepTracker.SaveTargetStep(targetStep);
                    }

            }else {
                System.out.println("Такай команды нет. ");
            }



            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {

        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}

