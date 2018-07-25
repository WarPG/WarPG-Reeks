import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {

    private static Character guy = new Character();
    private static String log = "";

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        run();
    }


    public static void run(){
        log = "Hello Adventurer, this is the beginning of the game... Sorry its not complete :(";
        System.out.println(log);

        Scanner s = new Scanner(System.in);
        int level = 1;
        int guy_x = 25, guy_y = 25;
        Map map = new Map();
        int go = -1;
        for(;;go = s.nextInt()){
            if (go == 0) //WEST
                guy_y++;
            else if (go == 1) //WEST
                guy_x--;
            else if (go == 2) //WEST
                guy_y--;
            else if (go == 3) //WEST
                guy_x++;
            else if (go == 5)
                break;

            if (map.get(guy_x, guy_y) == 0){
                log = "meh";
                System.out.println(log);
            }else if (map.get(guy_x, guy_y) == 1){
                log = "enemy";
                System.out.println(log);
                Mob mob = new Mob(level, guy_x, guy_y);
                combat(mob);
                map.combatOver(guy_x, guy_y);
            }else if (map.get(guy_x, guy_y) == 10){
                log = "item";
                System.out.println(log);
                Item item = new Item();
                grab(item);
                map.itemGone(guy_x,guy_y);
            }else if (map.get(guy_x, guy_y) == -1){
                log = "next level";
                System.out.println(log);
                level++;
                guy_x = 25;
                guy_y = 25;
                map = new Map();
            }else if (map.get(guy_x, guy_y) < -1){
                log = "what";
                System.exit(0);
            }

        }

    }

    private static int combat(Mob mob) {
        Random r = new Random();
        int potion = 0;
        boolean turn = true;
        int pos = r.nextInt(9) + 1;
        if (pos > 5) {
            log = "You see a monster. Attack him!";
            System.out.println(log);
        } else {
            log = "HE IS SO CLOSE AAGGHHH!";
            System.out.println(log);
            turn = false;
        }
        while (guy.getHealth() > 0 && mob.getHealth() > 0) {
            if (potion > 0) {  // JButton potion is clicked
                if (turn){
                    //USE POTION
                    turn = false;
                    potion = 0;
                    log = "You used potion of " + potion;
                    System.out.println(log);
                    continue;
                }
            }
            if (turn) {
                int str = guy.getStrength();
                int roll = r.nextInt(100) + 1;

                if (roll > 80 - (guy.getAttack() - mob.getDefence())) {
                    if (roll >= 98) {
                        log = "You hit mob for " + guy.getStrength()*2 + " damage";
                        System.out.println(log);
                        mob.setHealth(mob.getHealth() - 2 * guy.getStrength());
                    } else {
                        log = "You hit mob for " + guy.getStrength() + " damage";
                        System.out.println(log);
                        mob.setHealth(mob.getHealth() - guy.getStrength());
                    }
                }
                log = "You tried to hit mob but failed";
                System.out.println(log);
                turn = false;
            } else {
                int roll = r.nextInt(100) + 1;

                if (roll > 80 - (mob.getAttack() - guy.getDefense())) {
                    if (roll == 100) {
                        log = "Enemy hit you for " + guy.getStrength()*2 + " damage";
                        System.out.println(log);
                        guy.setHealth(guy.getHealth() - 2 * mob.getStrength());
                    } else {
                        log = "Enemy hit you for " + guy.getStrength() + " damage";
                        System.out.println(log);
                        guy.setHealth(guy.getHealth() - mob.getStrength());
                    }
                }
                log = "Enemy tried to hit you but failed";
                System.out.println(log);
                turn = true;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (guy.getHealth() <= 0) {
            log = "Ur dead bro";
            System.out.println(log);
        }else{
            log = "You killed it boi, here's some exp : " + mob.getStrength()/10;
            System.out.println(log);
        }

        return 0;
    }

    private static void grab(Item item){
        log = "You found an item. Its " + item;
        System.out.println(log);
        log = "Do you wanna have it?" ;
        System.out.println(log);

        // If yes send it to bag
        if (item.isArmor())
            guy.wearArmor(item);
        if (item.isWeapon())
            guy.wearWeapon(item);
        if (item.isAccessory())
            guy.wearAccessory(item);
        // if no get money fuck bitches
        guy.setGold(guy.getGold() + item.getPrice()*guy.getCharisma()/100);

    }
    private static void levelup(){
        //JButton push gets us higher stats
    }
}
