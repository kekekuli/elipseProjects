import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.PrintWriter;
import java.net.*;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		String host = "localhost";int port = 8888;
		Socket socket = new Socket(host, port);
		System.out.println("client say connection success too");
		String line; String input;
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String readline = sin.readLine();
		os.println(readline);
		os.flush();
		for(int j=0;j<=5;j++){ 
			System.out.println("第" + j + "次");
			String isread = is.readLine();
			System.out.println(isread);
			if (isread.equals("accpet")) {
				System.out.println("请输入1或2");
				String comand = sin.readLine();
				os.println(comand);
				os.flush();
			}
			else if (isread.equals("finish")) {
				os.println("byebye");
				os.flush();
			}
			else {
				break;
			}
		}
		os.close();
		is.close();
		socket.close();
	}
}
