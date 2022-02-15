import java.util.HashMap;

public class StepTracker {
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    int TargetSteps =10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    int saveTargetStep(int targetStep) {
        if (targetStep > 0) {
            System.out.println("Данные сохранены !");
            TargetSteps=targetStep;
        } else {
            System.out.println("Введите кол.шагов заново");
            targetStep = 0;
        }
        return targetStep;
    }


    public class MonthData {
        HashMap<Integer, Integer> hashMap = new HashMap<>() ;
        public MonthData() {

            for (int i = 1; i < 31; i++) {
                if (!hashMap.containsKey(i)) {
                    hashMap.put(i, 0);
                }
            }
        }

        int saveStaps(int inputMonth, int inputDay, int inputSteps) {
            boolean d = (inputMonth<12)&&(inputDay<30);
            if (d){
                for (Integer month : monthToData.keySet()) {
                    if (month == inputMonth) {
                        for (Integer day : hashMap.keySet()) {
                            if (inputDay == day) {
                                hashMap.put(day,inputSteps);

                            }
                        }
                    }

                }
            }else {
                System.out.println("Введиет данные заново!");
                inputMonth=13;
            }
            return inputMonth;
        }

        int sumStepMonth(int inputMonth) {
            int sum = 0;
            for (Integer month : monthToData.keySet()) {
                if (month == inputMonth) {
                    for (Integer s:hashMap.values()){
                        sum+=s;
                    }
                }
            }

            return sum;
        }

        void statistic(int inputMonth) {
            for (Integer month : monthToData.keySet()) {
                if (month == inputMonth) {
                    for (Integer d :hashMap.keySet()) {
                        System.out.println(d + " день: " + hashMap.get(d));

                    }
                }
            }

            System.out.println("Общее кол шагов за месяц: "+ monthData.sumStepMonth(inputMonth));
            System.out.println("Максимальное пройденное количество шагов в месяце: "+ monthData.maxStepMonth(inputMonth));
            monthData.averageSteps(inputMonth);
            converter.distance(monthData.sumStepMonth(inputMonth));
            converter.wastingCall(monthData.sumStepMonth(inputMonth));
            System.out.println("Лучшая серия: "+ monthData.bestDaySeries(inputMonth));



        }

        int maxStepMonth(int inputMonth){
            int max = 0;
            for (Integer month : monthToData.keySet()) {
                if (month == inputMonth) {
                    for (Integer s:hashMap.values()){
                            if (s>max){
                                max=s;
                            }
                    }

                }

            }
            return max;

        }

        void averageSteps(int inputMonth) {
            double sum = 0;
            double avgStep = 0;
            int size=hashMap.size();
            for (Integer month : monthToData.keySet()) {
                if (month == inputMonth) {
                    for (Integer s:hashMap.values()){
                        sum+=s;
                    }
                    avgStep =sum/size;
                }

            }

            String steps=String.format("Среднее количество шагов в месяце: %.0f ",avgStep);
            System.out.println(steps);

        }

        int bestDaySeries(int inputMonth) {
            int startserise = 0;
            int maxserise=0;
            for (Integer month : monthToData.keySet()) {
                if (month == inputMonth) {
                    for (Integer day : hashMap.values()) {
                        if (day >=TargetSteps){
                            startserise++;
                        }else {
                            if (startserise>maxserise){
                                maxserise=startserise;
                            }
                            startserise=0;
                        }

                    }
                    if (startserise>maxserise){
                        maxserise=startserise;
                    }
                }
            }
            return maxserise;
        }
     }
    }
