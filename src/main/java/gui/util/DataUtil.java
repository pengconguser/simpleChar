package gui.util;

public class DataUtil {
    public static boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
