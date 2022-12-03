package io.github.cyklon73.cytils.gui.swing;

public class ConsolePogressbar {

    private final int maxValue;
    private final JConsole console;
    private int currentValue = 0;

    private final boolean percentMode;

    private String[] oldString = new String[] {null, null};

    public ConsolePogressbar(int maxValue, JConsole console) {
        this.maxValue = maxValue;
        this.console = console;
        this.percentMode = maxValue == 100;

        console.logInLine(getPercentage() + "% ");
        console.log(getProgressString(), new StyleFactory().setSize(5).build());
    }

    public void addProgress() {
        int oldProgress = currentValue;
        currentValue++;
        updateBar(oldProgress, currentValue);
    }

    public void setProgress(int value) {
        int oldProgress = currentValue;
        this.currentValue = value;
        updateBar(oldProgress, currentValue);
    }

    private void updateBar(int oldValue, int newValue) {
        if (oldValue == newValue) return;
        //console.replace(getProgressString(oldValue), getProgressString(newValue), new StyleFactory().setSize(5).build());
        for (String s : oldString) if (s != null) console.remove(s);
        console.logInLine(oldString[0] = getPercentage() + "% ");
        console.log(oldString[1] = getProgressString(newValue), new StyleFactory().setSize(5).build());
    }


    private String getProgressString() {
        return getProgressString(currentValue);
    }

    private String getProgressString(int value) {
        int percentage = percentMode ? value : calculatePercentage(value, maxValue);
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i <= 100; i++) {
            if (i <= percentage) s.append("█");
            else s.append("░");
        }
        s.append("]");
        return s.toString();
    }

    private int getPercentage() {
        return percentMode ? currentValue : calculatePercentage(currentValue, maxValue);
    }
    private int calculatePercentage(int value, int maxValue) {
        return Math.min(Math.max((int) ((((double) value) /((double) maxValue)) * 100d), 0), 100);
    }

}

