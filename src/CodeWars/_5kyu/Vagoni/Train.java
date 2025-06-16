package CodeWars._5kyu.Vagoni;

public class Train {
    private boolean[] lights;
    private int current;

    public Train(boolean[] lights) {
        this.lights = lights;
        this.current = 0;
    }

    public boolean isLightOnInCurrentWagon() {
        return lights[current];
    }

    public void switchLight() {
        lights[current] = !lights[current];
    }

    public void goToNextWagon() {
        current = (current + 1) % lights.length;
    }

    public void goToPreviousWagon() {
        current = (current - 1 + lights.length) % lights.length;
    }

    public void printTrain() {
        for (int i = 0; i < lights.length; i++) {
            System.out.print((lights[i] ? "1" : "0") + (i < lights.length - 1 ? " : " : ""));
        }
        System.out.println();
    }
}