package org.koreait.product.controllers;

import org.koreait.global.Controller;
import org.koreait.global.Router;
import org.koreait.global.libs.Utils;
import org.koreait.product.templates.ProductForm;

import java.util.Scanner;

/**
 * 상품 등록/수정 컨트롤러
 *
 */
public class ProductController extends Controller {

    public ProductController() {
       setPromptProcess(() -> {
           Scanner sc = Router.sc;
           System.out.print("상품명:");


       });
    }

    @Override
    protected String getPromptText() {
        return "등록할 상품 정보를 입력하세요(메인 메뉴: M, 종료: Q).";
    }

    @Override
    public void view()  {
        Utils.loadTpl(ProductForm.class);
    }
}
