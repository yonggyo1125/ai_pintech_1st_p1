package org.koreait.product.controllers;

import org.koreait.global.Controller;
import org.koreait.global.Router;
import org.koreait.global.exceptions.BadRequestException;
import org.koreait.global.libs.Utils;
import org.koreait.global.validators.RequiredValidator;
import org.koreait.global.validators.TypeValidator;
import org.koreait.product.entities.Product;
import org.koreait.product.templates.ProductForm;

import java.util.Scanner;

/**
 * 상품 등록/수정 컨트롤러
 *
 */
public class ProductController extends Controller implements RequiredValidator, TypeValidator {

    public ProductController() {
       setPromptProcess(() -> {
           Utils.drawLine('-', 30);

           Scanner sc = Router.sc;
           Product item = new Product();

           while(true) {
               System.out.print("상품명:");
               String input = sc.nextLine();

               check(input, new BadRequestException("상품명을 입력하세요.")); // 상품명 유효성 검사
               item.setName(input);


               System.out.print("판매가:");
               input = sc.nextLine();

               // 판매가 유효성 검사
               check(input, new BadRequestException("판매가를 입력하세요."));
               if (!isNumber(input)) {
                   throw new BadRequestException("숫자 형식만 입력하세요.");
               }

               item.setPrice(Integer.parseInt(input));

           }
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
