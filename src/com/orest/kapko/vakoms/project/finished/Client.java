package com.orest.kapko.vakoms.project.finished;

import com.google.gson.Gson;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.net.*;
import java.util.List;

import static sun.plugin2.util.PojoUtil.toJson;

public class Client {

    protected static final String HOST = "127.0.0.1";
    protected static final int PORT = 55555;
    public static Socket sock;
    private static PrintWriter request;

    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });

        try {
            sock = new Socket(HOST, PORT);
            System.out.println("Connected to " + HOST + " on port " + PORT);
            Scanner response = new Scanner(sock.getInputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String txt = "";
//----------------------------------------------------------------------------------------------------------------------
//          Adding new user

//            User firstUser = new User("VanBoganovich", "ivach@gmail.com");
//            List<User> listOfUsers = new ArrayList<>();
//            listOfUsers.add(firstUser);
//            Gson gson = new Gson();
//            String jsonUsers = gson.toJson(listOfUsers);
//            if (!jsonUsers.isEmpty()) {
//                request.println(jsonUsers);
//                request.flush();
//            }
//----------------------------------------------------------------------------------------------------------------------
//          Delete user
//            while (!txt.toUpperCase().equals("EXIT")) {
//                System.out.print("prompt:");
//                txt = in.readLine();
//                request.println(txt);
//                request.flush();
//                System.out.println(response.next());
//            }
//            request.close();
//            response.close();
//            in.close();
//            sock.close();
//            System.out.println("Connection closed!!!");

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

        public static void doAdd(String name, String email) throws IOException {

        User firstUser = new User(name, email);
        List<User> usersData = new ArrayList<>();
        usersData.add(firstUser);
        Gson gson = new Gson();
        String json = gson.toJson(usersData);
//        System.out.println(json.toString());
        Socket s = new Socket(HOST, PORT);
//        request = new PrintWriter(sock.getOutputStream());
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8);
                out.write(json.toString());


//        if (!json.isEmpty()) {
//            request.println(json);
//            request.flush();
//        }
    }
}