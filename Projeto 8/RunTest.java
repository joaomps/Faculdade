import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Profs de LabP
 * 
 * NAO PODE ALTERAR ESTA CLASSE
 *
 */


//-*- coding: utf-8 -*-
public class RunTest {

    private static BufferedReader in;
    private static BufferedReader decurso;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        
        //ficheiro com o registo dos pedidos inicial
        in = new BufferedReader( new FileReader(args[0]));
       
        //Registo da actividade do restaurante durante um periodo de tempo em
        //que decorre o servico
        out = new BufferedWriter( new FileWriter(args[1]));

        // ficheiro com o registo da evolucao do servico.
        decurso = new BufferedReader( new FileReader(args[2]));
        
        // Criacao de uma distribuicao de servico inicial com 4 cozinheiros
        DistServico boaPaparoca = new DistServico(4);
        // Leitura e distribuicao inicial do servico pelos cozinheiros
        boaPaparoca.leDistribui(in);
        // guarda o que vai ser escrito no ficheiro de output
        StringBuffer aEscrever = new StringBuffer();
        // eh o inicio do servico
        boolean inicio = true;

        //o servico decorre de acordo com o Buffer decurso
        String lido;
        Scanner operacao; 
        while((lido=decurso.readLine())!=null){
            operacao = new Scanner(lido).useDelimiter("-");
            switch (operacao.next()) {
            case "Prato Servido":  // serve prato 
                boaPaparoca.served(Integer.parseInt(operacao.next()));
                break;
            case "Novo Pedido": //processa novo pedido
                Scanner pedido = new Scanner(operacao.next()).useDelimiter(" ");
                boaPaparoca.request( pedido.next(),
                            Integer.parseInt(pedido.next()) );
                break;
            case "Redistribui"://redistribui o servico
                int nCoz = Integer.parseInt(operacao.next());
                boaPaparoca.reDistServico( nCoz);
                aEscrever.append( "O servico passa agora a ser distribuido por "
                                  + nCoz + " cozinheiros \n\n" );
                break;
            case "Report": //producao do relatorio
                if(inicio){
                    primeiroRegisto(aEscrever, boaPaparoca, operacao.next());
                    inicio = false;
                }
                else{
                    proximosRegistos(aEscrever, boaPaparoca, operacao.next());
                }
                break;
            }

        }

        out.write(aEscrever.toString());        
        in.close();
        out.close();

    }


    //escrita do 1o registo
    private static void primeiroRegisto(StringBuffer aEscrever, 
                                            DistServico boaPaparoca, String f) {
        aEscrever.append("Total de pedidos iniciais: " + boaPaparoca.total()
                + "\n");
        aEscrever.append("Distribuicao de pedidos iniciais:\n");
        aEscrever.append(boaPaparoca.toString() + "\n");


        aEscrever.append("O(s) cozinheiro(s) com tempo de servico superior a " 
                          + f +" minutos eh/sao:\n");
        aEscrever.append(maisAtarefados(boaPaparoca,Integer.parseInt(f)));
        aEscrever.append("\n");
        aEscrever.append("Para agora o tempo minimo de espera para um novo "
                            + "cliente ser servido: ");
        aEscrever.append(boaPaparoca.tempoMinimoEspera());
        aEscrever.append("\n\n");
            
    }

    //escrita de registos exeto o 1o
    private static void proximosRegistos(StringBuffer aEscrever, 
            DistServico boaPaparoca, String d) {
        aEscrever.append("Depois de algum tempo de servico a situacao " +
            "na cozinha eh:\n");
        aEscrever.append("Total de pedidos ainda ativos: " + boaPaparoca.total()
                          + "\n");
        aEscrever.append(boaPaparoca.toString()+"\n");
        aEscrever.append("Os cozinheiros com tempo de espera superior a " + d 
                          + " eh/sao:\n");
        aEscrever.append(maisAtarefados(boaPaparoca,Integer.parseInt(d))+"\n");
        aEscrever.append("Tempo minimo de espera para um novo cliente" 
                         + " ser servido: ");
        aEscrever.append(boaPaparoca.tempoMinimoEspera());
        aEscrever.append("\n\n");
    }

    //representacao em string dos cozinheiros com mais servico
    private static String maisAtarefados(DistServico servico, int i){
        StringBuilder result = new StringBuilder();
        Queue<String> listagem = new Queue<String>();
        listagem = servico.tempoSuperior(i);
        int k = listagem.size(); 
        for(int j=0; j<k; j++ ){
            String cozinheiro = listagem.front();
            listagem.dequeue();
            result.append("Cozinheiro " + cozinheiro + "\n");
        }
        return result.toString();
    }

}