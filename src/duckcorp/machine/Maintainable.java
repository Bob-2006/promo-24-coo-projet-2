package duckcorp.machine;

public interface Maintainable {
    int getCondition();
    void maintain();
    
    default boolean needsMaintenance() {
        return getCondition() < 30;
    }
    
    default String getConditionLabel() {
        int c = getCondition();
        if (c >= 80) return "Parfait";
        if (c >= 50) return "Correct";
        if (c >= 30) return "Usé";
        return "Critique";
    }
}