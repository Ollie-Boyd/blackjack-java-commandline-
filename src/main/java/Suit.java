public enum Suit {
    SPADES(4, "♠"),
    HEARTS(3, "♥"),
    DIAMONDS(2, "♦"),
    CLUBS(1, "♣");

    private final int value;
    private final String suitString;

    Suit(int value, String suitString){
        this.value = value;
        this.suitString = suitString;
    }

    public int getValue(){
        return this.value;
    }

    public String getSuitString(){
        return this.suitString;
    }
}
