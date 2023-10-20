package project;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu implements data_interfce {

    private static final String Check_num = "^[1-8]$";

    List<String> name;
    List<String> content;

    Integer number;

    String previousOrder;

    BigDecimal accumulatedAmount = new BigDecimal("0");
    List<List<String>> accumulatedMenu = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    Order order = new Order();


    public Menu() {
        this.name = new ArrayList<>(Arrays.asList("Burgers", "Sides", "Drinks", "Desserts", "Order", "Cancel"));
        this.content = new ArrayList<>(Arrays.asList(
                "오리지널,프리미엄,주니어",
                "어니언링,너겟킹,코울슬로,소스등",
                "탄산음료,커피,에이드등",
                "아이스크림",
                "장바구니를 확인후 주문합니다.",
                "진행중인 주문을 취소합니다."));
    }

    public Menu(Integer a) {
        this();
        this.number = a;

    }

    // ↓메뉴판 출력문
    @Override
    public void start() {


        if (this.previousOrder != null) System.out.println("*******"+this.previousOrder + " 가 장바구니에 추가되었습니다.*******\n");


        System.out.println("BURGER_KING 메뉴판을 보시고 메뉴를 선택해 주세요\n" +
                "[BURGER_KING MENU]");

        for (int i = 1; i <= this.name.size(); i++) {
            if (i != 5) {
                System.out.println(i + "." + this.name.get(i - 1) + " | " + this.content.get(i - 1));
            } else {
                System.out.println("\n[ORDER MENU]");
                System.out.println(i + "." + this.name.get(i - 1) + " | " + this.content.get(i - 1));
            }
        }
        System.out.println("---------------------------------------------------------------------------------");
        //↓메뉴판 숫자 입력받게 하기
        boolean check = false;
        int num = 0;

        while (!check) {
            try {
//                System.out.println("선택하실 메뉴 숫자를 눌러주세요");
                String num_select = sc.nextLine();

                if (Pattern.matches(Check_num, num_select)) {
//                    System.out.println("1~6숫자 선택완");
                    num = Integer.parseInt(num_select);
                    check = true;

                } else {
                    throw new InputException(8);
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }

        //메뉴판 입력받은 숫자 처리하기

        //↓ 1~4번 메뉴 처리
        if (1 <= num && num <= 4) {

            Goods good = new Goods(num, order);
            good.start();
            this.previousOrder = order.orderName;
            this.start();
        }
        //↓ 5번 메뉴 처리
        else if (num == 5) {
            this.previousOrder = null;
            //장바구니 안 비어있을때
            if(!order.basket.isEmpty()) {
                BigDecimal total = new BigDecimal("0");

                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println("[ Orders ]");
                for (String[] basketList : order.basket.values()) {
                    total = total.add(new BigDecimal(basketList[1]).multiply(new BigDecimal(basketList[2])));
                    System.out.printf("%-5s | W %s | %s개 | %s\n", basketList[0], basketList[1], basketList[2], basketList[3]);

                }
                System.out.println("[ Total ]");
                System.out.println("W " + total);
                System.out.println();
                System.out.println("1. 주문      2. 메뉴판");
                String NumCheck = sc.nextLine();
                if (NumCheck.equals("1")) {
                    System.out.println("주문이 완료되었습니다!");
                    System.out.println();
                    System.out.println("대기 번호는 [ 1 ]번 입니다.");
                    System.out.println("(3초후 메뉴판으로 돌아갑니다)");
                    //↓ 누적 메뉴 추가
                    for (String[] basketList : order.basket.values()) {
                        this.accumulatedMenu.add(new ArrayList<>(Arrays.asList(basketList[0], basketList[1])));
                    }
                    //↓ 누적 금액 추가
                    this.accumulatedAmount = this.accumulatedAmount.add(total);
                    //↓ 장바구니 비우기
                    order.basket.clear();
                    try {
                        Thread.sleep(3000);
                        System.out.println("---------------------------------------------------------------------------------");
                        this.start();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this.start();
                }
            }
            //장바구니 비어있을떄
            else{
                System.out.println("장바구니에 선택하신 메뉴가 없습니다. 2초뒤 메뉴판으로 갑니다");
                try {
                    Thread.sleep(2000);
                    System.out.println("---------------------------------------------------------------------------------");
                    this.start();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //↓ 6번 메뉴 처리
        else if (num == 6) {
            this.previousOrder = null;
            //장바구니 안 비어있을때
            if(!order.basket.isEmpty()) {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인         2. 취소");

                String NumCheck = sc.nextLine();
                if (NumCheck.equals("1")) {
                    System.out.println("진행하던 주문이 취소되었습니다.");
                    System.out.println("---------------------------------------------------------------------------------");
                    //↓ 장바구니 비우기
                    order.basket.clear();
                    this.start();

                } else {
                    this.start();
                }
            }
            //장바구니 비어있을떄
            else{
                System.out.println("장바구니에 선택하신 메뉴가 없습니다. 2초뒤 메뉴판으로 갑니다");
                try {
                    Thread.sleep(2000);
                    System.out.println("---------------------------------------------------------------------------------");
                    this.start();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //↓ 7번 누적 판매금액 출력문
        else if (num == 7) {
            this.previousOrder = null;
            System.out.println("[ 총 판매금액 현황 ]");
            System.out.println("현재까지 총 판매된 금액은 [ W "+this.accumulatedAmount+"] 입니다.");
            System.out.println("아무 숫자 누르시면 메뉴판으로");
            String back = sc.nextLine();
            if(back != null) this.start();

        }
        //↓ 8번 누적 메뉴 출력문
        else{
            this.previousOrder = null;
            System.out.println("[ 총 판매상품 목록 현황 ]");
            System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
            for (List list:this.accumulatedMenu) {
                System.out.printf("- %s | W %s \n",list.get(0),list.get(1));
            }
            System.out.println("아무 숫자 누르시면 메뉴판으로");
            String back = sc.nextLine();
            if(back != null) this.start();

        }


    }
}
