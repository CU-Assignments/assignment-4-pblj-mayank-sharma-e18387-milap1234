import java.util.*;

class CardCollection {
    private HashMap<String, List<String>> cardMap;
    
    public CardCollection() {
        cardMap = new HashMap<>();
    }
    
    public void addCard(String symbol, String card) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(card);
    }
    
    public List<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, new ArrayList<>());
    }
    
    public void displayAllCards() {
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();
        
        collection.addCard("Hearts", "Ace");
        collection.addCard("Hearts", "King");
        collection.addCard("Spades", "Queen");
        collection.addCard("Spades", "Jack");
        collection.addCard("Diamonds", "10");
        collection.addCard("Clubs", "7");
        
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Search Cards by Symbol");
            System.out.println("2. Display All Cards");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter symbol (e.g., Hearts, Spades): ");
                    String symbol = scanner.nextLine();
                    List<String> cards = collection.getCardsBySymbol(symbol);
                    if (cards.isEmpty()) {
                        System.out.println("No cards found for symbol: " + symbol);
                    } else {
                        System.out.println("Cards in " + symbol + ": " + cards);
                    }
                    break;
                case 2:
                    collection.displayAllCards();
                    break;
                case 3:
                    System.out.println("Exiting Card Collection System...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
