import java.io.Serializable;

public class Temperatur implements Serializable {
    private int monat;
    private double temperatur;

    public Temperatur(int m, double t){
        monat = m;
        temperatur = t;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public int getMonat() {
        return monat;
    }
}
