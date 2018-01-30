import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Normalize {

    double[] mean;
    double[] deviation;

    public Normalize(){
        mean=new double[]{171.00166666666667,9.165,258.9916666666667,24.276666666666667,779.7766666666666,
                134.27333333333334,106.11333333333333,72.175,0.4505973929482142,5.285055506989993,0.6927194252462098,7.925754693538253,5.604354889822008,0.9243906491355307,0.9502844573547825,1.487680051854988,7.925754693538253,6.822362581359574,97.13833333333334,91.915,65.865,47.06,31.84,20.716666666666665,6.737270630179899,4.04,1.085};

        deviation=new double[]{120.76138316485486,6.463057197126861,189.572883777952,20.97721276899188,568.7036897971466,96.57336738919737,63.58598238256258,47.17662954260293,0.07423983267248627,1.7836823295960984,0.12024169776374617,2.1222789495831402,1.5006778368197013,0.026145522394780542,0.015115974478297557,0.25919786589699445,2.1222789495831402,5.57306228149882,70.3591443752852,65.97656989416772,48.16527215397696,34.56920209280704,23.81640331088357,15.424322423439614,5.106420728395281,4.71434689714987,1.731408386256691};
    }



    //makes a vector of length one
    /*
    public void normalize(double a[]){
        double scale = 0 ;
        for(int k=0;k<a.length;k++){
            scale+=a[k]*a[k];
        }
        scale = 1/Math.sqrt(scale);
        for(int k=0;k<a.length;k++){
            a[k]*=scale ;
            System.out.println(a[k]);
        }
    }
    */

    //scales points with the given mean and standard deviation to have mean of zero and deviation of one
    public double[] normalize(double a[], double mean[], double deviation[]){
        for(int k=0;k<a.length;k++){
            a[k] = (a[k]-mean[k])/deviation[k];
            //System.out.println(a[k]);
        }
        return a;
    }

    public double[] normalize(double a[]){
        for(int k=0;k<a.length;k++){
            a[k] = (a[k]-mean[k])/deviation[k];
            //System.out.println(a[k]);
        }
        return a;
    }

    //scales points with the given mean and standard deviation to have mean of zero and deviation of one
    public ArrayList<Double> normalize(ArrayList<Double> a, Double mean[], Double deviation[]){
        //System.out.println("normalize tamanho do a: "+ a.size());
        ArrayList<Double> res= new ArrayList<>();
        for(int k=0;k<a.size();k++){
            double b = (a.get(k)-mean[k])/deviation[k];
            res.add(b);
        }
        return res;
    }

    public double deviation(double  a[],double avg){
        double res=0;
        for(int i=0;i<a.length;i++){
            res=res+(abs(a[i]-avg)*abs(a[i]-avg));
        }
        res=sqrt(res/a.length);
        return res;
    }

    public double deviation(ArrayList<Double>  a,double avg){
        double res=0;
        for(Double i:a){
            res=res+(abs(i-avg)*abs(i-avg));
        }
        res=sqrt(res/a.size());
        return res;
    }

    public double mean(double a[]){
        double res=0;
        for(int i=0;i<a.length;i++){
            res=res+a[i];
        }
        return res/a.length;

    }

    public double mean(ArrayList<Double> a){
        double res=0;
        for(double i:a){
            res=res+i;
        }
        return res/a.size();

    }

    public static float normalise(float inValue, float min, float max) {
        return (inValue - min)/(max - min);
    }

    //returns a normally distributed random vector using the box muller transform
    public double[] normaldistribution(int dim, Random rand){
        double[] axis = new double[dim];
        //generate a normally distributed random vector using the Box-Muller transform to guarantee even distrubtion of directions
        for (int k = 0; k < dim; k++){
            axis[k] = Math.sqrt(-2 * Math.log(rand.nextDouble())) * Math.sin(2 * Math.PI * rand.nextDouble());
        }
        return axis;
    }
}
