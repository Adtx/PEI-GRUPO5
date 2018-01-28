import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Normalize {

    //makes a vector of length one
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

    //scales points with the given mean and standard deviation to have mean of zero and deviation of one
    public void normalize(double a[], double mean[], double deviation[]){
        for(int k=0;k<a.length;k++){
            a[k] = (a[k]-mean[k])/deviation[k];
            System.out.println(a[k]);
        }
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
