 package arnold.example.com.datosdetiempo;

import arnold.example.com.datosdetiempo.util.Conversor;

public class clima {
    private double temperatura_maxima;
    private double temperatura_minima;
    private  double temperatura_actual;
    private int imageNumber;

    public clima(double temperatura_maxima, double temperatura_minima, double temperatura_actual) {
        this.temperatura_maxima = temperatura_maxima;
        this.temperatura_minima = temperatura_minima;
        this.temperatura_actual = temperatura_actual;
    }


    public double getTemperatura_maxima() {
        return temperatura_maxima;
    }

    public void setTemperatura_maxima(double temperatura_maxima) {
        this.temperatura_maxima = temperatura_maxima;
    }

    public double getTemperatura_minima() {
        return temperatura_minima;
    }

    public void setTemperatura_minima(int temperatura_minima) {
        this.temperatura_minima = temperatura_minima;
    }

    public double getTemperatura_actual() {
        return temperatura_actual;
    }

    public String getmin(){
        return Conversor.kelvinToCelsius(temperatura_minima)+" ";


    }

    public void setTemperatura_actual(int temperatura_actual) {
        this.temperatura_actual = temperatura_actual;
    }

    public String  getactual() {
        return Conversor.kelvinToCelsius(temperatura_actual)+" ";
    }

    public String getmax() {
        return Conversor.kelvinToCelsius(temperatura_maxima)+" ";
    }

    public int getImageNumber(){
        return imageNumber;
    }
    public void setImageNumber(int imageNumber){
        this.imageNumber = imageNumber;
    }
}
