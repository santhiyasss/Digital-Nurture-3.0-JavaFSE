public class BuilderTest {
    public static void main(String[] args) {
        // Gaming PC
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 4090")
            .setOS("Windows 11")
            .build();

        // Office PC
        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .setOS("Windows 10")
            .build();

        System.out.println("--- Gaming PC ---");
        gamingPC.displayspecs();

        System.out.println("\n--- Office PC ---");
        officePC.displayspecs();
    }
}