/*You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 */

class Solution {
    // map: keys are starting airports and values are lists of destination airports
    HashMap<String, LinkedList<String>> map;
    // list of airports visited in order
    LinkedList<String> result;
    // given a list of tickets, returns the itinerary in the form of a list of airports visited
    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        map = new HashMap<>();
         // for each ticket, add the destination to the list of destinations for the ticket's starting airport
        for (List<String> t : tickets) {
            String src = t.get(0);
            map.putIfAbsent(src, new LinkedList<>());
            map.get(src).add(t.get(1));
        }
        // sort the lists of destinations so they are in lexicographic order
        map.forEach((key, value) -> Collections.sort(value));
        // start at JFK and find the itinerary using depth-first search
        findItenaryDFS("JFK");
        return result;
    }
    // finds the itinerary starting at the given airport using depth-first search
    public void findItenaryDFS(String start){
        if (map.containsKey(start)){
            LinkedList<String> destination = map.get(start);
            // for each destination, find the itinerary starting at that destination
            while (!destination.isEmpty()) {
                String des = destination.pollFirst();
                findItenaryDFS(des);
            }
        }
    // once there are no more destinations, add the current airport to the front of the result list
        result.offerFirst(start);
    }
}
