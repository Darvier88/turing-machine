package turmach.model;
import java.util.HashMap;
import java.util.List;

//@author RashiBharuka

public class ConfigurationImpl implements Configuration{


	private Tape tape;
    private int currentPosition;
    private String currentState;
    private TuringMachine tm;

    public ConfigurationImpl(TuringMachine tm, Tape tape) {
        this.tm = tm;
        this.tape = tape;
        this.currentPosition = 0;
        this.currentState = tm.getInitialState();
    }

    @Override
    public int getLeftEnd() {
        return tape.getLeftEnd();
    }

    @Override
    public int getRightEnd() {
        return tape.getRightEnd();
    }

    @Override
    public int getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public String getCurrentState() {
        return this.currentState;
    }

    @Override
    public char getTapeCellSymbol(int position) {
        return tape.getSymbol(position);
    }

    @Override
    public boolean canAdvance() {
        for (int i = 0; i < tm.getRuleCount(); i++) {
            if (currentState.equals(tm.getRuleState(i)) && tape.getSymbol(currentPosition) == tm.getRuleSymbol(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void advance() {
        if (canAdvance()) {
            int suitableRuleNum = getSuitableRuleNum(this.currentPosition, this.currentState, this.tm);
            setCurrentState(this.tm.getRuleNewState(suitableRuleNum));
            setTapeCell(this.currentPosition, this.tm.getRuleNewSymbol(suitableRuleNum));
            int positionEffect = tm.getRuleDirection(suitableRuleNum) == Direction.RIGHT ? 1 : -1;
            setPosition(this.currentPosition + positionEffect);
        }
    }

    private int getSuitableRuleNum(int currentPosition, String currentState, TuringMachine tm) {
        for (int i = 0; i < tm.getRuleCount(); i++) {
            if (currentState.equals(tm.getRuleState(i)) && tape.getSymbol(currentPosition) == tm.getRuleSymbol(i)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void setTapeCell(int position, char newValue) {
        tape.setSymbol(position, newValue);
    }

    @Override
    public void setPosition(int position) {
        this.currentPosition = position;
    }

    @Override
    public void setCurrentState(String state) {
        this.currentState = state;
    }

	@Override
	public void addConfigurationObserver(ConfigurationObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConfigurationObserver(ConfigurationObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Character> getSymbolList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getBlankSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getInitialState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRuleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getRuleState(int ruleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getRuleSymbol(int ruleNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getRuleNewSymbol(int ruleNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Direction getRuleDirection(int ruleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRuleNewState(int ruleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeRule(int ruleNumber, String sourceState, char triggerSymbol, char replacementSymbol,
			Direction direction, String newState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRule(int ruleNumber, String sourceState, char triggerSymbol, char replacementSymbol,
			Direction direction, String newState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRule(int ruleNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSymbol(char symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSymbol(char symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObserver(TMObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObserver(TMObserver o) {
		// TODO Auto-generated method stub
		
	}

}
