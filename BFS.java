public class BFS {



    static ArrayList<Integer> bfsearch(ArrayList<ArrayList<Integer>> adjec, int t)
    
     {
        LinkedList<Integer> y = new LinkedList<Integer>();
        ArrayList<Integer> store = new ArrayList<Integer>(adjec.size());
       
       
        for (int i = 0; i < adjec.size(); i++) 
        {
            store.add(0);
        }
        
        y.addFirst(t);

        while (y.size() > 0)
        {
            int current = y.pollLast();
            ArrayList<Integer> tmp = adjec.get(current);
            for (int i = 0; i < tmp.size(); i++)
             {
                int v = tmp.get(i);
                if (store.get(v) == 0) 
                {
                    y.addFirst(v);
                    store.set(v, store.get(current) + 6);
                }
            }
        }

        return store;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        for(int a = 0; a < y; a++){

            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> adjec = new ArrayList<ArrayList<Integer>>(n);
            for (int i = 0; i < n; i++) {
                adjec.add(new ArrayList<Integer>());
            }

            int m = in.nextInt();
            for(int b = 0; b < m; b++){
                int i = in.nextInt() - 1;
                int j = in.nextInt() - 1;
                ArrayList<Integer> tmp = adjec.get(i);
                tmp.add(j);
                adjec.set(i, tmp);


                tmp = adjec.get(j);
                tmp.add(i);
                adjec.set(j, tmp);
            }

            int t = in.nextInt() - 1;

            ArrayList<Integer> result = Solution.bfsearch(adjec, t);

            for (int i = 0; i < n; i++) {
                if (i != t) {
                    if (result.get(i) == 0) {
                        System.out.print("-1 ");
                    } else 
                        System.out.print(result.get(i) + " ");
                    
                }
            }
            System.out.print("\n");
        }
        in.close();
    }
}