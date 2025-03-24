package Game;

import java.util.*;

public class LandlordVSFarmers {

    // 定义牌型
    public enum CardType {
        SINGLE,          // 单牌Single
        PAIR,            // 对子Pair
        TRIPLE,          // 三张Triple
        TRIPLE_WITH_ONE, // 三带一TripleWithOne
        TRIPLE_WITH_TWO, // 三带二TripleWithTwo
        STRAIGHT,        // 顺子Straight
        DOUBLE_STRAIGHT, // 连对DoubleStraight
        AIRPLANE,        // 飞机Airplane
        BOMB,            // 炸弹Bomb
        KING_BOMB        // 王炸KingBomb
    }

    // 定义牌的大小顺序
    private static final Map<String, Integer> CARD_RANK = new HashMap<>();
    static {
        CARD_RANK.put("3", 1);
        CARD_RANK.put("4", 2);
        CARD_RANK.put("5", 3);
        CARD_RANK.put("6", 4);
        CARD_RANK.put("7", 5);
        CARD_RANK.put("8", 6);
        CARD_RANK.put("9", 7);
        CARD_RANK.put("10", 8);
        CARD_RANK.put("J", 9);
        CARD_RANK.put("Q", 10);
        CARD_RANK.put("K", 11);
        CARD_RANK.put("A", 12);
        CARD_RANK.put("2", 13);
        CARD_RANK.put("S", 14); // 小王
        CARD_RANK.put("B", 15); // 大王
    }

