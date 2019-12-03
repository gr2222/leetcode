package com.gr.stac;

public class StacConuter {
    public static void main(String[] args) {
        Stac sumStac = new Stac(20);
        Stac chaStac = new Stac(19);

        String expression = " 4*5-8+60+8/2";

        String s = remPar(sumStac, chaStac, expression);
        int jisuan = jisuan(sumStac, chaStac, s);
        System.out.println(jisuan);
    }

    public static String remPar(Stac sumStac, Stac chaStac, String expression) {
        if (expression.indexOf('(')==-1){
            return expression;
        }
        int i = expression.indexOf("(");
        int n = expression.indexOf(")");
        //将括号里面的运算优先提取出来 substring  比如：(255+45)-(2*70) substring=255+45
        String substring = expression.substring(i + 1, n);
        //计算括号里面的 jisuan = 300
        int jisuan = jisuan(sumStac, chaStac, substring);
        String substring1 = expression.substring(0, i);
        String substring2 = expression.substring(n + 1);
        //将剩下的和jisuan 拼在一起 300-(2*70)
        String str = substring1+String.valueOf(jisuan)+substring2;
        //判断还有没有括号，有括号则递归调用。没有就返回
        if (str.indexOf('(')==-1){
            return str;
        }else {
            return remPar(sumStac,chaStac,str) ;
        }
    }

    public static int jisuan(Stac sumStac, Stac chaStac, String expression) {
        int result = 0;
        String str = "";
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (ismark(chars[i])) {
                if (!chaStac.empty()) {
                    if (getLevel(chars[i]) <= getLevel(chaStac.japop())) {
                        int num1 = sumStac.pop();
                        int num2 = sumStac.pop();
                        int ch = chaStac.pop();
                        int ref = cout(num1, num2, ch);
                        sumStac.push(ref);
                        chaStac.push(chars[i]);
                    } else {
                        chaStac.push(chars[i]);
                    }
                } else {
                    chaStac.push(chars[i]);
                }
            } else {
                str += chars[i];
                if (i == chars.length - 1) {
                    sumStac.push(Integer.parseInt(str));
                } else {
                    if (ismark(chars[i + 1])) {
                        int strnum = Integer.parseInt(str);
                        sumStac.push(strnum);
                        str = "";
                    }
                }
            }
        }
        while (true) {
            if (chaStac.empty()) {
                result = sumStac.pop();
                break;
            }
            int num1 = sumStac.pop();
            int num2 = sumStac.pop();
            int ch = chaStac.pop();
            int cout = cout(num1, num2, ch);
            sumStac.push(cout);
        }
        return result;
    }

    /*
     *  42	*
     *  43	+
     *	45	-
     *	47	/
     */

    public static int cout(int num1, int num2, int ch) {
        int ref;
        switch (ch) {
            case '+':
                ref = num1 + num2;
                break;
            case '-':
                ref = num2 - num1;
                break;
            case '*':
                ref = num1 * num2;
                break;
            case '/':
                ref = num2 / num1;
                break;
            default:
                ref = 0;
        }
        return ref;
    }

    public static int getLevel(int ch) {
        int level;
        switch (ch) {
            case '+':
                level = 1;
                break;
            case '-':
                level = 1;
                break;
            case '*':
                level = 2;
                break;
            case '/':
                level = 2;
                break;
            default:
                level = 0;
        }
        return level;
    }

    public static boolean ismark(int ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}

