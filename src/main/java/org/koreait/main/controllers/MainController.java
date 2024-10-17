package org.koreait.main.controllers;

import org.koreait.global.Controller;
import org.koreait.global.libs.Utils;
import org.koreait.main.templates.MainMenu;

/**
 * 콘솔 프로그램 메인 컨트롤러
 *
 */
public class MainController extends Controller {

    @Override
    public void view() {
        // 템플릿 출력
        Utils.loadTpl(MainMenu.class);
    }
}
