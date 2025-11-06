package application.util;

import application.model.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {

    private static final String FILE_NAME = "members.txt";

    public static void saveMember(Member member) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            out.println(member.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
