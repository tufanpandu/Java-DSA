import java.util.*;

public class GreedyAlgo3 {

    // ////// Chocola Problem
    public static void main(String arga[]) {
        int n = 4;
        int m = 6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = { 4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0;
        int v = 0 ;
        int hp = 1;
        int vp = 1;
        int cost = 0;

        while (v < costVer.length && h < costHor.length) {
            if (costVer[v] <= costHor[h]) { // Horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;

            }
        }
        
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        System.out.println("Min cost " + cost);
    }
    
}
