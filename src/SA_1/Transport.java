package SA_1;

public class Transport {

    int fuel;
    int speed;
    int speedChange;
    String[] status = new String[2];
    String curStatus = "";
    boolean racestart;
    boolean raceEnd;

    // 생성자
    public Transport(){
        this.fuel = 100;
        this.speedChange = 0;
        this.status[0] = "운행";
        this.status[1] = "차고지행";
        this.racestart = true;
        this.curStatus = status[0];
        this.stateChange();
    }

    // 운행시작
    public void raceStart(){
        System.out.println("운행 시작 하겠습니다!!");
        this.curStatus = status[0];
        this.raceEnd = false;
        this.racestart = false;
    }

    // 속도변경
    public void spChange(int num) {
        this.speedChange = num;
        this.speed += this.speedChange;
        if (this.speed < 0) this.speed = 0;
        if (fuel <= 10) this.stateChange();
        System.out.println("현재속도 : " + this.speed);
        System.out.println("현재연료 :  " + this.fuel);
    }

    void fuelChange(int num) {
        this.fuel = this.fuel + num;
    }

    // 상태 변경
    public void stateChange(){
        if (racestart == true) {
            this.raceStart();
        }
        if (fuel <= 10) {
            System.out.println("주유필요!!");
            this.curStatus = status[1];
        }
        if (raceEnd == true) {
            this.curStatus = status[1];
        }
    }

    // 승객 탑승
    public void passengerBoarding() {
        System.out.println("승객이 탑승하셨습니다!");
    }


}
