import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] arg) throws Exception {
        ServerSocket s = new ServerSocket(8189);     //启动服务：监听端口80
        while (true) {
            Socket incoming = s.accept();                //来一请求
            new Thread( ()-> {                            //新启一个线程响应请求
                try {
                    incoming.getOutputStream().write(  ("HTTP/1.1 200 OK\r\n" +
                        "Content-Type:text/html\r\n\r\n" +
                        "<center>Hello World!\r\n").getBytes());
                    incoming.close();
                }catch (Exception e){
            }}).start();
        }
    }
}