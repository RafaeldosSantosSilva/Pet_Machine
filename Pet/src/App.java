import java.util.Scanner;

public class App {
    private final static Scanner scanner = new java.util.Scanner(System.in);
    private static PetMachine petMachine = new PetMachine();
    public static void main(String[] args) throws Exception {
       
        var option = -1;

        do {
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Adicionar pet à máquina");
            System.out.println("2 - Remover pet da máquina");
            System.out.println("3 - Limpar máquina");
            System.out.println("4 - Verificar se há pet na máquina");
            System.out.println("5 - Dar banho no pet");
            System.out.println("6 - Verificar água da màquina");
            System.out.println("7 - Adicionar água ");
            System.out.println("8 - Verificar shampoo da màquina");
            System.out.println("9 - Adicionar shampoo");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch(option){
                case 1 -> setPetInMachine();
                case 2 -> petMachine.removePet();
                case 3 -> petMachine.wash();
                case 4 -> checkIfHasPetInMachine();
                case 5 -> petMachine.takeAShower();
                case 6 -> verifyWater();
                case 7 -> setWater();
                case 8 -> verifyShampoo();
                case 9 -> setShampoo();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");

                
            }



            
        } while (true);
    }


    private static void setShampoo(){
        System.out.println("Tentando adicionar Shampoo...");
        petMachine.addShampoo();

    }

    private static void verifyShampoo() {
        var amountShampoo = petMachine.getShampoo();
        System.out.println("Shampoo disponível: " + amountShampoo + " litros de shampoo.");
    }
    

    private static void setWater(){
        System.out.println("Tentando adicionar água...");
        petMachine.addWater();

    }


    private static void verifyWater() {
        var amountWater = petMachine.getWater();
        System.out.println("Água disponível: " + amountWater + " litros de água.");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println("A máquina " + (hasPet ? "tem o pet " + petMachine.getPetName() : "não tem pet") + ".");
    }

    public static void setPetInMachine() {
        var name = "";
        while(name == null || name.isEmpty()) {
            System.out.println("Digite o nome do pet: ");
            name = scanner.next();
            
        }
        
        var  pet = new Pet(name);
        petMachine.setPet(pet);
        System.out.println("Pet " + pet.getName() + " adicionado à máquina.");
        }

}
   
