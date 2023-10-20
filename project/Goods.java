package project;

import project.Goods_List.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Goods extends Menu implements data_interfce {
    String name;
    String price;
    String content;
    Object goods_list;
    int goods_size;

    Order order;


    public Goods(Integer num, Order order) {
        super(num);
        this.order = order;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void start() {

        switch (super.number) {
            case 1 -> {
                goods_list = new Burger_list();
            }
            case 2 -> {
                goods_list = new Side_list();
            }
            case 3 -> {
                goods_list = new Drink_list();
            }
            case 4 -> {
                goods_list = new Dessert_list();
            }

        }

        System.out.println("****BURGER_KING 상품메뉴판을 보시고 상품 선택해 주세요****\n\n");
        System.out.format("[%s Menu]\n", super.name.get(super.number - 1));

        //현재 Object goods_list;인 goods_list에 담긴 객체에 따라 밑에 조건문 실행
        int count = 1;
        //↓ 자바16부터 도입된 패턴 변수 (원래라면 강제 형변환 코드 따로 적어야하는데 이렇게 인스턴스 확인과 동시에  할 수있다)
        if (goods_list instanceof Burger_list burger_list) {

            this.goods_size = burger_list.burger.size();
            for (String i : burger_list.burger.keySet()) {
                System.out.println(count + "." + burger_list.burger.get(i)[0] + " | w " + burger_list.burger.get(i)[1] + " | " + burger_list.burger.get(i)[2]);
                count += 1;
            }

            System.out.println("---------------------------------------------------------------------------------");

            while (true) {
                String goods_select = scanner_method();
                System.out.println(burger_list.burger.get(goods_select)[0] + " | w " + burger_list.burger.get(goods_select)[1] + " | " + burger_list.burger.get(goods_select)[2]);
                System.out.println("위 메뉴의 단품,세트 어떤 옵션으로 추가하시겠습니까?");
                System.out.printf("1. 싱글(W %s)          2. 세트(W %s)\n", burger_list.burger.get(goods_select)[1], burger_list.burgerSet.get(goods_select)[1]);
                System.out.println("---------------------------------------------------------------------------------");
                String optionSelect= sc.nextLine();
                if(optionSelect.equals("1")){
                    System.out.println(burger_list.burger.get(goods_select)[0] + " | w " + burger_list.burger.get(goods_select)[1] + " | " + burger_list.burger.get(goods_select)[2]);
                }
                else{
                    System.out.println(burger_list.burgerSet.get(goods_select)[0] + " | w " + burger_list.burgerSet.get(goods_select)[1] + " | " + burger_list.burgerSet.get(goods_select)[2]);
                }

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2.취소");
                System.out.println("---------------------------------------------------------------------------------");
                String check = sc.nextLine();

                if (check.equals("1")) {
                    if(optionSelect.equals("1")){
                    this.name = burger_list.burger.get(goods_select)[0];
                    this.price = burger_list.burger.get(goods_select)[1];
                    this.content = burger_list.burger.get(goods_select)[2];
                    }else{
                        this.name = burger_list.burgerSet.get(goods_select)[0];
                        this.price = burger_list.burgerSet.get(goods_select)[1];
                        this.content = burger_list.burgerSet.get(goods_select)[2];
                    }
                    break;
                } else continue;
            }
        } else if (goods_list instanceof Side_list side_list) {

            this.goods_size = side_list.side.size();
            for (String i : side_list.side.keySet()) {
                System.out.println(count + "." + side_list.side.get(i)[0] + " | w " + side_list.side.get(i)[1] + " | " + side_list.side.get(i)[2]);
                count += 1;
            }
            System.out.println("---------------------------------------------------------------------------------");

            while (true) {
                String goods_select = scanner_method();
                System.out.println(side_list.side.get(goods_select)[0] + " | w " + side_list.side.get(goods_select)[1] + " | " + side_list.side.get(goods_select)[2]);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2.취소");
                String check = sc.nextLine();
                System.out.println("---------------------------------------------------------------------------------");
                if (check.equals("1")) {
                    this.name = side_list.side.get(goods_select)[0];
                    this.price = side_list.side.get(goods_select)[1];
                    this.content = side_list.side.get(goods_select)[2];
                    break;
                } else continue;
            }

        } else if (goods_list instanceof Drink_list drink_list) {

            this.goods_size = drink_list.drink.size();
            for (String i : drink_list.drink.keySet()) {
                System.out.println(count + "." + drink_list.drink.get(i)[0] + " | w " + drink_list.drink.get(i)[1] + " | " + drink_list.drink.get(i)[2]);
                count += 1;
            }
            System.out.println("---------------------------------------------------------------------------------");

            while (true) {
                String goods_select = scanner_method();
                System.out.println(drink_list.drink.get(goods_select)[0] + " | w " + drink_list.drink.get(goods_select)[1] + " | " + drink_list.drink.get(goods_select)[2]);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2.취소");
                String check = sc.nextLine();
                System.out.println("---------------------------------------------------------------------------------");
                if (check.equals("1")) {
                    this.name = drink_list.drink.get(goods_select)[0];
                    this.price = drink_list.drink.get(goods_select)[1];
                    this.content = drink_list.drink.get(goods_select)[2];
                    break;
                } else continue;
            }
        } else if (goods_list instanceof Dessert_list dessert_list) {

            this.goods_size = dessert_list.dessert.size();
            for (String i : dessert_list.dessert.keySet()) {
                System.out.println(count + "." + dessert_list.dessert.get(i)[0] + " | w " + dessert_list.dessert.get(i)[1] + " | " + dessert_list.dessert.get(i)[2]);
                count += 1;
            }
            System.out.println("---------------------------------------------------------------------------------");

            while (true) {
                String goods_select = scanner_method();
                System.out.println(dessert_list.dessert.get(goods_select)[0] + " | w " + dessert_list.dessert.get(goods_select)[1] + " | " + dessert_list.dessert.get(goods_select)[2]);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2.취소");
                String check = sc.nextLine();
                System.out.println("---------------------------------------------------------------------------------");
                if (check.equals("1")) {
                    this.name = dessert_list.dessert.get(goods_select)[0];
                    this.price = dessert_list.dessert.get(goods_select)[1];
                    this.content = dessert_list.dessert.get(goods_select)[2];
                    break;
                } else continue;
            }
        }

        order.basket(this.name, this.price, this.content);
//        order.printBasket();


    }

    private String scanner_method() {
        String result = "";
        boolean check2 = false;

        while (!check2) {
            try {
//                System.out.println("선택하실 메뉴 숫자를 눌러주세요");
                String select_num = sc.nextLine();

                if (Pattern.matches("^[1-" + String.valueOf(goods_size) + "]$", select_num)) {
//                    System.out.println(select_num + "숫자 선택완");
                    result = select_num;
                    check2 = true;
                } else {
                    throw new InputException(goods_size);
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }


}
