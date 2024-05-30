import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ATM {
    private Map<Integer, Denomination> denominations = new TreeMap<>((a, b) -> b - a);

    public void topUp(int value, int count) {
        denominations.putIfAbsent(value, new Denomination(value, count));
        denominations.get(value).addCount(count);
    }

    public void withdraw(int amount) {
        if (!isValidAmount(amount)) {
            System.out.println("Error: Amount is not in the factor of available denominations");
            return;
        }
        if (!hasSufficientBalance(amount)) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        Map<Integer, Integer> withdrawnNotes = new HashMap<>();
        for (Denomination denomination : denominations.values()) {
            if (!denomination.isValid()) continue;
            int noteValue = denomination.getValue();
            int noteCount = denomination.getCount();

            if (amount >= noteValue && noteCount > 0) {
                int notesToWithdraw = Math.min(amount / noteValue, noteCount);
                withdrawnNotes.put(noteValue, notesToWithdraw);
                amount -= notesToWithdraw * noteValue;
                denomination.reduceCount(notesToWithdraw);
            }
        }

        if (amount == 0) {
            System.out.println("Withdrawn Notes: " + withdrawnNotes);
        } else {
            System.out.println("Error: Unable to dispense the exact amount with available denominations");
        }
    }

    public void invalidateDenomination(int value) {
        Denomination denomination = denominations.get(value);
        if (denomination != null) denomination.invalidate();
    }

    public void validateDenomination(int value) {
        Denomination denomination = denominations.get(value);
        if (denomination != null) denomination.validate();
    }

    public void addNewDenomination(int value) {
        denominations.putIfAbsent(value, new Denomination(value, 0));
    }

    private boolean isValidAmount(int amount) {
        return denominations.values().stream().anyMatch(d -> d.isValid() && amount % d.getValue() == 0);
    }

    private boolean hasSufficientBalance(int amount) {
        return denominations.values().stream()
                .filter(Denomination::isValid)
                .mapToInt(d -> d.getValue() * d.getCount())
                .sum() >= amount;
    }
}

