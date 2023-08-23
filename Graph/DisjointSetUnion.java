import java.util.*;

///====================  Disjoint Set Union =========================================
public class DisjointSetUnion {
    // initialze the no.of groups
    static int n = 7;
    // Create parent array and rank array which is static type.
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    // By Default every rank index value is "0" don't need to declear.
    // create a function for intialize -> Every set/ group had own parent/leader.
    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /// Find() function
    public static int find(int x) {
        /// If x value is equal to parent array index value.
        if (x == parent[x]) {
            return x;
        }
        /// call recursively the find function
        // return find(parent[x]); ======= We have batter option for optimize this line
        /*
         * --If we return above method then we search for parent for every time when
         * mehod
         * is called.
         * --If we update the parent[x] for one time then we don't need to call every
         * time recursively.
         */

        // Optimize method
        return parent[x] = find(parent[x]);
    }

    // create Union function
    public static void union(int a, int b) {
        // find the parent of A and B and store an variable.
        int parA = find(a);
        int parB = find(b);

        // parent A & B rank Equal case
        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++; // update the rank or parent A
        } else if (rank[parA] < rank[parB]) { // Parent A rank is Lessthan Parent B rank.
            parent[parA] = parB;
        } else { // if Rank B is grater than rank A
            parent[parB] = parA;
        }

    }

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
