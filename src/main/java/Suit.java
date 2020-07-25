public enum Suit {
    SPADES(4, "Spades"),
    HEARTS(3, "Hearts"),
    DIAMONDS(2, "Diamonds"),
    CLUBS(1, "Clubs");

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
