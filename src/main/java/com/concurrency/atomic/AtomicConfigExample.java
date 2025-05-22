package com.concurrency.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicConfigExample {
    private static class Config {
        private final String setting;
        private final int value;

        Config(String setting, int value) {
            this.setting = setting;
            this.value = value;
        }

        @Override
        public String toString() {
            return setting + "=" + value;
        }
    }

    private final AtomicReference<Config> config = new AtomicReference<>(new Config("default", 0));

    public void updateConfig(String setting, int value) {
        config.updateAndGet(current -> {
            if (current.value < value) { // فقط اگه مقدار جدید بزرگ‌تر باشه
                return new Config(setting, value);
            }
            return current;
        });
    }

    public Config getConfig() {
        return config.get();
    }
}
