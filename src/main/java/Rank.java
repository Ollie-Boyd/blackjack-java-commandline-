public enum Rank {

    ACE(1, "Ace"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(11, "Jack"),
    QUEEN(12, "Queen"),
    KING(13, "King");

    private final int value;
    private final String rankString;

    Rank(int value, String rankString){
        this.value = value;
        this.rankString = rankString;
    }

    public int getValue(){
        return this.value;
    }

    public String getRankString(){
        return this.rankString;
    }
}
