package Projeto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    BufferedWriter out;

    in     = new BufferedReader( new FileReader("votos") );
    out    = new BufferedWriter( new FileWriter("mandatos") );

    Hondt mH = new Hondt();
    mH.leVotacao(in);
    mH.calculaMandatos();
    mH.escreveResultado(out);

    in.close();
    out.close();
    
  }
}