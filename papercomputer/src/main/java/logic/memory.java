package logic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public final class memory {
    static ArrayList<String> command = new ArrayList<>();
    static ArrayList<Integer> startRegister = new ArrayList<>();
    static ArrayList<Integer> workRegister = new ArrayList<>();

    public static void setCommand(String input){
        //command = input.split(System.lineSeparator());
        String cmd[] = input.split("\\r?\\n");
        command.clear();
        for (String string : cmd) {
            command.add(string);
        }
    }
    public static String getCommandString(){
        String output = "";
        for (String value : command) {
            output += value + "\n";
        }
        return output;
    }
}
