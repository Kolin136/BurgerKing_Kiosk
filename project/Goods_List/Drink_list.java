package project.Goods_List;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Drink_list {
    public HashMap<String,String[]> drink = new LinkedHashMap<>();

    public Drink_list(){
        this.drink.put("1", new String[]{"콜라,사이다","1.7","더 짜릿하게!"} );
        this.drink.put("2",new String[]{"아메리카노","1.0","자연을 담은 버거킹RA인증커피"} );
        this.drink.put("3",new String[]{"씨그램","1.7","깔끔한 플레인부터 상쾌한 레몬향"} );
        this.drink.put("4",new String[]{"미닛에이드 오렌지","2.7","자연의 풍부한 영양과 맛"} );

    }
}
