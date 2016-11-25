import java.util.*;

/**
 * Created by Nikhil on 11/23/16.
 */

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical
 * order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical
 * order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        new ReconstructItinerary().findItinerary(tickets);
    }

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> hmap = new HashMap<>();
        List<String> route = new LinkedList<String>();
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if (hmap.containsKey(from)) {
                hmap.get(from).add(to);
            } else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                hmap.put(from, pq);
            }
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (hmap.containsKey(stack.peek()) && hmap.get(stack.peek()).size() != 0) {
                stack.push(hmap.get(stack.peek()).poll());
            }
            route.add(0, stack.pop());
        }
        for (String s : route) {
            System.out.println(s);
        }
        return route;
    }
}
