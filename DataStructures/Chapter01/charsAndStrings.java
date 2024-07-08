//package DataStructures.Chapter01;

public class charsAndStrings {
    public static void main(String[] args) {
        char ch1 = 'Z';
        char ch2 = '\'';

        char[] chars = {'h','e','l','l','o'};

        String str2 = "hello";
        String str3 = new String(chars);

        String str4 = Character.toString(ch2);

        System.out.println("ch1:"+ch1);
        System.out.println("ch2:"+ch2);
        System.out.println("chars: "+ chars); //this will be weird
        System.out.println("str2:"+str2);
        System.out.println("str3:"+str3);
        System.out.println("str4:"+str4);

        // you can add 2 strings using +
        String first = "John";
        String last = "Smith";
        String full = first + " " + last;

        // Declare strings continuosly 
        String str5 = "John", str6 = "Sally";
        String str7 = "*?)", str8 = "+.@";
        //escape characters 
        String str9 = "\n", str10 = "\t";
        System.out.println("str1: "+str5+" str2: "+str6);
        System.out.println("str3: "+str7+" str4: "+str8);
    }
}
