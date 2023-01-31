package designPattern.builder;

public class Computer {
    private int serialNumber;
    private String model;
    private String vender;
    private String cpu;
    private int ram;
    private int disk;
    private String graphicCard;
    
    private Computer(int serialNumber, String model, String vender, String cpu, int ram, int disk, String graphicCard) {
        super();
        this.serialNumber = serialNumber;
        this.model = model;
        this.vender = vender;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.graphicCard = graphicCard;
    }
    
    @Override
    public String toString() {
        return "Computer [serialNumber=" + serialNumber + ", model=" + model + ", vender=" + vender + ", cpu=" + cpu
            + ", ram=" + ram + ", disk=" + disk + ", graphicCard=" + graphicCard + "]";
    }

    public static class ComputerBulider {
        private int serialNumber;
        private String model;
        private String vender;
        private String cpu;
        private int ram;
        private int disk;
        private String graphicCard;
        
        public ComputerBulider setSerialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }
        public ComputerBulider setModel(String model) {
            this.model = model;
            return this;
        }
        public ComputerBulider setVender(String vender) {
            this.vender = vender;
            return this;
        }
        public ComputerBulider setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public ComputerBulider setRam(int ram) {
            this.ram = ram;
            return this;
        }
        public ComputerBulider setDisk(int disk) {
            this.disk = disk;
            return this;
        }
        public ComputerBulider setGraphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }
        
        public Computer build() {
            Computer computer = new Computer(serialNumber, model, vender, cpu, ram, disk, graphicCard);
            return computer;
        }
    }
}