public class Converter {

    void wastingCall(int stepTracker){

        float Call=stepTracker*50;
        if (Call>1000){
            float KCall = Call/1000;
            System.out.println("За этот месяц вы сожгли " + KCall +" килокалорий");
        }else {
            System.out.println("За этот месяц вы сожгли " + Call +" калорий");
        }
    }
    void Distance(int stepTracker) {

        float distans= stepTracker *75;
        if (distans>100000) {
            float k = (distans/100000); //123455
            String km=String.format("За этот месяц вы прошли: %.3f километров",k);
            System.out.println(km);
        }else if(distans>100){
            float m = (distans/100);
            String metr=String.format("За этот месяц вы прошли: %.2f метров",m);
            System.out.println(metr);
        }else {

            System.out.println("За этот месяц вы прошли: "+ distans + " сантиметров");
        }


    }
}
