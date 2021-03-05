package com.company;
import java.util.*;


public class Forth {
    public static void main(String[] args) {
    System.out.println("\t\tПервое задание");
    System.out.println(help());
        System.out.println("\t\tВторое задание");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
        System.out.println("\t\tТретье задание");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println("\t\tЧетвертое задание");
        System.out.println(overTime(9f, 17, 1.5));
        System.out.println(overTime(16f, 18, 1.8));
        System.out.println(overTime(13.25f, 15, 1.5));
        System.out.println("\t\tПятое задание");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println(BMI("78 kilos", "1.78 meters"));
        System.out.println("\t\tШестое задание");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println("\t\tСедьмое задание");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
        System.out.println("\t\tВосьмое задание");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println("\t\tДевятое задание");
        System.out.println(trouble(451999277, 411777299));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.println("\t\tДесятое задание");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }
    static String help(){
       String[] soch= "hello my name is Bessie and this is my essay".split(" ");
       StringBuilder o= new StringBuilder(" ");
       StringBuilder res= new StringBuilder("\n");
        for (String word : soch) {
            if (o.length() + word.length() < 7)
                o.append(word);
            else {
                res.append(o.toString()).append('\n');
                o = new StringBuilder(word);
            }
        }
        String word = soch[soch.length -1];
        if (o.length() + word.length()+1 < 7)
            o.append(" ").append(word);
        else {
            res.append(word);
        }
        return res.toString();
    }
    static String split(String a){
        char[] rr=a.toCharArray();
        int po=0,p=0;
        StringBuilder worlds= new StringBuilder();
        for (char c : rr) {
            if (c == '(') {
                po++;
                p++;
            } else if (po == 1) {
                worlds.append(a, 0, p + 1).append(",");
                a = a.substring(p + 1);
                po = 0;
                p = 0;
            } else {
                po--;
                p++;
            }
        }
        worlds = new StringBuilder(worlds.substring(0, worlds.length() - 1));
            return worlds.toString();
    }
    public static String toCamelCase(String as){
        char[] rr=as.toCharArray();
        StringBuilder gg= new StringBuilder();
        for(int i=0;i<rr.length;i++)
            if(rr[i]=='_') {rr[i+1]=Character.toUpperCase(rr[i+1]);for(int j=i+1;j< rr.length;j++)
                rr[i]=rr[j];}
        for (char c : rr) gg.append(c);
        return gg.toString();
    }
    public static String toSnakeCase(String as){
        StringBuilder res = new StringBuilder();
        char[] a = as.toCharArray();

        for(int i = 0; i < as.length(); i++) {
            if (Character.isUpperCase(a[i])) {
                res.append("_").append(Character.toLowerCase(a[i]));
            }else
                res.append(a[i]);
        }

        return res.toString();
    }
    static String overTime(float a, int b, double kof){
        String otv="$";
        double o;
        if(b<=17) o=(b-a)* 30;
        else o=(b-17)*kof* 30 +(17-a)* 30;
        return otv + o;
    }
    static String BMI(String a, String b){
        String[] twa=a.split(" ");
        String[] twb=b.split(" ");
        double oo= Double.parseDouble((twa[0]));
        float ob= Float.parseFloat(twb[0]);
        if(twa[1].contains("pounds")) oo*=0.453592;
        if(twb[1].contains("inches")) ob*=0.0254;
        oo/=ob*ob;
        oo=Math.round(oo * 10.0) / 10.0;
        if(oo<18.5) return "" + (oo + "\tUnderweight");
        else if (oo>=25) return "" + (oo + "\tOverweight");
        else return "" + (oo + "\tNormal weight");
    }
    static int bugger(int a){
        int y,oo=a, chet=0;
        while (oo>=10) {
            y = oo;
            oo=1;
           while (y>=1) {
                oo *= y % 10;
                y /= 10;
            }
            chet++;
        }
        return chet;
    }
    static String toStarShorthand(String a){
        char[] or=a.toCharArray();
        StringBuilder otv= new StringBuilder();
        if(a.equals(""))return "";
        int u=0;
        int j=0;
        for(;j< or.length-1;j++){
            if(or[j]==or[j+1]) u++;
            else if (u==0) otv.append(or[j]);
            else {
                otv.append(or[j]).append("*").append(u + 1);u=0;}
        }
        if(u>0) otv.append(or[j]).append("*").append(u + 1);
        else otv.append(or[j]);
        return otv.toString();
    }
    static boolean doesRhyme(String a, String b){
        String w1 = a.split(" ")[a.split(" ").length-1].toLowerCase();
        String w2 = b.split(" ")[b.split(" ").length-1].toLowerCase();
        char[] ch1=w1.toCharArray();
        char[] ch2=w2.toCharArray();
        StringBuilder y= new StringBuilder();
        StringBuilder y2= new StringBuilder();
        for (char c : ch1)
            if (c == 'e' || c == 'u' || c == 'o' || c == 'a' ||
                    c == 'y' || c == 'i') y.append(c);
        for (char c : ch2)
            if (c == 'e' || c == 'u' || c == 'o' || c == 'a' ||
                    c == 'y' || c == 'i') y2.append(c);
            return y.toString().equals(y2.toString());
    }
    static boolean trouble(int a, int b) {
        int i=0,p=a,f=b;
        while(p>=1) {
            i++;
            p /=10;
        }
        int[] a1=new int[i];
        i=0;
        while(f>=1) {
            i++;
            f /=10;
        }
        int[] a2=new int[i];
        i=0;
        int tt=0;
        while(a>=1) {
            a1[i]=a%10;
            i++;
            a /=10;
        }
        i=0;
        while(b>0) {
            a2[i]=b%10;
            b/=10;
            i++;
        }
        for( i =0; i < a1.length-1; i++) {
            if (a1[i] == a1[i + 1]){ tt++;
            if (tt == 2) {
                tt = a1[i];
                break;
            } }
            else tt = 0;
        } if(tt==0)return false;
        for( i =0; i < a2.length-1; i++)
            if (a2[i] == a2[i + 1] && a2[i]==tt)return true ;
            return false;
    }
    static int  countUniqueBooks(String str,char chr){
        int res = 0;
        ArrayList<Character> chrs = new ArrayList<Character>();
        char[] s = str.toCharArray();
        boolean opened = false;

        for(int i = 0; i < s.length; i++) {

            if(!opened && s[i] == chr) {
                opened = true;
                continue;
            }

            if(opened && s[i] != chr) {
                if(!chrs.contains(s[i])) {
                    chrs.add(s[i]);
                }
            }

            if(opened && s[i] == chr) {
                opened = false;
                res += chrs.size();
                chrs.clear();
            }
        }

        return res;
    }
}
