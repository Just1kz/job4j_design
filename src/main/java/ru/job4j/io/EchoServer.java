package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String rsl = null;
                    int count = 1;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (count == 1) {
                            rsl = str;
                            count++;
                            System.out.println(str);
                        } else {
                            System.out.println(str);
                        }
                    }
                    assert rsl != null;
                    if (rsl.contains("Bye")) {
                        out.write("HTTP/1.1 200 BAD\r\n\\".getBytes());
                        server.close();
                        break;
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
