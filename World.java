public class World {

    public   String[][] setPengesa(String [][] v){

        int a=(v.length*v[0].length)/3;
        for (int j = 0; j <a ; j++) {
            int hori = (int)(Math.random()*10);
            int vert=(int)(Math.random()*10);
            if(v[hori][vert]==" M " ||v[hori][vert]==" P "|| (hori==0 &&vert==0))
                a++;
            else
                v[hori][vert]=" P ";
        }
        return  v;
    }
    public   String[][] setMbeturina(String [][] v){

        int a=(v.length*v[0].length)/3;
        for (int j = 0; j <a ; j++) {
            int hori = (int)(Math.random()*10);
            int vert=(int)(Math.random()*10);
            if(v[hori][vert]==" P " ||v[hori][vert]==" M " || (hori==0 &&vert==0)){
                a++;
            }
            else
            {
                v[hori][vert]=" M ";
            }

        }
        return  v;
    }

    public String[][]  ktheMatricen() {

        String[][] vargu=new String[10][10];
        setPengesa(vargu);
        setMbeturina(vargu);

        int p=0;
        int m=0;
        int n=0;
        for (int i = 0; i <vargu.length ; i++) {
            for (int j = 0; j <vargu[i].length ; j++) {
                if (vargu[i][j] ==" P ") {
                    p++;
                }else if(vargu[i][j] ==" M "){
                    m++;
                }else {
                    vargu[i][j] = "[ ]";
                    n++;
                }
            }
        }
        System.out.println( "pengesa ="+p+" mbeturina= "+m+" ,null= "+ n);
        return vargu;
    }


}