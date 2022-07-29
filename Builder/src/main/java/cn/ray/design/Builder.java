package cn.ray.design;

import cn.ray.design.ceiling.LevelOneCeiling;
import cn.ray.design.ceiling.LevelTwoCeiling;
import cn.ray.design.coat.DuluxCoat;
import cn.ray.design.coat.LiBangCoat;
import cn.ray.design.floor.ShengXiangFloor;
import cn.ray.design.tile.DongPengTile;
import cn.ray.design.tile.MarcoPoloTile;

/**
 * @author JOJO
 * @date 2022/7/29 22:56
 */
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，一级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
