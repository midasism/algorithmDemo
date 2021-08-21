package unionFind;

/**
 * 按秩合并
 */
public class RankUnionFind {
    int[] root;
    int[] rank;
    public RankUnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找x的根节点
     * 根节点特点：父节点等于本身 自己就是老大
     * @param x
     * @return
     */
    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    /**
     * 合并两个节点
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            root[rootY] = rootX;
        }
    }

    /**
     * 判断两个节点是否在同一集合中
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        RankUnionFind uf = new RankUnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        System.out.println(uf.connected(3, 7)); // false
    }
}
