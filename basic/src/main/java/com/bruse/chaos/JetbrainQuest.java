package com.bruse.chaos;

/**
 * JetbrainQuest
 * @author bruse
 */
public class JetbrainQuest {

    public static void main(String[] args) {
        String str = "48 61 76 65 20 79 6f 75 20 73 65 65 6e 20 74 68 65 20 73 6f 75 72 63 65 20 63 6f 64 65 20 6f 66 20 74 68 65 20 4a 65 74 42 72 61 69 6e 73 20 77 65 62 73 69 74 65 3f";
        String[] arr = str.split(" ");
        for (String s : arr) {
            int i = Integer.parseInt(s, 16);
            System.out.print((char) i);
        }
        System.out.println();

        int count = 0;
        int sum = 0;
        for (int i = 500; i <= 5000; i++) {
            sum++;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    System.out.println(i + " " + j);
                    count++;
                    break;
                }
            }
        }
        System.out.println(sum - count);

        String quest = "Qlfh$#Li#|rx#duh#uhdglqj#wklv#|rx#pxvw#kdyh#zrunhg#rxw#krz#wr#ghfu|sw#lw1#Wklv#lv#rxu#lvvxh#wudfnhu#ghvljqhg#iru#djloh#whdpv1#Lw#lv#iuhh#iru#xs#wr#6#xvhuv#lq#Forxg#dqg#iru#43#xvhuv#lq#Vwdqgdorqh/#vr#li#|rx#zdqw#wr#jlyh#lw#d#jr#lq#|rxu#whdp#wkhq#zh#wrwdoo|#uhfrpphqg#lw1#|rx#kdyh#ilqlvkhg#wkh#iluvw#Txhvw/#qrz#lw“v#wlph#wr#uhghhp#|rxu#iluvw#sul}h1#Wkh#frgh#iru#wkh#iluvw#txhvw#lv#‟WkhGulyhWrGhyhors†1#Jr#wr#wkh#Txhvw#Sdjh#dqg#xvh#wkh#frgh#wr#fodlp#|rxu#sul}h1#kwwsv=22zzz1mhweudlqv1frp2surpr2txhvw2";
        String key = "Jrrg#oxfn$";

        for (int i = 0; i < quest.length(); i++) {
            int c = quest.charAt(i) - 3;
            System.out.print((char) c);
        }
        System.out.println();
    }
}
