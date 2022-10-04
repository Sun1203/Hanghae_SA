package SA_1;

public class Taxi extends Transport{

    String destnation;
    int destinationDistance;
    int basicDistance;
    int basicFee;
    int meterFee;
    int maxPassenger;
    int curPassenger;
    int resultFee;
    int leftPassenger;
    int payFee;



    Taxi(int number) {
        this.maxPassenger = 4;
        this.basicFee = 3000;
        this.meterFee = 1000;
        this.basicDistance = 1;
        this.curPassenger = 0;
        this.curStatus = "";
        this.resultFee = 0;
        this.leftPassenger = 0;
        this.payFee = 0;

        System.out.println(number + "번 택시입니다!");
    }

    void passengerBoard(int num, String destnation, int destinationDistance){
        this.curStatus = "운행중";
        if (this.curPassenger + num > this.maxPassenger) {
            System.out.println("최대 탑승인원 초과입니다! 내리세요!!");
        }
        else {
            this.destinationDistance = destinationDistance;
            this.destnation = destnation;
            this.curPassenger += num;
            this.leftPassenger = this.maxPassenger - this.curPassenger;
            if (basicDistance < destinationDistance){
                this.payFee = basicFee + (destinationDistance - basicDistance) * meterFee;
            }
            else {
                this.payFee = basicFee;
            }
            this.resultFee += this.payFee;
        }

    }

    @Override
    void fuelChange(int num){
        this.fuel += num;
        if (fuel <= 10) {
            System.out.println("주유 필요!!");
            this.curStatus = "운행 불가";
        }
    }

    void feePay(){
        if (basicDistance < destinationDistance){
            this.payFee = basicFee + (destinationDistance - basicDistance) * meterFee;
        }
        else {
            this.payFee = basicFee;
        }
        this.curStatus = "일반";
    }

    void quitPassenger(){
        this.payFee = 0;
        this.curPassenger = 0;
        this.leftPassenger = 0;
    }





}
