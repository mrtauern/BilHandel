import java.util.*;
import java.io.*;

public class BilHandel{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Bil> biler = new ArrayList<Bil>();
        biler.add(new Bil("Sherman", 550));
        biler.add(new Bil("Kia C'eed", 120));
        biler.add(new Bil("Bugatti Veyron", 1000));
        biler.add(new Bil("Jaguar F-Type", 600));

        for (Bil b : biler){
            b.printInfo();
        }

        Bil minBil = new Bil("Fiat Punto", 60);
        FileOutputStream fileOut = new FileOutputStream("txt//bil.ser");
        ObjectOutputStream output = new ObjectOutputStream(fileOut);
        output.writeObject(minBil);
        output.close();
        fileOut.close();
        System.out.println("Bil gemt i bil.ser");

        Bil minAndenBil = new Bil("Ford Mustang", 255);
        minAndenBil.printInfo();

        FileInputStream fileIn = new FileInputStream("txt//bil.ser");
        ObjectInputStream input = new ObjectInputStream(fileIn);
        minAndenBil = (Bil) input.readObject();
        input.close();
        fileIn.close();

        minAndenBil.printInfo();

        //gem biler til fil med serializable
        FileOutputStream fo = new FileOutputStream("txt//biler.ser");
        ObjectOutputStream out = new ObjectOutputStream(fo);
        out.writeObject(biler);
        out.close();
        fo.close();
        System.out.println("biler skrevet til biler.ser");

        //hent biler fra fil med serializable
        ArrayList<Bil> nyeBiler = new ArrayList<Bil>();

        FileInputStream fi = new FileInputStream("txt//biler.ser");
        ObjectInputStream in = new ObjectInputStream(fi);
        nyeBiler = (ArrayList<Bil>) in.readObject();
        in.close();
        fi.close();

        for (Bil b : nyeBiler){
            b.printInfo();
        }
    }

}