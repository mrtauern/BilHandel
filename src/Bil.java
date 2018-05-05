import java.io.*;

public class Bil implements BilInfo, Serializable{

    private String model;
    private int power;

    //constructor
    public Bil(String mod, int pow){
        this.model = mod;
        this.power = pow;
    }

    //getters & setters
    public void setPower(int pow){
        this.power = pow;
    }

    public int getPower(){
        return power;
    }

    //check mærke
    public void checkModel(){
        System.out.println("Model: " + model);
    }

    //pæn print
    public String toString(){
        return model + ": " + power + " hk";
    }

    //printInfo fra BilInfo interface
    public void printInfo(){
        checkModel();
        System.out.println(power + " hk");
    }

}