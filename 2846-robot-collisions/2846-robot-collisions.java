class Solution {
    class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }

        robots.sort((a,b)->a.position-b.position);

        Stack<Robot> stack = new Stack<>();

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
                continue;
            }

            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek().health <= robot.health 
                    && stack.peek().direction == 'R') {
                if (stack.peek().health == robot.health) {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                robot.health--;
                stack.pop();
            }

            if (!destroyed && !stack.isEmpty() 
            && stack.peek().direction == 'R' && stack.peek().health > robot.health) {
                stack.peek().health--;
                destroyed = true;
            }

            if (!destroyed) {
                stack.push(robot);
            }
        }

        stack.sort((a,b)-> a.index - b.index);

        List<Integer> result = new ArrayList<>();
        for (Robot robot : stack) {
            result.add(robot.health);
        }

        return result;
    }
}


