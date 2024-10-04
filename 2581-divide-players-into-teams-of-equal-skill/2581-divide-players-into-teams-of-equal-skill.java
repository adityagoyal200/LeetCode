
class Solution {
    public long dividePlayers(int[] skill) {
        if (skill == null || skill.length == 0 || skill.length % 2 != 0) {
            return -1;
        }

        Arrays.sort(skill);
        int len = skill.length;

        long totalSkill = skill[0] + skill[len - 1];
        long result = 0;

        for (int i = 0; i < len / 2; i++) {
            int j = len - 1 - i;
            result = (skill[i] + skill[j] != totalSkill) ? -1 : result + (long) skill[i] * skill[j];
            if (result == -1) {
                return -1;
            }
        }

        return result;
    }
}
