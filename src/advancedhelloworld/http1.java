/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author JNICOLAS
 */
public class http1 implements Runnable {

    
    public static void main(String[] s) throws Exception {

        //Https or not?
        Boolean HTTPS = false, file = false; String CONTENT="";



// js:document.body.innerText.match(/([0-9]{1,3}\.)+[0-9]{1,3}\:[0-9]{1,7}/gi).join(';')
//IMPROVED:
//JS:Array.prototype.map.call(document.body.innerText.match(/([0-9]{1,3}\.)+[0-9]{1,3}(\:|\s{1,3})[0-9]{1,7}/gi),function(x){return x.replace(/\s+/gi,":")}).join(';')
//        String noob = "188.26.131.173:8080;188.26.131.173:8080;152.92.137.18:8080;152.92.137.18:8080;152.92.137.18:8080;82.208.58.119:80;82.208.58.119:80;82.208.58.119:80;201.187.107.26:80;201.187.107.26:80;201.187.107.26:80;178.33.181.120:8080;178.33.181.120:8080;178.33.181.120:8080;201.187.107.27:80;201.187.107.27:80;201.187.107.27:80;141.0.169.12:3128;141.0.169.12:3128;141.0.169.12:3128;122.160.17.121:3128;122.160.17.121:3128;122.160.17.121:3128;71.190.195.124:3128;71.190.195.124:3128;71.190.195.124:3128;71.8.238.154:80;71.8.238.154:80;71.8.238.154:80;49.0.96.48:80;49.0.96.48:80;49.0.96.48:80;217.16.9.173:3128;217.16.9.173:3128;217.16.9.173:3128;41.202.160.190:80;41.202.160.190:80;41.202.160.190:80;199.21.149.33:3128;199.21.149.33:3128;199.21.149.33:3128;186.101.65.115:80;186.101.65.115:80;186.101.65.115:80;112.133.201.69:3128;112.133.201.69:3128;112.133.201.69:3128;198.27.117.187:143;198.27.117.187:143;198.27.117.187:143;198.27.100.200:3128;198.27.100.200:3128;198.27.100.200:3128;211.167.112.15:82;211.167.112.15:82;211.167.112.15:82;211.167.112.14:80;211.167.112.14:80;211.167.112.14:80;78.9.46.148:3128;78.9.46.148:3128;78.9.46.148:3128;95.80.92.52:3128;95.80.92.52:3128;95.80.92.52:3128;72.18.151.70:80;72.18.151.70:80;72.18.151.70:80;93.166.121.107:8118;93.166.121.107:8118;93.166.121.107:8118;115.25.216.6:80;115.25.216.6:80;115.25.216.6:80;198.27.126.139:8080;198.27.126.139:8080;198.27.126.139:8080;146.255.9.124:3128;146.255.9.124:3128;146.255.9.124:3128;173.213.108.113:3128;173.213.108.113:3128;173.213.108.113:3128;198.100.159.69:8080;198.100.159.69:8080;198.100.159.69:8080;199.119.76.111:8080;199.119.76.111:8080;199.119.76.111:8080;61.145.121.124:88;61.145.121.124:88;61.145.121.124:88";
        //String noob ="46.4.56.205:3128";
        String noob = getContents(new File("proxiesandshit.txt")) + ';';
        String[] r = splitString(";", noob);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        int delim, numnum = 0, portProxy;
        String heh, proxy, workingProxies="";

        for (int dd = 0; dd < r.length; dd++) {
            heh = r[dd];
            delim = heh.indexOf(':');
            if((dd%20)!=0){System.out.println("Current working proxies...:"+workingProxies);};
            if (delim != -1) {
                if (HTTPS) {
                    System.out.print("SSL ");
                }
                URL url = new URL("http://www.saiga-jp.com/japanese_language.html");
                //URL url = new URL("https://sys.4chan.org:443/mlp/post");
                //CONTENT = "resto=7527369&com=huehue&mode=regist&pwd=MOOTISFUCK&recaptcha_challenge_field=&recaptcha_response_field";
                //CONTENT = "answer=6";
                String res, fileName = "Fuck", ss = "GET"+' '+ url.toString() + " HTTP/1.1\r\nConnection: close\r\nHost: " + url.getHost() + "\r\nHTTP_X_FORWARDED_FOR:1.1.1.1" ;
                if("".equals(CONTENT)){
                ss+="\r\nContent-Type:application/x-www-form-urlencoded\r\nContent-Length:"+ CONTENT.length() + "\r\n\r\n" + CONTENT + "\r\n\r\n";
                }else{ss+="\r\n\r\n";}
                System.out.print(heh + " > ");
                //String faggotJavaWhyYouSuckAtThisShitIFuckingHateYouFuckShitDamn ="\x13\x10";
                //JOptionPane.showMessageDialog(null, faggotJavaWhyYouSuckAtThisShitIFuckingHateYouFuckShitDamn.matches(heh), "InfoBox: " + "noob", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println((heh.codePointAt(0)));
                //System.out.println(ss);
                if (heh.length() > 0 && (heh.codePointAt(0)) == 13) {
                    JOptionPane.showMessageDialog(null, "It's over", "InfoBox: " + "noob", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //System.out.print(faggotJavaWhyYouSuckAtThisShitIFuckingHateYouFuckShitDamn.matches(heh));
                    proxy = heh.substring(0, delim);
                    portProxy = (int) getInteger(heh.substring(delim + 1));
                    res = CheckProxy(url, proxy, portProxy, ss, HTTPS);
                    if(res==null){System.out.println("resISnull---------------------------");continue;}
                                       
                    if (!"".equals(res)) {
                        if(res.indexOf('\n')!=-1){numnum = (int) getInteger(res.substring(res.indexOf(" "), res.indexOf('\n')));}else{System.out.println("res doesn't have new lines, look!:"+res);}
                        
                        System.out.println(numnum);
                        if (res.contains("id=\"errmsg\"")) {
                            System.out.println(getSubstringBetween(res, "<span id=\"errmsg\" style=\"color: red;\">", "<br>", false));
                            workingProxies+=r[dd]+";";
                        }else{
                        System.out.println(res);
                        }
                    } else {
                        numnum = 0;
                        file = false;
                    }
                    System.out.println("numnum >= 200:" + (numnum >= 200));

                    if (file) {
                        if (numnum >= 200) {
                            if (HTTPS) {
                                fileName += " SSL";
                            }
                            fileName += " " + url.getHost() + " " + proxy + " - " + Integer.toString(portProxy) + "v";
                            if (fileName != null) {
                                String filename = fileName + ".txt";
                                System.out.println("Does file \"" + filename + "\" exists?? :" + ((new File(filename)).isFile()));

                                for (int xxfile = 0; ((new File(filename)).isFile()); xxfile++) {
                                    filename = fileName + xxfile + ".txt";
                                    System.out.println("Does file " + filename + " exists?? :" + ((new File(filename)).isFile()));
                                }

                                if (!res.contains("The URL you requested has been blocked")) {
                                    System.out.println("Is the page empy as \"\"? :" + ("".equals(res.substring(res.indexOf("\n\n")))));
                                    if (!("".equals(res.substring(res.indexOf("\n\n"))))) {
                                        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
                                        if (true) {
                                            out.write(res);
                                        } else {
                                            out.write(res.substring(res.indexOf("\n\n")));
                                        }
                                        out.close();
                                    }
                                } else {
                                    System.out.println("Fuckers blocked the fucking page, shit fuck shit.");

                                }
                            }
                        }
                    }
                }
                System.out.println("---------------------------");
            }
        }



    }

    static public String getContents(File aFile) {
        //...checks on aFile are elided
        StringBuilder contents = new StringBuilder();

        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try {
                String line = null; //not declared within while loop
        /*
                 * readLine is a bit quirky :
                 * it returns the content of a line MINUS the newline.
                 * it returns null only for the END of the stream.
                 * it returns an empty String if two newlines appear in a row.
                 */
                while ((line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return contents.toString();
    }

    public static String getSubstringBetween(String haystack, String start, String end, Boolean Inclusive) {
        //char[] fag;
        if (haystack == null) {
            return null;
        }
        int a = haystack.indexOf(start);
        //for(int i=a;i<a+strtoFind.length;i++){
        if (0 == ~a) {
            return null;
        } else {
            // }      
            String heh = haystack.substring(a);
            a = heh.indexOf(end);
            if (0 == ~a) {
                return null;
            } else {
                heh = heh.substring(Inclusive ? 0 : start.length(), a);
                if (Inclusive) {
                    return heh + end;
                } else {
                    return heh;
                }
            }
        }
    }

    public static String[] splitString(String strDelimeter, String sourceString) {
        String[] n;
        n = new String[countSubstrings(strDelimeter, sourceString)];
        int d = -1;
        int k = 0;
        for (int z = 0; 0 != ~k; z++) {
            k = sourceString.indexOf(strDelimeter, d + 1);
            if (0 == ~k) {
                n[z] = sourceString.substring(d + 1);
                break;
            }
            n[z] = sourceString.substring(d + 1, k);
            d = sourceString.indexOf(strDelimeter, d + 1);

        }
        return n;
    }

    public static int countSubstrings(String needle, String haystack) {
        if (haystack == null || haystack.length() == 0) {
            return 0;
        }
        int count = 0;
        // start at the beginning of the string
        int nextIndex = 0;
        while (0 != ~nextIndex) {
            nextIndex++;
            count++;
            nextIndex = haystack.indexOf(needle, nextIndex);
        }
        return count;
    }

    public static long getInteger(String a) {
        int c = a.length();
        String d = "";
        for (int b = 0; b < c; b++) {
            if (Character.isDigit(a.charAt(b))) {
                d += a.charAt(b);
            }
        }
        if ("".equals(d)) {
            System.out.println("Couldn't get integer in:" + a);
        }
        return Long.parseLong(("".equals(d)) ? "0" : d);
    }
static hehue z;
    public static String CheckProxy(URL url, String proxy, int portProxy, String ss, Boolean HTTPS) throws MalformedURLException, IOException {
System.out.print("CheckProxy has started");

        //if(portProxy==80){System.out.println("port 80 ignore..");return false;}
        String res = "", lol = "";
        BufferedReader br = null;
        try {

            PrintWriter pw;
            if (HTTPS) {
                Socket tun = new Socket();
                tun.connect(new InetSocketAddress(InetAddress.getByName(proxy), portProxy), 3000);
                if((new http()).doTunnelHandshake(tun, url.getHost(), url.getPort())){
                    System.out.println("doTunnelHandshakeFinished");
                   

                SSLSocket s;
                s = (SSLSocket) (HttpsURLConnection.getDefaultSSLSocketFactory()).createSocket(tun, url.getHost(), url.getPort(), true);
                s.addHandshakeCompletedListener(
                        new HandshakeCompletedListener() {
                            public void handshakeCompleted(
                                    HandshakeCompletedEvent event) {
                                System.out.println("Handshake finished!");
                                System.out.println(
                                        "\t CipherSuite:" + event.getCipherSuite());
                                System.out.println(
                                        "\t SessionId " + event.getSession());
                                System.out.println(
                                        "\t PeerHost " + event.getSession().getPeerHost());
                            }
                        });
                s.startHandshake();
                System.out.println("Handshaking Complete");
                pw = new PrintWriter(s.getOutputStream());
                pw.print(ss);
                pw.flush();
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));}else{System.out.println("Too long");return null;};
            } else {
                Socket s;
                s = new Socket();
                System.out.println("Before connect");
                s.connect(new InetSocketAddress(InetAddress.getByName(proxy), portProxy), 3000);
                System.out.println("After connect");
                pw = new PrintWriter(s.getOutputStream());
                pw.print(ss);
                pw.flush();
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
            }
        } catch (IOException | InterruptedException asdxc) {
            System.out.println(asdxc.getMessage());
            asdxc.getMessage().contains("timed out");
            if (!asdxc.getMessage().contains("timed out") 
                    && 
                    !asdxc.getMessage().contains("refused")) {
                Logger.getLogger(http.class.getName()).log(Level.SEVERE, null, asdxc);
            }
        }
        
        if (br != null) {
            Object[] lel={false,res,lol,br};
            hehue z;
            z = new hehue(lel);
            Thread k=new Thread(z);
            System.out.println("Thread 2 has started");
            k.start();
            Boolean doesthisstillwork=true;
            int LoopCount=0;
            while(doesthisstillwork){
            doesthisstillwork=!((Boolean) z.STRL[0]);
                try {   
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(http1.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(LoopCount++>6000){
            k.stop();    
            System.err.println("bufferReader too loong");
            return null;
            }
            }
            
            res=(String) z.STRL[1];
            lol=(String) z.STRL[2];
            br=(BufferedReader) z.STRL[3];       
            
            br.close();
        }


        return res;

    }
        public final void run() {
    }
private static class hehue implements Runnable{

public Thread k;
Object[] STRL;
hehue(Object[] s) {
        STRL = s;
    }
    public final void run() {
        System.out.print("THREAD START");
        String res=(String) STRL[1],lol=(String) STRL[2];
            BufferedReader br=(BufferedReader) STRL[3];
        try {
            
                StringBuilder reply = new StringBuilder();
                while ((lol = br.readLine()) != null) {
                    System.out.print("Read lapse:");
                    
                    reply.append(lol).append('\n');
                }
                res=reply.toString();
                System.out.println("Read lapse end\nend");
            } catch (Exception EEEXCeption) {
                System.out.println(EEEXCeption.getMessage());
            }
        STRL[1]=res;
        STRL[2]=lol;
        STRL[3]=br;
        STRL[0]=true;
                   
        System.out.print("THREAD END");        
                
        
        
    }
}
}