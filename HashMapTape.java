
public class HashMapTape implements Tape {
	private HashMap<Integer, Character> tape;
    private char blankSymbol;

    public HashMapTape(char blankSymbol) {
        this.tape = new HashMap<>();
        this.blankSymbol = blankSymbol;
    }

    @Override
    public char getSymbol(int position) {
        return tape.getOrDefault(position, blankSymbol);
    }

    @Override
    public void setSymbol(int position, char symbol) {
        tape.put(position, symbol);
    }

    @Override
    public int getLeftEnd() {
        return tape.keySet().stream().min(Integer::compare).orElse(0);
    }

    @Override
    public int getRightEnd() {
        return tape.keySet().stream().max(Integer::compare).orElse(0);
    }
}
