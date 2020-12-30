public class TVCR extends TV1 {
    VCR vcr = new VCR(); // VCR클래스를 포함시켜 사용한다.
    int counter = vcr.counter;

    void play() {
        vcr.play();
    }
    void stop() {
        vcr.stop();
    }
    void rew() {
        vcr.rew();
    }
    void ff() {
        vcr.ff();
    }
}

class TV1 {
    boolean power;
    int channel;
    void power() {power=!power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}
}
class VCR {
    boolean power;
    int counter = 0;
    void power() {power=!power;}
    void play() {}
    void stop() {}
    void rew() {}
    void ff() {}
}