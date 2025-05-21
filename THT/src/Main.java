import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Signup {
    public String usn;
    public String pass;

    public Signup(String usn, String pass) {
        this.usn = usn;
        this.pass = pass;
    }

    public void display() {
        System.out.println("Username: " + usn);
        System.out.println("Password: " + pass);
    }
}

class Login extends Signup {
    public Login(String usn, String pass) {
        super(usn, pass);
    }

    public void display() {
        System.out.println("Login details:");
        super.display();
    }
}

class Player {
    public int health;
    public int mana;
    public int level;

    public Player() {
        this.health = 0;
        this.mana = 0;
        this.level = 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void display() {
        System.out.println("\n===== Player Stats =====");
        System.out.println("Health : " + health);
        System.out.println("Mana   : " + mana);
        System.out.println("Level  : " + level);
        System.out.println("========================\n");
    }

}

class Backpack {
    public double blood;
    public double mana;
    public int potion;
    ArrayList<String> items = new ArrayList<>();

    public Backpack() {
        this.blood = 0;
        this.mana = 0;
        this.potion = 0;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void display() {
        System.out.println("\n===== Backpack =====");
        System.out.println("Blood  : " + blood);
        System.out.println("Mana   : " + mana);
        System.out.println("Potions: " + potion);
        System.out.println("Items  :");
        int i = 1;
        for (String item : items) {
            System.out.println("  " + i + ". " + item);
            i++;
        }
        System.out.println("====================\n");
    }

    public void setBlood(double blood) {
        this.blood = blood;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }
}

class RandomAction {
    private final String[] foundItems = {"Sword", "Shield", "Gold", "Magic Scroll", "Blood"};
    private final String[] enemies = {"Goblin", "Skeleton", "Orc", "Dark Mage"};
    private final String[] dungeons = {"Ancient Ruins", "Mystic Cave", "Abandoned Temple"};
    private final String[] traps = {"Poison Gas", "Spike Trap", "Exploding Floor"};

    public void trigger(Player player, Backpack backpack) {
        Random rand = new Random();
        int eventType = rand.nextInt(5); // 0 to 4
        switch (eventType) {
            case 0 -> {
                String item = foundItems[rand.nextInt(foundItems.length)];
                System.out.println("You found an item: " + item);
                backpack.addItem(item);
                System.out.println("Item added to backpack.");
            }
            case 1 -> {
                String enemyName = enemies[rand.nextInt(enemies.length)];
                int enemyHealth = rand.nextInt(51) + 50; // Health between 50 and 100
                int enemyAttack = rand.nextInt(11) + 10; // Attack between 10 and 20

                Enemy enemy = new Enemy(enemyName, enemyHealth, enemyAttack);
                System.out.println("Enemy appears!");
                enemy.display();

                Scanner input = new Scanner(System.in);
                System.out.print("Fight the enemy? (yes/no): ");
                String response = input.nextLine();
                System.out.println();
                
                if (response.equalsIgnoreCase("yes")) {
                    int playerAttack = rand.nextInt(16) + 10; // Player attack 10–25
                    System.out.println("You attack the enemy for " + playerAttack + " damage!");
                    enemy.health -= playerAttack;
                    
                    if (enemy.health <= 0) {
                        System.out.println("You defeated the " + enemy.name + "!");
                    } else {
                        System.out.println("Enemy's remaining health: " + enemy.health);
                        System.out.println(enemy.name + " attacks you back for " + enemy.attackPower + " damage!");
                        player.health -= enemy.attackPower;
                        
                        if (player.health <= 0) {
                            System.out.println("You were defeated by the " + enemy.name + "...");
                            System.out.println("Game Over.");
                            System.exit(0); // End the game
                        } else {
                            System.out.println("Your remaining health: " + player.health);
                        }
                    }
                } else {
                    System.out.println("You fled from the battle.");
                }
            }
            case 2 -> {
                String dungeon = dungeons[rand.nextInt(dungeons.length)];
                System.out.println("You discover a dungeon: " + dungeon);
            }
            case 3 -> {
                String trap = traps[rand.nextInt(traps.length)];
                System.out.println("You triggered a trap: " + trap);
                player.setHealth(player.health - 20);
                System.out.println("Your health is now: " + player.health);
            }
            default -> System.out.println("Nothing happened this time.");
        }
        System.out.println();
    }
}

class Enemy {
    public String name;
    public int health;
    public int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void display() {
        System.out.println("\n>>> Enemy Encountered <<<");
        System.out.println("Name        : " + name);
        System.out.println("Health      : " + health);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("===========================");
    }

}

class Adventure {
    Player player;
    Backpack backpack;
    RandomAction action;

