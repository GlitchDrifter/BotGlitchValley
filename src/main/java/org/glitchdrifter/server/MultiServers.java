package org.glitchdrifter.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServers {

  public static void main(String[] args) {
    try (ServerSocket s = new ServerSocket(SimpleServer.PORT)) {
      System.out.println("Server running & waiting for client connections.");
      while (true) {
        Socket socket = s.accept();
        System.out.println("Connection: " + socket);

        Runnable r = new SimpleServer(socket);
        Thread task = new Thread(r);
        task.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
