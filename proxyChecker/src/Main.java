//Выявить рабочие адреса и записать их в файл good_ip

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://Users/User/Desktop/project/edu_0759/proxyChecker/ip.txt");
            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    checkProxy(ip, Integer.parseInt(port));
                    proxy = "";
                }else if(i!=9){
                    proxy += (char) i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void checkProxy(String ip, int port){
        List<String> goodIps = new ArrayList();
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection urlConnection = url.openConnection(proxy);

            urlConnection.setConnectTimeout(10000);
            urlConnection.connect();
            goodIps.add(ip+":"+port);

            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int i;
            StringBuilder result = new StringBuilder();
            while ((i=reader.read()) != -1){
                result.append((char)i);
            }
            System.out.println(result);
        } catch (IOException exception) {
            System.out.println(ip+ " - не работает!");
        }
        Writer writer = null;
        try {
            writer = new FileWriter("C://Users/User/Desktop/project/edu_0759/proxyChecker/good_ip.txt" ,true);
            for (String line : goodIps){
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e){

        }
    }
}