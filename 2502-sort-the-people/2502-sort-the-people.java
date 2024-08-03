class Solution {
    class People {
        String name;
        int height;

        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        if (names.length == 0 || heights.length == 0) {
            return new String[]{};
        }
        
        List<People> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new People(names[i], heights[i]));
        }

        Collections.sort(list, (a, b) -> b.height - a.height);

        String[] result = new String[names.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).name;
        }

        return result;
    }
}