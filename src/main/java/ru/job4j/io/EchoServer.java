package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
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
                        }
                        System.out.println(str);
                    }
                    assert rsl != null;
                    String rslX = rsl.substring(rsl.lastIndexOf("=") + 1,
                            rsl.lastIndexOf(" "));
                    if (rslX.equalsIgnoreCase("exit")) {
                        out.write("HTTP/1.1 200 ServerClose\r\n\r\n".getBytes());
                        server.close();
                        break;
                    } else {
                        if (rslX.equalsIgnoreCase("hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend.".getBytes());
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(rslX.getBytes());
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
