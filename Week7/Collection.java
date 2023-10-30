package Week7;


public class Collection {
    private Card[] binder;
    private int cardsOwned = 0;

    public Collection(Card[] binder) {
        this.binder = binder;
        this.cardsOwned = calcCardsOwned(binder);
    }

    public Collection() {
        this.binder = new Card[4];
        this.cardsOwned = calcCardsOwned(binder);
    }

    public Card addCard(int index, Card card) {
        if (isValidIndex(index) && isValidCard(card)) {
            Card oldCard = this.binder[index];
            this.binder[index] = card;
            if (oldCard == null) {
                System.out.println("Inserted: " + card);
                this.cardsOwned++;
                return null;
            } else {
                System.out.println("Replaced: " + oldCard);
                return oldCard;
            }
        } else {
            System.out.println("Cannot add a card to this spot.");
            return null;
        }
    }

    public Card sellCard(int index) {
        if (isValidIndex(index) && this.binder[index] != null) {
            Card removedCard = this.binder[index];
            System.out.println("Sold: " + this.binder[index]);
            this.binder[index] = null;
            this.cardsOwned--;
            return removedCard;
        } else {
            System.out.println("There was no card to sell!");
            return null;
        }
    }

    public void showCertainCards(int condition) {
        for (int i = 0; i < this.binder.length; i++) {
            if (isValidCard(this.binder[i])) {
                if (this.binder[i].getCondition() > condition) {
                    System.out.println(this.binder[i]);
                }
            }
        }
    }

    public void restoreAllCards() {
        int countExecuted = 0;
        for (int i = 0; i < binder.length; i++) {
            if (isValidCard(this.binder[i]) && this.binder[i].isRestorable()) {
                int randomNum = (int) ((Math.random() * 10) + 1);
                int newRestoredValue = this.binder[i].getCondition() + randomNum;
                System.out.println("Restored to " + newRestoredValue + ": " + this.binder[i]);
                this.binder[i].setCondition(newRestoredValue);
                countExecuted++;
            }
        }
        if (countExecuted == 0) {
            System.out.println("There were no cards to restore.");
        }
    }

    public void battle(int index) {
        if (isValidIndex(index) && isValidCard(this.binder[index])) {
            int randomNum = (int) ((Math.random() * 10) + 1);
            if (this.binder[index].getCondition() - randomNum > 40) {
                this.binder[index].setCondition(this.binder[index].getCondition() - randomNum);
            } else {
                this.binder[index].setCondition(40);
            }
            System.out.println("Used: " + this.binder[index]);
        } else {
            System.out.println("Cannot battle with a card at this spot.");
        }
    }

    public String toString() {
        if (cardsOwned == 0) {
            return "I own no cards!";
        } else {
            String returnString = String.format("I own %d cards.", this.cardsOwned);
            for (int i = 0; i < this.binder.length; i++) {
                if (isValidCard(this.binder[i])) {
                    returnString += "\n" + this.binder[i];
                }
            }
            return returnString;
        }
    }

    private boolean isValidIndex(int index) {
        if (index >= 0 && index < this.binder.length) {
            return true;
        }
        return false;
    }

    private boolean isValidCard(Card card) {
        if (card != null) {
            return true;
        }
        return false;

    }

    private int calcCardsOwned(Card[] b) {
        int counter = 0;
        for (int i = 0; i < b.length; i++) {
            counter = b[i] == null ? counter : counter + 1;
        }
        return counter;
    }
}
