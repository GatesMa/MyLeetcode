class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 保存入度为0的点
        Queue<Integer> queue = new LinkedList<>();
        // 领接表
        List<List<Integer>> table = new ArrayList<>();
        // 保存每个节点的入度
        int[] in = new int[numCourses];
        // 初始化领结表
        for (int i = 0;i < numCourses;i++) {
            table.add(new ArrayList<>());
        }
        // 初始化图
        for (int[] item : prerequisites) {
            table.get(item[1]).add(item[0]);
            in[item[0]]++;
        }
        // 将入度为0的点入队
        for (int i = 0;i < numCourses;i++) {
            if (in[i] == 0) queue.add(i);
        }
        // BFS操作
        while (!queue.isEmpty()) {
            int node = queue.poll();
            numCourses--;
            for (int cur : table.get(node)) {
                in[cur]--;
                if (in[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }
}
