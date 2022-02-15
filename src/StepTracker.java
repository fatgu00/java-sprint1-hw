
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


    int SaveTargetStep(int targetStep) {


        if (targetStep > 0) {

            System.out.println("Данные сохранены !");
            TargetSteps=targetStep;
            System.out.println(targetStep);


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
        int SaveStaps(int InputMonth, int InputDay, int InputSteps) {
            boolean d = (InputMonth<12)&&(InputDay<30);
            if (d){
                for (Integer month : monthToData.keySet()) {
                    if (month == InputMonth) {
                        for (Integer day : hashMap.keySet()) {
                            if (InputDay == day) {
                                hashMap.put(day,InputSteps);

                            }
                        }
                    }

                }
            }else {
                System.out.println("Введиет данные заново!");
                InputMonth=13;
            }
            return InputMonth;
        }

        int SumStepMonth(int InputMonth) {
            int sum = 0;
            for (Integer month : monthToData.keySet()) {
                if (month == InputMonth) {
                    for (Integer s:hashMap.values()){
                        sum+=s;
                    }
                }
            }

            return sum;
        }

        void Statistic(int InputMonth) {
            for (Integer month : monthToData.keySet()) {
                if (month == InputMonth) {
                    for (Integer d :hashMap.keySet()) {
                        System.out.println(d + " день: " + hashMap.get(d));

                    }
                }
            }

            System.out.println("Общее кол шагов за месяц: "+ monthData.SumStepMonth(InputMonth));
            System.out.println("Максимальное пройденное количество шагов в месяце: "+ monthData.MaxStepMonth(InputMonth));
            monthData.AverageSteps(InputMonth);
            converter.Distance(monthData.SumStepMonth(InputMonth));
            converter.wastingCall(monthData.SumStepMonth(InputMonth));
            System.out.println("Лучшая серия: "+ monthData.BestDaySeries(InputMonth));



        }

        int MaxStepMonth(int InputMonth){
            int max = 0;
            for (Integer month : monthToData.keySet()) {
                if (month == InputMonth) {
                    for (Integer s:hashMap.values()){
                            if (s>max){
                                max=s;
                            }
                    }

                }

            }
            return max;

        }

        void AverageSteps(int InputMonth) {
            double sum = 0;
            double avgStep = 0;
            int size=hashMap.size();
            for (Integer month : monthToData.keySet()) {
                if (month == InputMonth) {
                    for (Integer s:hashMap.values()){
                        sum+=s;
                    }
                    avgStep =sum/size;
                }

            }

            String steps=String.format("Среднее количество шагов в месяце: %.0f ",avgStep);
            System.out.println(steps);

        }
        int BestDaySeries(int InputMonth) {
            int startserise = 0;
            int maxserise=0;
            for (Integer month : monthToData.keySet()) {
                if (month == InputMonth) {
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

















