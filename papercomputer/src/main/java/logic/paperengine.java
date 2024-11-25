package logic;

public class paperengine {

  public static void executePaperCompCode(){
    for (int i = 0; i < memory.command.size(); i++) {
        String[] s = memory.command.get(i).split(" ");
        switch (s[0]) {
            case "inc":
                
                break;
            case "dec":
            case "isz":
            case "jmp": 
                try {
                    i = Integer.parseInt(s[1]);
                } catch(Exception ex){}
            default:
                break;
        }
    }
  }
}
