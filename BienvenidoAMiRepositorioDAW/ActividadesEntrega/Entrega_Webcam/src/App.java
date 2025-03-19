package src;

public class App {
    public static void main(String[] args) {
        Webcam webcam = new Webcam("1920x1080", 30);
        webcam.takePhoto();
        webcam.turnOn();
        webcam.takePhoto();
        webcam.turnOff();
    }
}
