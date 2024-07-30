public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final boolean isGamingReady;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.isGamingReady = builder.isGamingReady;
    }

    @Override
    public String toString() {
        return "Computer{" +
               "CPU='" + CPU + '\'' +
               ", RAM='" + RAM + '\'' +
               ", storage='" + storage + '\'' +
               ", graphicsCard='" + graphicsCard + '\'' +
               ", isGamingReady=" + isGamingReady +
               '}';
    }

    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage;
        private String graphicsCard;
        private boolean isGamingReady;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setGamingReady(boolean isGamingReady) {
            this.isGamingReady = isGamingReady;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
