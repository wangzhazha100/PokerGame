
import com.example.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 一副扑克牌
 *  1、初始化牌
 *  2、洗牌
 *  3、发牌
 *  4、抽牌
 *  5、比较大小
 */
public class PokerGame {
    private static final int[] SUITS = {0x1, 0x2, 0x3, 0x4}; // 方块、梅花、黑桃、红桃分别对应十六进制的1、2、3、4
    private static final int[] VALUES = {0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9, 0xA, 0xB, 0xC, 0xD, 0xE, 0xF}; // 3到2的牌面数字
    private static final int SMALL_JOKER = 0xEE; // 小王
    private static final int BIG_JOKER = 0xFF; // 大王

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        // 初始化扑克牌 (52张牌)
        for (int suit : SUITS) {
            for (int value : VALUES) {
                deck.add(new Card((value << 4) | suit)); // 将数字和花色合并成十六进制值
            }
        }

        // 加入大小王
        deck.add(new Card(SMALL_JOKER));
        deck.add(new Card(BIG_JOKER));

        // 洗牌
        Collections.shuffle(deck);

        // 发牌
        List<List<Card>> players = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            players.add(new ArrayList<>());
        }

        for (int i = 0; i < deck.size(); i++) {
            players.get(i % 3).add(deck.get(i));
        }

        // 每人抽一张牌
        Random random = new Random();
        List<Card> drawnCards = new ArrayList<>();
        for (List<Card> player : players) {
            Card drawnCard = player.remove(random.nextInt(player.size()));
            drawnCards.add(drawnCard);
            System.out.println("玩家出牌：" + drawnCard);
        }

        // 比大小
        Card winner = drawnCards.get(0);
        for (Card card : drawnCards) {
            if (winner.getValue() < card.getValue()) {
                winner = card;
            }
        }

        System.out.println("赢的牌号：" + winner);
    }
}