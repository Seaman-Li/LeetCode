package Greed;

import java.util.ArrayList;
import java.util.List;

class TroopItem{
    int id;
    int type;
    int level;
    int load;//装载值
    int force;//战力
    int own_num;//拥有数量
    int select_num;//出战数量

    public TroopItem(int id, int type, int level, int load, int force, int own_num) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.load = load;
        this.force = force;
        this.own_num = own_num;
        this.select_num = 0; // 初始化选择数量
    }
}

public class QuickSelectTroop {
    public static List<TroopItem> QuickSelectTroopList
            (int res_max, int march_size_max, List<TroopItem> own_troop_list) {
        // 按装载值从高到低排序
        own_troop_list.sort((a, b) -> b.load - a.load);

        int remain_res = res_max; // 剩余资源量上限
        int remain_march = march_size_max; // 剩余出兵数量上限

        List<TroopItem> selectedTroops = new ArrayList<>();

        for (TroopItem troop : own_troop_list) {
            if (remain_res <= 0 || remain_march <= 0) // 资源满了或出兵数量满了，停止选择
                break;

            // 计算当前兵种最大能派的数量
            int maxNum_curTroop = Math.min(remain_res / troop.load, troop.own_num);
            //确保：不会超过最大派兵数和当前士兵能派出的最大值。
            int sendNum = Math.min(maxNum_curTroop, remain_march);

            if (sendNum > 0) {
                TroopItem selected = new TroopItem(troop.id, troop.type, troop.level, troop.load, troop.force, troop.own_num);
                selected.select_num = sendNum; // 记录选择的数量
                selectedTroops.add(selected);

                // 更新剩余资源和可派士兵数
                remain_res -= sendNum * troop.load;
                remain_march -= sendNum;
            }
        }

        return selectedTroops;
    }


    public static void main(String[] args) {
        List<TroopItem> troops = new ArrayList<>();
        troops.add(new TroopItem(1, 1, 4, 80, 100, 100)); // load 50
        troops.add(new TroopItem(2, 2, 3, 30, 80, 20)); // load 30
        troops.add(new TroopItem(3, 3, 2, 20, 60, 30)); // load 20
        troops.add(new TroopItem(4, 4, 1, 10, 40, 500)); // load 10

        int res_max = 5000;
        int march_size_max = 100;

        List<TroopItem> selectedTroops = QuickSelectTroopList(res_max, march_size_max, troops);

        // 输出选择的士兵列表
        System.out.println("Selected Troops:");
        for (TroopItem t : selectedTroops) {
            System.out.println("ID: " + t.id + ", Type: " + t.type + ", Load: " + t.load + ", Selected: " + t.select_num);
        }
    }
}
