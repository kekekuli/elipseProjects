import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.PrintWriter;
import java.net.*;


public class server {
	public static void main(String[] args) throws UnknownHostException, IOException{
		int port = 8888;
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		System.out.println("server say connection success");
		String input;
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		if (os == null) {
			System.out.println("tmd");
		}
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		for(int j=0;j<=5;j++){ 
			input=is.readLine();
			System.out.println(input);
			if (input.equals("jcy")) {
				System.out.println("身份验证通过");
				os.println("accpet");
				os.flush();
			}
			else if (input.equals("1")) {
				System.out.println("文件传输完成");
				os.println("finish");
				os.flush();
			}
			else if (input.equals("2")) {
				System.out.println("数据库传输完成");
				os.println("finish");
				os.flush();
			}
			else {
				System.out.println("我要关闭了");
				os.println("refuse");
				break;
			}
		}
		os.close();
		is.close();
		socket.close();
		System.out.println("server finish");
	}
}
