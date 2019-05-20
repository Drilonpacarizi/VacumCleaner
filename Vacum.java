import java.util.ArrayList;
import java.util.Arrays;

public class Vacum {

    public int leviz() {
        return (int) (Math.random() * 3.9);
    }

    public  int leviz(int l) {
        int answer = (int) (Math.random() * 3.9);
        while (answer == l) {
            answer = (int) (Math.random() * 3.9);
        }

        return answer;
    }

    public String[][] harta(String[][] h,String [][]harta, int i, int j, int d) {
        String[][] rez = harta;
        if(!kontrolloMurin(i,j,d)){
            return rez;
        }
        if (d == 0) {
            rez[i - 1][j] = h[i - 1][j];
            if (rez[i - 1][j] == " M ") {
                rez[i - 1][j] = "[ ]";
            }
        } else {
            if (d == 1) {
                rez[i + 1][j] = h[i + 1][j];
                if (rez[i + 1][j] == " M ") {
                    rez[i + 1][j] = "[ ]";
                }
            } else {
                if (d == 2 ) {
                    rez[i][j + 1] = h[i][j + 1];
                    if (rez[i][j + 1] == " M ") {
                        rez[i][j + 1] = "[ ]";
                    }
                } else {
                    if (d == 3) {
                        rez[i][j - 1] = h[i][j - 1];
                        if (rez[i][j - 1] == " M ") {
                            rez[i][j - 1] = "[ ]";
                        }
                    }
                }
            }
        }
        return rez;
    }

    public boolean kontrolloMurin(int i, int j, int d) {
        boolean answer = false;
        switch (d) {
            case 0: {
                i--;
                break;
            }
            case 1: {
                i++;
                break;
            }
            case 2: {
                j++;
                break;
            }
            case 3: {
                j--;
                break;
            }
            default:
                break;
        }
        if (i <= 9 && i >= 0) {
            if (j <= 9 && j >= 0) {
                answer = true;
            }
        }
        return answer;
    }

    public boolean kontrolloPengesen(String[][] h, int i, int j, int d) {
        boolean answer = false;
        boolean p = true;
        switch (d) {
            case 0: {
                if (!kontrolloMurin(i, j, 0)) {
                    p = false;
                    break;
                }
                i--;

                break;
            }
            case 1: {
                if (!kontrolloMurin(i, j, 1)) {
                    p = false;
                    break;
                }
                i++;
                break;
            }
            case 2: {
                if (!kontrolloMurin(i, j, 2)) {
                    p = false;
                    break;
                }
                j++;
                break;
            }
            case 3: {
                if (!kontrolloMurin(i, j, 3)) {
                    p = false;
                    break;
                }
                j--;
                break;
            }
            default:
                break;
        }
        if (h[i][j] != " P " && h[i][j] != null) {
            answer = true;
        }
        return answer;
    }

    public ArrayList<Integer>[] mbaroLojen(String[][] h, int x, int y) {
        ArrayList<Integer> levizjet = new ArrayList<>();
        Fillimi:
        for (int i = 0; i < 10000; i++) {
            int d = leviz();
            int c = 0;
            while (!(kontrolloPengesen(h, x, y, d) && kontrolloMurin(x, y, d))) {
                //while(!kontrolloMurin(x,y,d)){
                d = leviz(d);
                c++;
                if (c > 100)
                    break Fillimi;
            }
            c = 0;
            switch (d) {
                case 0: {
                    x--;
                    break;
                }
                case 1: {
                    x++;
                    break;
                }
                case 2: {
                    y++;
                    break;
                }
                case 3: {
                    y--;
                    break;
                }
                default:
                    break;
            }
            levizjet.add(d);
            if (x == 0 && y == 0) {
                //System.out.println(x + " " + y + " " + i);
                break;
            }
        }
        ArrayList<Integer> rez = new ArrayList<>();
        rez.add(x);
        rez.add(y);
        return new ArrayList[]{rez, levizjet};
    }

    public ArrayList<Integer>[] min(String[][] harta,int x,int y) {

        Vacum v = new Vacum();
        int numri = 10000;
        String[][] matrica = harta;
        ArrayList<Integer>[][] vargu = new ArrayList[numri][2];
        for (int i = 0; i < numri; i++) {
            vargu[i] = v.mbaroLojen(matrica, x, y);

        }
        int min = 10000;
        int index = 0;
        for (int i = 0; i < numri; i++) {
            if (vargu[i][0].get(0).intValue() == 0 && vargu[i][0].get(1).intValue() == 0)
                if (min > vargu[i][1].size()) {
                    min = vargu[i][1].size();
                    index = i;
                }
        }
        /*if (min == 10000) {
            System.out.println("Pas 10000 hapave ju nuk keni gjetur zgjidhjen");
        } else {
            System.out.println("Indexi i rastit me te mire eshte: " + index + "\n" + "Minimumi i levizjeve eshte: " + min);
        }*/
        return vargu[index];
    }

    public void fshijDhomen(String[][] h) {
        int count = 0;
        int denimi = -1000;
        int trosha = 0;
        int x = 0, y = 0;
        String[][] harta = new String[10][10];
        Fillimi:
        for (int i = 0; (i < 2000)&&(count<2000)&&(trosha<33); i++) {
            int d = leviz();
            int c = 0;
            while (!(kontrolloPengesen(h, x, y, d) && kontrolloMurin(x, y, d))) {
                harta = harta(h,harta, x, y, d);
                d = leviz(d);
                count++;
                denimi--;
                c++;
                if (c > 100) {
                    break Fillimi;
                }
            }
            harta = harta(h,harta, x, y, d);
            /*c = 0;*/
            switch (d) {
                case 0: {
                    x--;
                    break;
                }
                case 1: {
                    x++;
                    break;
                }
                case 2: {
                    y++;
                    break;
                }
                case 3: {
                    y--;
                    break;
                }
                default:
                    break;
            }
            count++;
            if (h[x][y] == " M ") {
                h[x][y] = "[ ]";
                trosha++;
                denimi+=10;
            }
            else{
                denimi-=1;
            }
           /* System.out.println(d);*/

        }
        System.out.println("Dhoma e paster eshte: \n");
        for(String [] k : h) {
            for (String k1 : k) {
                System.out.print(k1 + " ");
            }
            System.out.println();
        }
        System.out.println("Pozita ku ka perfundu fshirjen e dhomes: "+ x+" "+y);
        System.out.println();
        System.out.println("Dhoma ne memorien e fshises");
        for(String [] k : harta) {
            for (String k1 : k) {
                System.out.print(k1 + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
        ArrayList<Integer>[] v =min(harta,x,y);
        System.out.println("Levizjet per tu kthyer mrapa: "+v[1].toString());
        System.out.println("Numri i hapave per ta fshire dhomen eshte  "+count+ "\nNumri i hapave per tu kthyer mrapa eshte: "+ v[1].size());
        if(v[0].size()==10000){
            System.out.println("Maximumi eshte 10000");
        }
        else if(v[0].size()<10000)
         denimi = denimi+1000;
         
        System.out.println("Denimi eshte : "+denimi);
 
    }



    public static void main(String[] args) {
        World c = new World();
        Vacum v = new Vacum();
        String[][] matrica = c.ktheMatricen();
        System.out.println("Dhoma per tu fshire eshte");
        for (int i = 0; i < matrica.length; i++) {
            for (int j = 0; j < matrica[0].length; j++) {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(Arrays.toString(v.min()));
        v.fshijDhomen(matrica);
    }

}
