package hibernate;

/**
 * Created by andrepinto on 03/02/18.
 */
public class FullTest1 {


    private String designation;

    private int result;

    private String candidateName;

    private String response;

    private int responseID;

    private int day;
    private int month;
    private int year;


    private String metric1;
    private String metric2;
    private String metric3;
    private String metric4;
    private String metric5;
    private String metric6;


    public FullTest1(){}


    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getDesignation(){return designation;}

    public void setDesignation(String s){designation =s;}

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setResponseID(int responseID) {
        this.responseID = responseID;
    }

    public int getResponseID() {
        return responseID;
    }

    public String getResponse() {
        return response;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMetric1(String metric1) {
        this.metric1 = metric1;
    }

    public String getMetric1() {
        return metric1;
    }

    public void setMetric2(String metric2) {
        this.metric2 = metric2;
    }

    public String getMetric2() {
        return metric2;
    }

    public void setMetric3(String metric3) {
        this.metric3 = metric3;
    }

    public String getMetric3() {
        return metric3;
    }

    public void setMetric4(String metric4) {
        this.metric4 = metric4;
    }

    public String getMetric4() {
        return metric4;
    }

    public void setMetric5(String metric5) {
        this.metric5 = metric5;
    }

    public String getMetric5() {
        return metric5;
    }

    public void setMetric6(String metric6) {
        this.metric6 = metric6;
    }

    public String getMetric6() {
        return metric6;
    }
}
