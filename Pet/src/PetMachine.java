public class PetMachine {

    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na maquina.");
            return;
        }

        if (this.water < 10) {
            System.out.println("Não há água suficiente para dar banho no pet. Mínimo necessário: 10 litros.");
            return;
        }
        if (this.shampoo < 2) {
            System.out.println("Não há shampoo suficiente para dar banho no pet. Mínimo necessário: 2 litros.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " tomou banho.");
    }

    public void addWater() {
        if (water >= 30) {
            System.out.println("Máquina com água no máximo (30 litros).");
            return;
        }
        water = Math.min(water + 10, 30);
        System.out.println("Adicionando água. Total de água: " + water + " litros.");
    }

    public void addShampoo() {
        if (shampoo >= 10) {
            System.out.println("Máquina com shampoo no máximo (10 litros).");
            return;
        }
        shampoo = Math.min(shampoo + 2, 10);
        System.out.println("Adicionando shampoo. Total de shampoo: " + shampoo + " litros.");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public String getPetName() {
        return hasPet() ? pet.getName() : "";
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina está suja. Limpe-a antes de adicionar um pet.");
            return;
        }

        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " já está na máquina.");
            return;
        }

        this.pet = pet;
        this.clean = false;
        System.out.println("Pet " + pet.getName() + " adicionado à máquina.");
    }

    public void removePet() {
        if (!hasPet()) {
            System.out.println("Nenhum pet na máquina.");
            return;
        }

        this.clean = this.pet.isClean();
        System.out.println("Pet " + pet.getName() + " removido da máquina.");
        this.pet = null;
    }

    public void wash() {
        if (hasPet()) {
            System.out.println("Remova o pet antes de limpar a máquina.");
            return;
        }

        if (this.water < 10) {
            System.out.println("Não há água suficiente para limpar a máquina. Mínimo necessário: 10 litros.");
            return;
        }
        if (this.shampoo < 2) {
            System.out.println("Não há shampoo suficiente para limpar a máquina. Mínimo necessário: 2 litros.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("Máquina limpa com sucesso!");
    }
}