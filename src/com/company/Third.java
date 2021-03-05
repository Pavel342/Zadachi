package com.company;

public class Third {
    public static void main(String[] args) {
        System.out.println("\t\tПервое задание");
        System.out.println(solutions(1,0,-1));
        System.out.println(solutions(2,0,0));
        System.out.println(solutions(1,2,2));
        System.out.println("\t\tВторое задание");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println("\t\tТретье задание");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));
        System.out.println("\t\tЧетвертое задание");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
        System.out.println("\t\tПятое задание");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));
        System.out.println("\t\tШестое задание");
        System.out.println(same(new int[]{1, 3, 4, 4, 4},new int[] {2, 5, 7}));
        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println(same(new int[]{2}, new int[]{3, 3, 3, 3, 3}));
        System.out.println("\t\tСедьмое задание");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
        System.out.println("\t\tВосьмое задание");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
        System.out.println("\t\tДевятое задание");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
        System.out.println("\t\tДесятое задание");
        System.out.println(rightTriangle(3,4,5));
        System.out.println(rightTriangle(145,105,100));
        System.out.println(rightTriangle(70, 130, 110));
    }
    static int solutions(int a,int b, int c){
        int ot=b*b-4*a*c;
        if(ot>0) return 2;
        if(ot==0) return 1;
        else return 0;
    }
    static int findZip(String str){
        int w;
        if (!str.contains("zip"))return -1;
        w=str.indexOf("zip")+3;
        str=str.substring(str.indexOf("zip")+3);
        if (str.contains("zip")) return str.indexOf("zip")+w;
        return -1;
    }
    static boolean checkPerfect(int a){
        int w=0;
        for(int i=1;i<=a/2;i++)
            if(a%i==0)w+=i;
            return w==a;
    }
    static String flipEndChars(String str){
        if (str.length()<2) return "Несовместимо";
        if(str.charAt(0)==str.charAt(str.length()-1)) return "Два- это пара";
        char[] e = str.toCharArray();
        char o=e[0];
        e[0]=e[e.length-1];
        e[e.length-1]=o;
        return new String(e);
    }
    static boolean isValidHexCode(String a){
        if (a.charAt(0)!='#') return false;
        if (a.length()!=7) return false;
        for(int i=1;i<a.length();i++)
            if((Character.isDigit(a.charAt(i))) || a.charAt(i)=='A' || a.charAt(i)=='B'
                    || a.charAt(i)=='C' || a.charAt(i)=='D' || a.charAt(i)=='E'
                    || a.charAt(i)=='F' || a.charAt(i)=='a' || a.charAt(i)=='b'
                || a.charAt(i)=='c' || a.charAt(i)=='d' || a.charAt(i)=='e'
                || a.charAt(i)=='f') continue;
            else return false;
        return true;
    }
    static boolean same(int[] a, int[] b){
        int kol1=1,kol2=1, oo, pr;
        for(int i=1;i<a.length;i++){
            oo=i-1;
            pr=0;
            while(oo>=0){
                if (a[i] == a[oo]) {
                    pr = 1;
                    break;
                }
                oo--;}
            if (pr!=1) kol1++;
        }
        for(int i=1;i<b.length;i++){
            oo=i-1;
            pr=0;
            while(oo>=0){
                if (b[i] == b[oo]) {
                    pr = 1;
                    break;
                }
                oo--;}
            if (pr!=1) kol2++;
        }
        return kol1==kol2;
    }
    static boolean isKaprekar(int y){
        int n=y*y;
        String str=Integer.toString(n);
        String l = str.substring(0, str.length()/2);
        String r = str.substring(str.length()/2);
        if (l.isEmpty()) l = "0";
        return y == (Integer.parseInt(l)+Integer.parseInt(r));
    }
    static String longestZero(String as){
        char[] rr=as.toCharArray();
        StringBuilder otv= new StringBuilder();
        int t=0, max=0,i=0;
        for(int j:rr) if(j=='0') t++;
        else {if(t>max) max=t; t=0; }
        while(i<max) { otv.append('0');i++;}
        return otv.toString();
    }
    static int nextPrime(int n){
        int f=0;
        for(;;n++) {
            for (int i = 2; i < n; i++)
                if (n % i == 0) {
                    f = 1;
                    break;
                }

            if (f == 0) break;
            else f = 0;
        }
        return n;
    }
    public static boolean rightTriangle(int a,int b, int c){
        if(a>b && a>c) return a*a==b*b+c*c;
        if(b>a && b>c) return b*b==a*a+c*c;
        if(c>b && c>a) return c*c==b*b+a*a;
        return false;
    }
}
