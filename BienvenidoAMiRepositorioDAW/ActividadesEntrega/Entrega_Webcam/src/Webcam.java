package ActividadesEntrega.Entrega_Webcam.src;

public class Webcam {
    
    private String resolution;
    private int fps;
    private boolean isActive;
    private double imgSize;

    public Webcam( String resolution, int fps) {
        this.resolution = resolution;
        this.fps = fps;
        this.isActive = false;
    }

    public String getResolution() {
        return resolution;
    }

    public int getFps() { 
        return fps;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getImgSize() {
        return imgSize;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setImgSize(double imgSize) {
        this.imgSize = imgSize;
    }

    public void turnOn() {
        this.isActive = true;
        System.out.println("Webcam is on");
    }

    public void turnOff() {
        this.isActive = false;
        System.out.println("Webcam is off");
    }

    public double calcSize() {
        String [] dimensions = (resolution.split("x"));  
        double width = Double.parseDouble(dimensions[0]);
        double height = Double.parseDouble(dimensions[1]);
        imgSize = (width * height * fps) / 1000000;
        return imgSize;
    }

    public void takePhoto() {
        if (isActive){
            calcSize();
            System.out.println("Photo taken \n" + 
            "Resolution: " + resolution.split("x")[0] + "x" + resolution.split("x")[1] + "\n" +
            "Stimated size: " + imgSize + "MB");
        } else {
            System.out.println("Couldn't take a photo webcam is off");
        }
    }
}