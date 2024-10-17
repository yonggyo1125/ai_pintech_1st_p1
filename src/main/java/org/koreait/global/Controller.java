package org.koreait.global;

import org.koreait.global.libs.Utils;

import java.util.function.Consumer;

/**
 * Controller 클래스
 *      모든 메뉴는 Controller 클래스를 상속 받아 정의 합니다.
 *      Controller 클래스는 사용자의 요청(예 - 메뉴 선택, 값 입력 등)이 유입되고
 *      이를 처리할 수 있는 서비스 객체와 화면 출력을 서로 연결해 주는 역할을 하게 됩니다.
 *      컨트롤러에서는 고정된 실행 절차가 정의되어 있고 이에 따라 실행 됩니다.
 *      이는 템플릿 메서드 패턴이 적용된 사례
 *      run() 메서드에는 실행 절차가 정의 되어 있습니다.
 *          실행 순서
 *          1) common() : 화면 상단 공통 출력 부분
 *          2) view() : 각 컨트롤러마다 다르게 출력될 부분 정의 - 상속 받은 클래스가 정의
 *          3) prompt() : 사용자의 입력을 받는 부분, 기본 화면은 메뉴 선택이지만 각 컨트롤러에서 새롭게 정의하면 해당 메뉴에 맞는 입력으로 새롭게 정의 가능
 */
public abstract class Controller {

    // 사용자 입력 텍스트
    private String input;

    private Consumer<String> inputProcess;

    // 공통 출력 부분
    public void common() {
        Utils.drawLine('-', 30);
        System.out.printf("상품 관리 프로그램 v1.0.0\n");
        Utils.drawLine('-', 30);
    }

    public abstract void view(); // 화면 구성

    /**
     * 사용자 입력 문구
     *  - 화면에 따라서 입력 문구가 다른 경우 하기 메서드를 재정의 한다.
     *  - 그렇지 않다면 기본 문구 - 메뉴를 선택하세요(종료:Q): 출력 된다.
     * @return
     */
    protected String getPromptText() {
        return "메뉴를 선택하세요(종료:Q):";
    }

    /**
     * 사용자 입력 조회
     * 재정의된 컨트롤러에서는 하기 메서드를 통해 조회 하며 그 값을 가지고 처리합니다.
     *
     * @return
     */
    protected String getInput() {
        return input;
    }

    /**
     * 사용자 입력 기록
     *
     * @param input
     */
    protected void setInput(String input) {
        this.input = input;
    }

    /**
     * 사용자 입력 처리
     *
     * @param inputProcess
     */
    protected void setInputProcess(Consumer<String> inputProcess) {
        this.inputProcess = inputProcess;
    }

    /**
     * 사용자 입력 데이터 처리
     * - 컨트롤러마다 처리는 다르므로 컨트롤러 마다 정의
     *
     */
    protected void process() {
        if (inputProcess != null) {
            inputProcess.accept(getInput());
        }
    }

    /**
     * 사용자 입력 공통
     *
     */
    public void prompt() {
        Utils.drawLine('-', 30);
        System.out.print(getPromptText());

        String input = Router.sc.nextLine();

        setInput(input); // 입력 기록
        process(); // 입력 처리

        if (input.toUpperCase().equals("Q")) {
            System.out.println("종료합니다.");
            System.exit(0);
        }
    }

    public final void run() {
        common();
        view();
        prompt();
    }

}
