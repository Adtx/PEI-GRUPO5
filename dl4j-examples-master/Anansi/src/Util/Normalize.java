package Util;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Normalize {

    double[] mean;
    double[] deviation;

    public Normalize(){
        mean=new double[]{170.3046357615894,9.117549668874172,257.97682119205297,24.19701986754967,776.6423841059602,133.67218543046357,105.7135761589404,71.88741721854305,0.4505763295373439,5.273221306666615,0.6929284162842501,7.910449611500564,5.5935325625265415,0.9243717647492141,0.9502302388251881,1.4870503985389283,7.910449611500564,6.790684133001317,96.72847682119205,91.50662251655629,65.57615894039735,46.87251655629139,31.736754966887418,20.632450331125828,6.708167713380977,4.043046357615894,1.0811258278145695};

        deviation=new double[]{120.68492410264852,6.468294294632094,189.39736983694738,20.938160077002973,568.2335075747822,96.54816500973526,63.577004577536854,47.16074990646176,0.07404834963957178,1.784406852592236,0.11999259916986162,2.124402709442651,1.5021795618179734,0.02608446460693618,0.015088996248932719,0.2586687272434877,2.124402709442651,5.568550610194808,70.3169912275534,65.95788056875698,48.14096121636609,34.53674460779463,23.775340055775718,15.409767478160628,5.102480087423248,4.703612954492059,1.7277559012678945};
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
        for(int k=0;k<27;k++){
            a[k] = (a[k]-mean[k])/deviation[k];
            //System.out.println(a[k]);
        }
        return a;
    }

    public ArrayList<Double> normalize(ArrayList<Double> a){
        int k=0;
        ArrayList<Double> res = new ArrayList<Double>();
        for(Double d :a){
            res.add((d-mean[k])/deviation[k]);
            k++;
        }
        return res;
    }

    //scales points with the given mean and standard deviation to have mean of zero and deviation of one
    public ArrayList<Double> normalize(ArrayList<Double> a, Double mean[], Double deviation[]){
        //System.out.println("normalize tamanho do a: "+ a.size());
        ArrayList<Double> res= new ArrayList<>();
        for(int k=0;k<a.size();k++){
            double b = (a.get(k)-mean[k])/deviation[k];
            System.out.println(b);
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
