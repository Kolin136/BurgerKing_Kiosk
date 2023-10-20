package project.Goods_List;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Side_list {
    public HashMap<String,String[]> side = new LinkedHashMap<>();

    public Side_list(){
        this.side.put("1", new String[]{"너겟킹 4조각","3.1","바삭하고 촉촉한 부드러운 너겟킹!"} );
        this.side.put("2",new String[]{"해쉬브라운","2.7","촉촉한 감자에 바삭함은 더했다"} );
        this.side.put("3",new String[]{"어니언링","3.3","고소한 진한 풍미가 일품인 어니언링"} );
        this.side.put("4",new String[]{"코울슬로","3.0","아삭아삭한 양배추와 상큼한 드레싱의 조화"} );
        this.side.put("5",new String[]{"디아블로소스","0.5","스낵을 더 매콤하게!"} );

    }
}
