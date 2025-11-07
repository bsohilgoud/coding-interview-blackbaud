import java.util.*;
import java.util.stream.Collectors;

public class Deck {
    private Stack<Card> cards;

    private Deck(Collection<Card> cards) {
        this.cards = new Stack<>();
        this.cards.addAll(cards);
    }

    public static Deck newDeck() {
        List<Card> cards = Arrays.stream(Suit.values())
            .flatMap(suit ->
                Arrays.stream(Rank.values())
                    .map(rank -> new Card(rank, suit))
            ).collect(Collectors.toList());
        return new Deck(cards);
    }

    public int countRemainingCards() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card nextCard() {
        if (isEmpty() == false) {
            return cards.pop();
        } else {
            return null;
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void shuffle(int times){
        if(times < 0)
            throw new IllegalArgumentException("Invalid argument for shuffle (negative times)!!!");
        while (times-- > 0) {
            shuffle();
        }
    }
}
