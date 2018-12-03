import java.util.Objects;

class Randomizer {

    private Player[] pl;
    Randomizer(Player[] pl){
        this.pl=pl;
    }



    String randomize(){
        boolean[] isTaken = new boolean[pl.length];
        char[] returnArray = new char[pl.length];
        for (int i=0; i<pl.length; i++){
            isTaken[i] = false;
        }
        int max = 0;
        int counter = 0;

        int i=0;
        while(i<pl.length) {
            if (pl[i].getChoice() == 1) {
                int k = pl[i].assignRole();
                if (!isTaken[k]) {
                    isTaken[k] = true;
                    returnArray[i]=Integer.toString(k).charAt(0);
                    counter++;
                    if (counter == 10) {
                        return new String(returnArray);
                    }
                    i++;
                } else {
                    max++;
                    if (max == 400) {
                        return "error";
                    }
                }
            } else {
                i++;
            }
        }
        i=0;
        while(i<pl.length){
            if (pl[i].getChoice() == 2) {
                int k = pl[i].assignRole();
                if (!isTaken[k]) {
                    isTaken[k] = true;
                    returnArray[i]=Integer.toString(k).charAt(0);
                    counter++;
                    if (counter == 10) {
                        return new String(returnArray);
                    }
                    i++;
                } else {
                    max++;
                    if (max == 400) {
                        return "error";
                    }
                }
            } else {
                i++;
            }
        }
        i=0;
        while(i<pl.length){
            if (pl[i].getChoice() == 0) {
                int k = pl[i].assignRole();
                if (!isTaken[k]) {
                    isTaken[k] = true;
                    returnArray[i]=Integer.toString(k).charAt(0);
                    counter++;
                    if (counter == 10) {
                        return new String(returnArray);
                    }
                    i++;
                } else {
                    max++;
                    if (max == 400) {
                        return "error";
                    }
                }
            } else {
                i++;
            }
        }
        return "error";
    }
}
