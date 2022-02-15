public class Converter {

    void wastingCall(int stepTracker){
        final int oneStepsCall = 50 ;
        float Call=stepTracker * oneStepsCall;
        if (Call>1000){
            float KCall = Call/1000;
            System.out.println("За этот месяц вы сожгли " + KCall +" килокалорий");
        }else {
            System.out.println("За этот месяц вы сожгли " + Call +" калорий");
        }
    }
    void distance(int stepTracker) {
        final int oneStepsSantimetr = 75;
        float distans= stepTracker * oneStepsSantimetr;
        if (distans>100000) {
            float km = (distans/100000);
            String kilometer=String.format("За этот месяц вы прошли: %.3f километров",km);
            System.out.println(kilometer);
        }else if(distans>100){
            float m = (distans/100);
            String metr=String.format("За этот месяц вы прошли: %.2f метров",m);
            System.out.println(metr);
        }else {

            System.out.println("За этот месяц вы прошли: "+ distans + " сантиметров");
        }
    }
}