    // receive existing instances, don't create new ones
    public Adventure(Player player, Backpack backpack, RandomAction action) {
        this.player = player;
        this.backpack = backpack;
        this.action = action;
    }

    public void display() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("**** Adventure Path ****");
            System.out.println("1. Go Straight");
            System.out.println("2. Go Left");
            System.out.println("3. Go Right");
            System.out.println("4. Go Back (Exit Adventure)");
            System.out.print("Enter your direction: ");
            int choice = input.nextInt();
            input.nextLine();
            System.out.println();

            if (choice >= 1 && choice <= 3) {
                System.out.println("You move forward...");
                action.trigger(player, backpack);
            } else if (choice == 4) {
                System.out.println("Exiting adventure...");
                running = false;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}

class Option {
    public String option;
    Backpack backpack;
    Player player;
    RandomAction action;

    // Receive existing objects
    public Option(String option, Player player, Backpack backpack, RandomAction action) {
        this.option = option;
        this.player = player;
        this.backpack = backpack;
        this.action = action;
    }

    public void GameOpt() {
        Scanner input = new Scanner(System.in);
        boolean inGame = true;

        while (inGame) {
            System.out.println("**** Game Options ****");
            System.out.println("1. Player Stats");
            System.out.println("2. Open Backpack");
            System.out.println("3. Start Adventure");
            System.out.println("4. Use Potion");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            System.out.println();
            
            switch (choice) {
                case 1 -> {
                    player.display();
                }
                case 2 -> {
                    backpack.display();
                }
                case 3 -> {
                    Adventure adv = new Adventure(player, backpack, action);
                    adv.display();
                }
                case 4 -> {
                    if (backpack.potion > 0) {
                        System.out.println("Potion used successfully!");
                        player.setHealth(player.health + 20);
                        System.out.println("Your health is now: " + player.health);
                        backpack.setPotion(backpack.potion - 1);
                        System.out.println("Potions left: " + backpack.potion);
                        System.out.println();
                    } else {
                        System.out.println("No potions left!");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting game...");
                    inGame = false;
                    System.out.println();
                }
                default -> System.out.println("Invalid choice\n");
            }
        }
    }

    public void display() {
        System.out.println("Option: " + option);
    }
}

class Role {
    public String role;

    public Role() {
    }

    public void setRole(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your role: ");
        System.out.println("1. Magician ");
        System.out.println("2. Fighter ");
        System.out.println("3. Archer ");
        System.out.print("Enter your choice: ");
        int role = input.nextInt();

        if (role == 1) {
            this.role = "Magician";
            player.setHealth(100);
            player.setMana(100);
        } else if (role == 2) {
            this.role = "Fighter";
            player.setHealth(150);
            player.setMana(50);
        } else if (role == 3) {
            this.role = "Archer";
            player.setHealth(120);
            player.setMana(70);
        } else {
            System.out.println("Invalid choice");
        }
        player.setLevel(1);
    }

    public void display() {
        System.out.println("You have chosen the role: " + role);
    }

}

class Game {
    Login login;
    Signup signup;
    Role role;
    Player player;
    Backpack backpack;
    RandomAction action;
    Option option;

    public Game() {
        // create one instance per class here
        login = new Login("user123", "password123");
        signup = new Signup("", ""); // empty initially
        role = new Role();
        player = new Player();
        backpack = new Backpack();
        action = new RandomAction();

        // Pass these instances to Option
        option = new Option("Game Options", player, backpack, action);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();

        System.out.println("\n======= Welcome to the Game =======");
        System.out.println("1. Login ");
        System.out.println("2. Sign up ");
        System.out.println("3. Exit ");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine(); // consume newline

        if (choice == 1) {
            game.login.display();
            System.out.println("\n======= Login Successful =======");
            game.role.setRole(game.player);
            game.backpack.setBlood(80.0);
            game.backpack.setMana(50.0);
            game.backpack.setPotion(3);
            game.role.display();
            game.player.display();
            game.option.GameOpt();
        } else if (choice == 2) {
            System.out.print("Enter your username: ");
            String usn = input.nextLine();
            System.out.print("Enter your password: ");
            String pass = input.nextLine();
            
            game.signup.usn = usn;
            game.signup.pass = pass;
            
            System.out.println("Signup details:");
            game.signup.display();
            System.out.println("======= Signup Successful =======\n");
            game.role.setRole(game.player);
            game.backpack.setBlood(80.0);
            game.backpack.setMana(50.0);
            game.backpack.setPotion(3);
            game.role.display();
            game.player.display();
            System.out.println("Your adventure begins now...\n");
            game.option.GameOpt();
        } else if (choice == 3) {
            System.out.println("Exit");
        } else {
            System.out.println("Invalid choice");
        }

        input.close();
    }
}
