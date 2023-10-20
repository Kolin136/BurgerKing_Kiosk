package project.Goods_List;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Burger_list {
    public HashMap<String,String[]> burger = new LinkedHashMap<>();
    public HashMap<String,String[]> burgerSet = new LinkedHashMap<>();
    public Burger_list(){
        this.burger.put("1", new String[]{"몬스터와퍼","10.2","디아블로소스의 매콤함"} );
        this.burgerSet.put("1", new String[]{"몬스터와퍼(세트)","14.2","디아블로소스의 매콤함"} );

        this.burger.put("2",new String[]{"통새우와퍼","8.8","통새우가 매콤한 스파이시 토마토소스"} );
        this.burgerSet.put("2",new String[]{"통새우와퍼(세트)","12.8","통새우가 매콤한 스파이시 토마토소스"} );

        this.burger.put("3",new String[]{"갈릭불고기와퍼","8.3","크리스피 갈릭칩과 달콤한 불고기소스"} );
        this.burgerSet.put("3",new String[]{"갈릭불고기와퍼(세트)","12.3","크리스피 갈릭칩과 달콤한 불고기소스"} );

        this.burger.put("4",new String[]{"트러플머쉬품","9.4","트러플소스 2배로 더욱 깊어진 풍미"} );
        this.burgerSet.put("4",new String[]{"트러플머쉬품(세트)","13.4","트러플소스 2배로 더욱 깊어진 풍미"} );

    }


}
