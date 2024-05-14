package designPattern.builder;

public class main {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBulider()
            .setCpu("i9")
            .setDisk(256)
            .build();
        System.out.println(computer);
    }
}
