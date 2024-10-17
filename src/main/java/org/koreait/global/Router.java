package org.koreait.global;

import org.koreait.global.libs.Utils;
import org.koreait.main.controllers.MainController;

import java.util.Scanner;

public class Router {
    public static final Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    /**
     * 컨트롤러 라우터 실행
     *
     */
    public void execute() {
        while(true) {
            Utils.loadController(MainController.class);
        }
    }
}
