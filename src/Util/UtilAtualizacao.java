/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author Analise em Curso
 */
public class UtilAtualizacao {

    //verifica se a conecsão de internet ativa
    public static boolean verificarConexão() {
        try {
            URL url = new URL("https://github.com/lauro17/Biscoiteria/blob/master/version.txt");
            URLConnection con = url.openConnection();
            con.connect();
            System.out.println("con verificarConexão : " + con);
            //return true;
            return false;
        } catch (MalformedURLException ex) {
//            System.out.println("MalformedURLException : " + ex);

            System.out.println("error na conexão");
            return false;
        } catch (IOException ex) {
//            System.out.println("MalformedURLException : " + ex);

            System.out.println("error na conexão");
            return false;
        }

    }
    //obtem a versão do sistema no servidor

    public static String ObtemVersao() {
        try {
            URL url = new URL("https://github.com/lauro17/Biscoiteria/blob/master/version.txt");
            URLConnection con = url.openConnection();
            con.connect();
            System.out.println("con : " + con);
            return ObtemCoteudoDaURL(url);
        } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException : " + ex);
        } catch (IOException ex) {
            System.out.println("MalformedURLException : " + ex);
        }
        return null;
    }

    //obtem o conteudo da url
    public static String ObtemCoteudoDaURL(URL url) {
        try {
            Scanner s = new Scanner(url.openStream()).useDelimiter("\\Z");
            String conteudo = s.next();
            System.out.println("conteudo : " + conteudo);
            return conteudo;
        } catch (MalformedURLException ex) {
            System.out.println("ObtemCoteudoDaURL : " + ex);
        } catch (IOException ex) {
            System.out.println("ObtemCoteudoDaURL : " + ex);
        }
        return null;
    }
    //metodo para abrir e redireciona para url

    public static void AbriURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
            System.out.println("AbriURL : " + url);
        } catch (URISyntaxException | IOException e) {
            System.out.println("AbriURL : " + e);
        }
    }

    //faz download de um arquivo
    public static File gravaArquivoDeURL(String stringUrl, String pathLocal) {
        try {
            //Encapsula a URL num objeto java.net.URL
            URL url = new URL(stringUrl);
            //Queremos o arquivo local com o mesmo nome descrito na URL
            //Lembrando que o URL.getPath() ira retornar a estrutura 
            //completa de diretorios e voce deve tratar esta String
            //caso nao deseje preservar esta estrutura no seu disco local.
            String nomeArquivoLocal = url.getPath();
            //Cria streams de leitura (este metodo ja faz a conexao)...
            InputStream is = url.openStream();
            //... e de escrita.
//            FileOutputStream fos = new FileOutputStream(pathLocal + nomeArquivoLocal);
            FileOutputStream fos = new FileOutputStream(pathLocal);
            //Le e grava byte a byte. Voce pode (e deve) usar buffers para
            //melhor performance (BufferedReader).
            int umByte = 0;
            while ((umByte = is.read()) != -1) {
                fos.write(umByte);
            }
            //Nao se esqueca de sempre fechar as streams apos seu uso!
            is.close();
            fos.close();
            //apos criar o arquivo fisico, retorna referencia para o mesmo
            return new File(pathLocal + nomeArquivoLocal);
        } catch (Exception e) {
            //Lembre-se de tratar bem suas excecoes, ou elas tambem lhe tratarão mal!
            //Aqui so vamos mostrar o stack no stderr.
            System.out.println("gravaArquivoDeURL : " + e); 
//            JOptionPane.showMessageDialog(parentComponent, "gravaArquivoDeURL : " +e);
            e.printStackTrace();
        }
        return null;
    }
}
