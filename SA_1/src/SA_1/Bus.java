package SA_1;

public class Bus extends Transport{
    // 1. 최대 승객수, 2. 현재 승객수, 3. 요금, 4. 버스 번호, 5. 주유량, 6. 현재 속도, 7. 상태 : 1_운행, 2_차고지행

    int number;
    int maxPassenger;
    int curPassenger;
    int fee;
    int resultFee;


    Bus(int number){
        this.number = number;
        this.maxPassenger = 30;
        this.curPassenger = 0;
        this.fee = 1000;


        System.out.println("이 버스의 번호는 " + this.number + "입니다!");
    }

    void passengerBoard(int num) {
        // 부모 클래스꺼!!

        if (raceEnd == true) {
            this.curPassenger = 0;
            this.maxPassenger = 30;
            this.resultFee  = 0;
        }
        else if (this.curPassenger + num > this.maxPassenger) {
            System.out.println("최대 탑승인원 초과입니다! 내리세요!!");
        }
        else {
            this.curPassenger += num;
            this.maxPassenger -= num;
            this.resultFee += this.fee * num;
        }
    }







}