    // 获取牌的计数 Map
    private static Map<String, Integer> getCardCountMap(List<String> cards) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String card : cards) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        return countMap;
    }

    // 获取牌的排序列表
    private static List<Integer> getCardRanks(List<String> cards) {
        List<Integer> ranks = new ArrayList<>();
        for (String card : cards) {
            ranks.add(CARD_RANK.get(card));
        }
        return ranks;
    }

    // 判断是否为单牌
    private static boolean isSingle(List<String> cards) {
        return cards.size() == 1;
    }

    // 判断是否为对子
    private static boolean isPair(List<String> cards) {
        if (cards.size() != 2) return false;
        return cards.get(0).equals(cards.get(1));
    }

    // 判断是否为三张
    private static boolean isTriple(List<String> cards) {
        if (cards.size() != 3) return false;
        return cards.get(0).equals(cards.get(1)) && cards.get(1).equals(cards.get(2));
    }

    // 判断是否为三带一
    private static boolean isTripleWithOne(List<String> cards) {
        if (cards.size() != 4) return false;
        Map<String, Integer> countMap = getCardCountMap(cards);
        return countMap.containsValue(3) && countMap.containsValue(1);
    }

    // 判断是否为三带二
    private static boolean isTripleWithTwo(List<String> cards) {
        if (cards.size() != 5) return false;
        Map<String, Integer> countMap = getCardCountMap(cards);
        return countMap.containsValue(3) && countMap.containsValue(2);
    }

    // 判断是否为顺子
    private static boolean isStraight(List<String> cards) {
        if (cards.size() < 5 || cards.size() > 12) return false;
        List<Integer> ranks = getCardRanks(cards);
        Collections.sort(ranks);
        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i) != ranks.get(i - 1) + 1) return false;
        }
        return true;
    }

    // 判断是否为连对
    private static boolean isDoubleStraight(List<String> cards) {
        if (cards.size() < 4 ||cards.size() % 2 != 0) return false;
        Map<String, Integer> countMap = getCardCountMap(cards);// 统计每张牌的数量
        for (int count : countMap.values()) {
            if (count != 2) return false;// 每张牌必须恰好出现 2 次
        }
        // 获取所有牌的唯一值并排序
        List<String> uniqueCards = new ArrayList<>(countMap.keySet());
        uniqueCards.sort(Comparator.comparingInt(card -> CARD_RANK.get(card)));

        // 检查对子是否连续
        for (int i = 1; i < uniqueCards.size(); i++) {
            int currentRank = CARD_RANK.get(uniqueCards.get(i));
            int previousRank = CARD_RANK.get(uniqueCards.get(i - 1));
            if (currentRank != previousRank + 1) return false; // 对子必须连续
        }

        return true;
    }

    private static boolean isAirplane(List<String> cards) {
        // 检查牌数是否为 3 的倍数且至少为 6 张
        if (cards.size() < 6 || cards.size() % 3 != 0) return false;
        // 统计每张牌的数量
        Map<String, Integer> countMap = getCardCountMap(cards);
        for (int count : countMap.values()) {
            if (count != 3) return false; // 每张牌必须恰好出现 3 次
        }
        // 获取所有牌的唯一值并排序
        List<String> uniqueCards = new ArrayList<>(countMap.keySet());
        uniqueCards.sort(Comparator.comparingInt(card -> CARD_RANK.get(card)));
        // 检查三张牌是否连续
        for (int i = 1; i < uniqueCards.size(); i++) {
            int currentRank = CARD_RANK.get(uniqueCards.get(i));
            int previousRank = CARD_RANK.get(uniqueCards.get(i - 1));
            if (currentRank != previousRank + 1) return false; // 三张牌必须连续
        }
        return true;
    }

    // 判断是否为炸弹
    private static boolean isBomb(List<String> cards) {
        if (cards.size() != 4) return false;
        return cards.get(0).equals(cards.get(1)) &&
                cards.get(1).equals(cards.get(2)) &&
                cards.get(2).equals(cards.get(3));
    }

    // 判断是否为王炸
    private static boolean isKingBomb(List<String> cards) {
        if (cards.size() != 2) return false;
        return cards.contains("S") && cards.contains("B");
    }

    // 判断出牌是否合法
    public static boolean isLegalPlay(List<String> cards, CardType type) {
        switch (type) {
            case SINGLE:
                return isSingle(cards);
            case PAIR:
                return isPair(cards);
            case TRIPLE:
                return isTriple(cards);
            case TRIPLE_WITH_ONE:
                return isTripleWithOne(cards);
            case TRIPLE_WITH_TWO:
                return isTripleWithTwo(cards);
            case STRAIGHT:
                return isStraight(cards);
            case DOUBLE_STRAIGHT:
                return isDoubleStraight(cards);
            case AIRPLANE:
                return isAirplane(cards);
            case BOMB:
                return isBomb(cards);
            case KING_BOMB:
                return isKingBomb(cards);
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        // 测试用例
        List<String> single = Arrays.asList("A");
        List<String> pair = Arrays.asList("K", "K");
        List<String> triple = Arrays.asList("Q", "Q", "Q");
        List<String> tripleWithOne = Arrays.asList("J", "J", "J", "10");
        List<String> tripleWithTwo = Arrays.asList("10", "10", "10", "9", "9");
        List<String> straight = Arrays.asList("3", "4", "5", "6", "7");
        List<String> doubleStraight = Arrays.asList("3", "3", "4", "4", "5", "5");
        List<String> airplane = Arrays.asList("3", "3", "3", "4", "4", "4");
        List<String> bomb = Arrays.asList("2", "2", "2", "2");
        List<String> kingBomb = Arrays.asList("S", "B");

        System.out.println("Single: " + isLegalPlay(single, CardType.SINGLE)); // true
        System.out.println("Pair: " + isLegalPlay(pair, CardType.PAIR)); // true
        System.out.println("Triple: " + isLegalPlay(triple, CardType.TRIPLE)); // true
        System.out.println("Triple with one: " + isLegalPlay(tripleWithOne, CardType.TRIPLE_WITH_ONE)); // true
        System.out.println("Triple with two: " + isLegalPlay(tripleWithTwo, CardType.TRIPLE_WITH_TWO)); // true
        System.out.println("Straight: " + isLegalPlay(straight, CardType.STRAIGHT)); // true
        System.out.println("Double straight: " + isLegalPlay(doubleStraight, CardType.DOUBLE_STRAIGHT)); // true
        System.out.println("Airplane: " + isLegalPlay(airplane, CardType.AIRPLANE)); // true
        System.out.println("Bomb: " + isLegalPlay(bomb, CardType.BOMB)); // true
        System.out.println("King bomb: " + isLegalPlay(kingBomb, CardType.KING_BOMB)); // true
    }

}
