package org.koreait.global.libs;

import org.koreait.global.BeanContainer;
import org.koreait.global.Controller;

import java.lang.reflect.Method;

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

    /**
     * 템플릿 출력
     *
     * Class 클래스는 클래스의 구성 요소의 정보도 조회하나 
     *  reflection 기능, 즉 동적 객체 생성, 동적 메서드 호출, 또는 동적으로 멤버 변수의 값 접근 및 변경 가능합니다.
     *  reflection 기능은 불특정 클래스로 부터 객체를 생성하거나 메서드를 호출할때 즉, 범용적인 접근을 할때 주로 사용할 수 있습니다.
     *
     * @param clazz
     * @param <T>
     */
    public static <T> void loadTpl(Class<T> clazz) {
        try {
            // 동적 객체 생성
            Object obj = BeanContainer.getBean(clazz);
            Method method = clazz.getDeclaredMethod("print");
            method.invoke(obj);

        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    /**
     * 컨트롤러 실행
     *
     * 메뉴 컨트롤러는 여러개로 정의될 수 있으므로 Controller라는 클래스 공통 자료형을 통해 하나로 묶어 줄수 있음(다형성 활용)
     *
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T loadController(Class<T> clazz) {

        /**
         * 컨트롤러는 공통적으로 run 이라는 메서드가 정의되어 있고 run은 일련의 실행 절차가 정의되어 있다.
         */
        try {
            Object obj = BeanContainer.getBean(clazz);

            // Controller인 경우만 처리
            if (obj instanceof Controller) {
                Method method = clazz.getSuperclass().getDeclaredMethod("run");
                method.invoke(obj);
                return (T) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
