package project.Goods_List;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Dessert_list {
    public HashMap<String,String[]> dessert = new LinkedHashMap<>();

    public Dessert_list(){
        this.dessert.put("1", new String[]{"소프트 콘 ","1.0","바닐라맛 아이스크림"} );
        this.dessert.put("2",new String[]{"선데이 ","2.5","바닐라 위에 초코시럽 아이스크림"} );
        this.dessert.put("3",new String[]{"스트로베리 콘","1.5","딸기맛 아이스크림"} );
        this.dessert.put("4",new String[]{"쿠키엔크림 콘","1.5","쿠키엔크림맛 아이스크림"} );

    }
}
