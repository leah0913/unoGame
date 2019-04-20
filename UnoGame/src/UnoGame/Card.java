package UnoGame;

public class Card {

    private String cardColour;
    private int cardNum;
    private int specialValue;
    private boolean special;

    /**
     * Constructs a non special card and sets the card number and cardColour.
     *
     * @param value
     * @param colour
     */
    public Card(int value, String colour) {
        this.cardColour = colour;
        this.cardNum = value;
        this.specialValue = 0;
        this.special = false;
    }

    /**
     * Constructs special cards such as +4 and +2 Sets special cardNum to the
     * card
     *
     * @param specialValue
     */
    public Card(int specialValue) {
        this.cardColour = "";
        this.specialValue = specialValue;
        this.cardNum = 0;
        this.special = true;
    }

    /**
     * Getter of cardClolour
     *
     * @return cardColour
     */
    public String getCardColour() {
        return this.cardColour;
    }

    /**
     * Getter of cardNumber
     *
     * @return cardNum
     */
    public int getCardNum() {
        if (!this.special) {
            return this.cardNum;
        } else {
            return this.specialValue;
        }
    }

    /**
     * This play the current card on the floor
     *
     * @return String form of the current card on the floor
     */
    public String toString() {
        String[] card = {" ##### ", "#     #", "#     #", " ##### "};
        String c = "";
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < 1; j++) {
                if (!this.isSpecial()) {
                    if (i == 1) {
                        c = c + "# " + this.getCardColour() + " #" + " ";
                    } else if (i == 2) {
                        c = c + "#  " + this.getCardNum() + "  #" + " ";
                    } else {
                        c = c + card[i] + " ";
                    }
                } else if (this.isSpecial()) {
                    if (i == 1) {
                        c = c + "# " + "+" + this.getCardNum() + "  #" + " ";
                    } else {
                        c = c + card[i] + " ";
                    }
                }
            }
            c += "\n";
        }
        return c;
    }

    /**
     * Getter of variable 'special'. Check if the card is special or not
     *
     * @return returns true if card is a special card
     */
    public boolean isSpecial() {
        if (special) {
            return true;
        }
        return false;
    }

}
