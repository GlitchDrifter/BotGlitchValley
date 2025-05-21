package org.glitchdrifter.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SimpleClient {

  public static void main(String[] args) {
    try (
        Socket socket = new Socket("localhost", 5000);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
      out.println("Hello glitchdrifter");
      out.flush();
      String messageFromServer = in.readLine();
      System.out.println("Response: " + messageFromServer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
