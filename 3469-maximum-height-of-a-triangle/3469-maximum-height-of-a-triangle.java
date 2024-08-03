class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        if (red == 0 || blue == 0) {
            return 1;
        }
        
        int height = Math.max(possible(red, blue), possible(blue, red));
        return height;
    }

    private int possible(int color1, int color2) {
        int hei = 0;
        boolean useColor1 = true;
        
        while (true) {
            if (useColor1) {
                if (color1 >= hei + 1) {
                    color1 -= (hei + 1);
                } else {
                    break;
                }
            } else {
                if (color2 >= hei + 1) {
                    color2 -= (hei + 1);
                } else {
                    break;
                }
            }
            hei++;
            useColor1 = !useColor1;
        }
        
        return hei;
    }
}
