package SA_1;

public class Main {

    public static void main(String[] args) {

        Bus b1 = new Bus(1);
        System.out.println();
        Bus b2 = new Bus(2);

        System.out.println();

        // 승객 +2
        b1.passengerBoard(2);
        System.out.println("탑승 승객수 : " + b1.curPassenger);
        System.out.println("잔여 승객수 : " + b1.maxPassenger);
        System.out.println("요금 확인 : " + b1.resultFee);
        System.out.println();

        // 주유량 -50
        b1.fuelChange(-50);
        System.out.println("주유량 : " + b1.fuel);
        System.out.println();

        // 상태변경 차고지행
        b1.raceEnd = true;
        b1.passengerBoard(0);

        // 주유량 +10
        b1.fuelChange(10);

        // 출력 Bus
        System.out.println("상태 : " + b1.curStatus);
        System.out.println("주유량 : " + b1.fuel);
        System.out.println();

        // 상태 변경 - 운행중
        b1.racestart = true;
        b1.stateChange();
        System.out.println();

        // 승객 +45
        b1.passengerBoard(45);
        System.out.println();

        // 승객 +5
        b1.passengerBoard(5);

        // 출력 Bus
        System.out.println("탑승 승객수 : " + b1.curPassenger);
        System.out.println("잔여 승객수 : " + b1.maxPassenger);
        System.out.println("요금 확인 : " + b1.resultFee);
        System.out.println();

        // 알럿 '주유 필요'!!


        System.out.println("-----------------------");


        Taxi t1 = new Taxi(1);
        System.out.println();
        Taxi t2 = new Taxi(2);

        System.out.println();

        // 승객+2, 목적지 : 서울역, 목적지까지의 거리 : 2km
        t1.passengerBoard(2, "서울역", 2);

        // 출력 Taxi
        System.out.println("탑승 승객 수 : " + t1.curPassenger);
        System.out.println("잔여 승객 수 : " + t1.leftPassenger);
        System.out.println("기본 요금 확인 : " + t1.basicFee);
        System.out.println("목적지 : " + t1.destnation);
        System.out.println("목적지까지의 거리 : " + t1.destinationDistance);
        System.out.println("지불할 요금 : " + t1.payFee);
        System.out.println("상태 : " + t1.curStatus);
        t1.quitPassenger();
        System.out.println();

        // 주유량 -80
        t1.fuelChange(-80);

        // 출력
        System.out.println("주유량 : " + t1.fuel);
        System.out.println("누적요금 : " + t1.resultFee);
        System.out.println();

        // 승객+5
        t1.passengerBoard(5, "",2);
        t1.quitPassenger();

        // 승객+3, 목적지 : 구로디지털단지역, 목적지까지의 거리 : 12km
        t1.passengerBoard(3, "구로디지털단지역", 12);

        // 출력
        System.out.println("탑승 승객 수 : " + t1.curPassenger);
        System.out.println("잔여 승객 수 : " + t1.leftPassenger);
        System.out.println("기본 요금 확인 : " + t1.basicFee);
        System.out.println("목적지 : " + t1.destnation);
        System.out.println("목적지까지의 거리 : " + t1.destinationDistance);
        System.out.println("지불할 요금 : " + t1.payFee);
        t1.quitPassenger();
        System.out.println();

        // 주유량 -20
        t1.fuelChange(-20);

        // 출력
        System.out.println("주유량 : " + t1.fuel);
        System.out.println("상태 : " + t1.curStatus);
        System.out.println("누적 요금 : " + t1.resultFee);






    }
}
