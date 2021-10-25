package audExerc.exercTwo;

public class CombinationLock {
    private int combination;
    private boolean isOpen;
    private static int DEFAULT_COMBINATION = 100;

    public CombinationLock(int combination){
        if(isCombinationValid(combination))
            this.combination = combination;
        else
            this.combination = DEFAULT_COMBINATION;
        this.isOpen = false;
    }

    private boolean isCombinationValid(int combination) {
        return combination >= 100 && combination <= 999;
    }

    public boolean open(int combination) {
        this.isOpen = (this.combination == combination);
        return isOpen;
    }

    private boolean changeCombination(int oldCombination, int newCombination) {
        if(isCombinationValid(newCombination) && open(oldCombination)) {
            this.combination = newCombination;
            return true;
        }
        else return false;
    }

    private void lock() {
        this.isOpen = false;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public static void main(String[] args) {
        CombinationLock validLock = new CombinationLock(234);
        System.out.println(validLock.getIsOpen());
        System.out.println(validLock.open(213));
        System.out.println(validLock.open(234));
        validLock.lock();
        System.out.println(validLock.changeCombination(234,777));
        System.out.println(validLock.open(777));






        CombinationLock invalidLock = new CombinationLock(234);


    }
}
