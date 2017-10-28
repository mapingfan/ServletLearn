package TestHTTP;

import java.io.*;
import java.net.Socket;

public class TestHTTP {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        /**
         * 下面的代码模拟浏览器发送请求；
         */
        printWriter.println("GET /TestTomcat/index.jsp HTTP/1.1");
        printWriter.println("HOST: localhost");
        printWriter.println("Content-Type: text/html");
        printWriter.println();
        printWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}
