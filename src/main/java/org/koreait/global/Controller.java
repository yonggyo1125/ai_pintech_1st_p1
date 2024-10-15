package org.koreait.global;

public interface Controller {
    default void common() {} // 공통 출력 부분
    void view(); // 화면 구성
    void run(); // 컨트롤러 실행
}
