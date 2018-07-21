
import java.util.Random;

public class Map {

    private int map[][] = new int[52][52];
    final int MOB_COUNT = 40;
    final int ITEM_COUNT = 20;


    Random rand = new Random();

    public void init(){

        int  pass = rand.nextInt(1);

        if (pass == 0){
            for (int i = 0; i < 52; i++){
                map[i][0] = -1;
                map[i][52] = -1;
                map[0][i] = -2;
                map[52][i] = -2;
            }
        }else{
            for (int i = 0; i < 52; i++){
                map[0][i] = -1;
                map[52][i] = -1;
                map[i][0] = -2;
                map[i][52] = -2;
            }
        }

        generate_mob(-1);
        generate_item(-1);

    }
    private void generate_mob(int mob_count){
        if (mob_count == -1)
            mob_count = MOB_COUNT;
        mob_count /= 4;

        for(int j = 0; j < 4; j++){
            for (int i = 0; i < mob_count; i++) {
                int x = rand.nextInt(8);
                int y = rand.nextInt(8);
                x = x * 3 + 1;
                y = y * 3 + 1;
                if (x == 25)
                    x = 24;
                if (y == 25)
                    y = 24;
                if (x == 1)
                    x = 2;
                if (y == 1)
                    y = 2;

                if (j == 1)
                    x += 25;
                else if (j == 2)
                    y += 25;
                else if (j == 3) {
                    x += 25;
                    y += 25;
                }

                if (map[x][y] == 1){
                    i--;
                    continue;
                }

                map[x - 1][y - 1] = 1;
                map[x - 1][y] = 1;
                map[x][y - 1] = 1;
                map[x][y] = 1;
                map[x + 1][y] = 1;
                map[x + 1][y - 1] = 1;
                map[x + 1][y + 1] = 1;
                map[x][y + 1] = 1;
                map[x - 1][y + 1] = 1;
            }
        }
    }
    private void generate_item(int item_count){
        if (item_count == -1)
            item_count = ITEM_COUNT;
        item_count /= 4;

        for(int j = 0; j < 4; j++){
            for (int i = 0; i < item_count; i++) {
                int x = rand.nextInt(25) + 1;
                int y = rand.nextInt(25) + 1;

                if (j == 1)
                    x += 25;
                else if (j == 2)
                    y += 25;
                else if (j == 3) {
                    x += 25;
                    y += 25;
                }

                if(map[x][y] == 1){
                    i--;
                    continue;
                }

                map[x][y] = 10;
            }

        }
    }


}
