package models;

public class AppLogger {
    private String currentLevel;
    private final String[] levels = {"SEVERE", "WARNING", "INFO", "CONFIG", "FINE", "FINER", "FINEST"};

    public AppLogger(String level) {
        this.currentLevel = level.toUpperCase();
    }

    public void log(String level, String message) {
        if (shouldLog(level)) {
            System.out.println("[" + level + "] " + message);
        }
    }

    private boolean shouldLog(String messageLevel) {
        int currentIndex = getLevelIndex(currentLevel);
        int messageIndex = getLevelIndex(messageLevel);
        return messageIndex <= currentIndex;
    }

    private int getLevelIndex(String level) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].equals(level)) {
                return i;
            }
        }
        return 2;
    }
}
