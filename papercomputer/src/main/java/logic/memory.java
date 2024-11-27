package logic;

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

    public static String getStartRegisterString(){
        String output = "";
        int i = 0;
        for (Integer value : startRegister) {
            output += Integer.toString(i) + ": " + value + "\n";
            i++;
        }
        if(i < 9){
            while (i != 9) {
                output += "\n";
                i++;
            }
        }
        return output;
    }

    public static  void setRegister(String input){

    }
}
