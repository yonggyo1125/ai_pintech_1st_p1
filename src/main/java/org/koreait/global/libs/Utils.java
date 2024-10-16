package org.koreait.global.libs;

public class Utils {
    /**
     * 구분선 그리기
     *
     * @param ch : 출력할 문자
     * @param length : 출력할 갯수
     */
    public static void drawLine(char ch, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void drawLine(char ch) {
        drawLine(ch, 10);
    }


}
