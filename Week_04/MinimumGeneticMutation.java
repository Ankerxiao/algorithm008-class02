class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null) return -1;
        if (start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        for (String b: bank) bankSet.add(b);
        if (!bankSet.contains(end)) return -1;
        Map<Character, String> change = new HashMap<>();
        change.put('A', "CGT");
        change.put('C', "AGT");
        change.put('G', "ACT");
        change.put('T', "ACG");
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;
                for (int j = 0; j < curr.length(); j++) {
                    char[] tempCharArr = curr.toCharArray();
                    for (int k = 0; k < 3; k++) {
                        tempCharArr[j] = change.get(curr.charAt(j)).charAt(k);
                        String newCurr = new String(tempCharArr);
                        if (bankSet.contains(newCurr)) {
                            queue.offer(newCurr);
                            bankSet.remove(newCurr);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}