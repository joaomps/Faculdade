package Projeto1;
import java.io.*;
/**
 * 
 * @author Profs de LabP
 * 
 * NAO PODE ALTERAR ESTA CLASSE
 *
 */
public class RunTests {

  public static void main(String[] args) throws IOException {

    BufferedReader in;
    BufferedReader orders;
    BufferedWriter out;

    // testing remove
    in     = new BufferedReader( new FileReader("text") );
    orders = new BufferedReader( new FileReader("order_remove") );
    out    = new BufferedWriter( new FileWriter("out_remove") );

    FileTools.removeLetters(orders,in,out);

    in.close();
    out.close();
    orders.close();

    // testing capitalize
    in     = new BufferedReader( new FileReader("text") );
    orders = new BufferedReader( new FileReader("order_capitalize") );
    out    = new BufferedWriter( new FileWriter("out_capitalize") );

    FileTools.capitalize(orders,in,out);

    in.close();
    out.close();
    orders.close();
    
    // testing occurrences
    in     = new BufferedReader( new FileReader("text") );
    out    = new BufferedWriter( new FileWriter("out_occurrences") );

    FileTools.occurrences(in,out);

    in.close();
    out.close();

  }
}