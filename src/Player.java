import java.util.Random;

class Player {

    private int choice;
    private int role;

    Player(int choice, int role){
        if(role == -1){
            this.choice = 0;
            this.role = role;
        } else{
            this.choice = choice;
            this.role = role;
        }
    }

    int getRole(){
        return role;
    }
    int getChoice(){
        return choice;
    }

    int assignRole(){
        Random random = new Random();
        if(this.choice == 1){
            return 5*random.nextInt(2) + this.role;
        } else if(this.choice == 2){
            int k = random.nextInt(10);
            if(k%5 == this.role){ return assignRole(); } else { return k; }
        } else { return random.nextInt(10); }
    }
}
