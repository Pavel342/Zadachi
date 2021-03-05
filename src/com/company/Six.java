package com.company;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.util.regex.*;

public class Six {
    public static void main(String[] args){
        System.out.println("\t\t\tПервое задание");
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(3));
        System.out.println("\t\t\tВторое задание");
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button"));
        System.out.println(translateWord(""));
        System.out.println(translateSentence());
        System.out.println("\t\t\tТретье задание");
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor("rgb(255,256,255)"));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.println("\t\t\tЧетвертое задание");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[] {"b"}));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[] {"b"}));
        System.out.println(stripUrlParams("https://edabit.com", new String[] {"b"}));
        System.out.println("\t\t\tПятое задание");
        System.out.println(Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println(Arrays.toString(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")));
        System.out.println(Arrays.toString(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println(Arrays.toString(getHashTags("Visualizing Science")));
        System.out.println("\t\t\tШестое задание");
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));
        System.out.println("\t\t\tСедьмое задание");
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(longestNonrepeatingSubstring("aaaaaa"));
        System.out.println(longestNonrepeatingSubstring("abcde"));
        System.out.println(longestNonrepeatingSubstring("abcda"));
        System.out.println("\t\t\tВосьмое задание");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));
        System.out.println("\t\t\tДевятое задание");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));
        System.out.println("\t\t\tДесятое задание");
        System.out.println(palindromedescendant("11211230"));
        System.out.println(palindromedescendant("13001120"));
        System.out.println(palindromedescendant("23336014"));
        System.out.println(palindromedescendant("11"));
    }
    static int bell(int n) {
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            sum += Stirling(n,i);
        }
        return sum;
    }

    static int Stirling (int n, int k){
        if (n==k) return 1;
        else
        if (k==0) return 0;
        else
            return Stirling(n-1,k-1) + k * Stirling(n-1,k);

    }
    static String translateWord(String st){
        char[] str=st.toCharArray();
        String otv="";
        if(st.equals(""))return "";
        String uu="eyuioaEUOAI";
        if(uu.contains(String.valueOf(str[0]))) otv+=st + "yay";
        else for(int i=0;i<str.length-1;i++)
            if(uu.contains(String.valueOf(str[i+1]))){ otv+=st.substring(i+1) + st.substring(0,i+1) + "ay";break;}
        str=otv.toCharArray();
        for(int i=0;i<str.length;i++) if(str[i]==',' || str[i]=='.'){
            char a=str[i];
            if (str.length - (i + 1) >= 0) System.arraycopy(str, i + 1, str, i + 1 - 1, str.length - (i + 1));
            str[str.length-1]=a;
            otv=new String(str);
        }
        return otv;
    }
    static String translateSentence(){
        String[] wow= "I like to eat honey waffles.".split(" ");
        StringBuilder otvet= new StringBuilder();
        for(int i = wow.length - 1; i >= 0; i--)
            otvet.append(translateWord(wow[i])).append(" ");
        return otvet.toString();
    }
    static boolean validColor (String s){
        s = s.replaceAll(" ", "").trim();

        if(s.contains("rgba")) {
            s = s.substring(5);
            s = s.substring(0,s.length()-1);
            String[] strs = s.split(",");
            if(strs.length != 4) return false;

            for(int i = 0; i < strs.length-1; i++) {
                if(strs[i].length() > 0) {
                    int val;
                    try {
                        val = Integer.parseInt(strs[i]);
                        if(val < 0 || val > 255) return false;
                    } catch(Exception e) {
                        return false;
                    }
                }else {
                    return false;
                }
            }
            if(strs[3].length() > 0) {
                float val;
                try {
                    val = Float.parseFloat(strs[3]);
                    if(val < 0 || val > 1) return false;
                } catch(Exception e) {
                    return false;
                }
            }else {
                return false;
            }

        }else if(s.contains("rgb")) {
            s = s.substring(4);
            s = s.substring(0,s.length()-1);
            String[] strs = s.split(",");
            if(strs.length != 3) return false;
            for(int i = 0; i < strs.length-1; i++) {
                if(strs[i].length() > 0) {
                    int val;
                    try {
                        val = Integer.parseInt(strs[i]);
                        if(val < 0 || val > 255) return false;
                    } catch(Exception e) {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    static String stripUrlParams(String s, String[] p) {
        StringBuilder res;
        Map<String,String> params = new HashMap<>();

        if(!s.contains("?")) return "";

        String str = s.substring(s.indexOf("?")+1);
        String[] vars = str.split("&");
        for(String v : vars) {
            String[] t = v.split("=");
            params.put(t[0], t[1]);
        }
        res = new StringBuilder(s.substring(0, s.indexOf("?") + 1));

        //ôîðìèðóåì ÷åëîâå÷åñêèé keySet äëÿ ñëîâàðÿ
        String[] keySet = new String[params.keySet().toArray().length];
        for(int j = 0; j < keySet.length; j++) keySet[j] = (String)params.keySet().toArray()[j];
        Arrays.sort(keySet);

        for (String value : keySet) {
            if (in(p, value)) continue;
            res.append(value).append("=").append(params.get(value)).append("&");
        }

        return res.toString().endsWith("&") ? res.substring(0,res.length()-1): res.toString();
    }
    static boolean in(int[] a, int n) {
        for (int j : a) {
            if (j == n) return true;
        }
        return false;
    }
    static boolean in(String[] a, String n) {
        for (String s : a) {
            if (s.equals(n)) return true;
        }
        return false;
    }
    static String[] getHashTags(String str) {
        String[] strs = str.split(" ");
        Arrays.sort(strs, (a, b)->Integer.compare(b.length(), a.length()));
        int l = Math.min(strs.length, 3);
        String[] res = new String[l];
        for(int i = 0; i < l; i++) {
            if(strs[i].endsWith(","))
                res[i] = "#"+strs[i].toLowerCase().substring(0, strs[i].length()-1).trim();
            else
                res[i] = "#"+strs[i].toLowerCase().trim();
        }
        return res;
    }
    static int ulam(int n) {
        int[] nums = new int[n];
        if(n<2)return n;
        nums[0] = 1;
        nums[1] = 2;
        int complete = 2;
        while(complete<n) {
            Map<Integer,Integer> sums = new HashMap<>();
            for(int i = 0; i < complete-1; i++) {
                for(int j = i+1; j < complete; j++) {
                    if(i==j)continue;
                    int sum = nums[i] + nums[j];
                    try {
                        sums.put(sum, sums.get(sum)+1);
                    } catch (Exception e){
                        sums.put(sum, 1);
                    }

                }
            }
            int[] keySet = new int[sums.keySet().toArray().length];
            for(int j = 0; j < keySet.length; j++) keySet[j] = (int)sums.keySet().toArray()[j];
            Arrays.sort(keySet);

            for (int j : keySet) {
                if (sums.get(j) == 1 && !in(nums, j)) {
                    nums[complete] = j;
                    break;
                }
            }

            complete++;
        }

        Arrays.sort(nums);
        return nums[n-1];
    }
    static String longestNonrepeatingSubstring(String s) {
        char[] chrs = s.toCharArray();
        String res = "";
        String temp = "";
        for(int i = 0; i < chrs.length; i++) {
            if(temp.indexOf(chrs[i]) == -1) {
                temp += chrs[i];
            }else {
                if(temp.length() > res.length()) {
                    res = temp;
                    temp = "";
                }
            }
        }
        if(temp.length() > res.length()) {
            res = temp;
            temp = "";
        }
        return res;
    }
    static String convertToRoman(int n) {
        String res = "";
        String[] chrs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        if(n < 0 || n > 3999) return "out of range";
        int i = 0;
        while(n>0 && i < chrs.length) {
            if(values[i] <= n) {
                res+=chrs[i];
                n-= values[i];
            } else {
                i++;
            }
        }
        return res;
    }
    static boolean formula(String s) {
        String[] parts = s.split("=");
        int res = 0;
        try {
            res = calculate(parts[0]);
        }catch(Exception e){
            return false;
        }
        for(int i = 1; i < parts.length; i++) {
            try {
                if(calculate(parts[i]) != res) return false;
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    static int calculate(String s) throws Exception{
        s = s.replaceAll(" ", "");

        boolean flag = true;
        while(flag) {
            flag = false;
            int i = 0;

            if(s.indexOf("/")!=-1 || s.indexOf("+")!=-1 || s.indexOf("-")!=-1 || s.indexOf("*")!=-1) {
                flag = true;
                char c = ' ';
                if(s.indexOf("/") != -1) {i = s.indexOf("/"); c = '/';}
                else if(s.indexOf("*") != -1) {i = s.indexOf("*"); c = '*';}
                else if(s.indexOf("+") != -1) {i = s.indexOf("+"); c = '+';}
                else if(s.indexOf("-") != -1) {i = s.indexOf("-"); c = '-';}
                int a = i-1;
                int b = i+1;
                String an = "";
                String bn = "";
                while(a>=0 && Character.isDigit(s.charAt(a))){
                    an+=s.charAt(a);
                    a--;

                }
                an =  new StringBuilder(an).reverse().toString();
                while(b<s.length() && Character.isDigit(s.charAt(b))) {
                    bn += s.charAt(b);
                    b++;
                }

                int value = 0;
                switch(c) {
                    case '+':
                        value = Integer.parseInt(an) + Integer.parseInt(bn);
                        break;
                    case '-':
                        value = Integer.parseInt(an) - Integer.parseInt(bn);
                        break;
                    case '*':
                        value = Integer.parseInt(an) * Integer.parseInt(bn);
                        break;
                    case '/':
                        value = Integer.parseInt(an) / Integer.parseInt(bn);
                        break;
                }
                s = s.replace(an+c+bn, String.valueOf(value));
            }

        }
        return Integer.parseInt(s);
    }
    static boolean palindromedescendant(String s) {
        while(s.length() >= 2){
            if(isPalindrome(s)) return true;
            else s = createChildPalindrome(s);
        }
        return false;
    }
    static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i<j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    static String createChildPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i+=2) {
            res += String.valueOf(Integer.parseInt(String.valueOf(s.charAt(i))) + Integer.parseInt(String.valueOf(s.charAt(i+1))));
        }
        return res;
    }
}
