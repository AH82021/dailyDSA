package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Amazon Warehouse delivers different items in different trucks having varied capacities.
Given an array, trucks, of n integers that represents the capacities of different trucks, and an array, items, of m integers that represent the weights of different items,
 for each item, find the index of the smallest truck which has a capacity greater than the item's weight.
 If there are multiple such trucks, choose the one with the minimum index.
 If there is no truck that can carry the item, report -1 as the answer for the corresponding item.
 Note: Assume that the trucks are indexed starting from 0 Also, multiple items can be mapped to the same truck.
  Each item is mapped independently, hence the trucks do not lose any capacity when a particular item is mapped to it.Example

Suppose, trucks =[4,5,7,2] and items=[1,2,5].

They can be mapped as follows:Function Description
The smallest truck that can carry the third weight, 5, is truck 2 with a capacity of 7.
Similar logic is applied to the other elements and the answer is [3, 0, 2].
Complete the function get TrucksFortems in the editor below.


getTrucksFortems has the following parameters: int trucks[n]: the capacities of the trucks int items[q]: the weights of the items

 */
public class Solution {
  public static List<Integer> getTrucksForItems(List<Integer> trucks,List<Integer> items){
      List<Integer> result = new ArrayList<>();
      for (Integer item : items) {
          int minIndex = -1;
          int minCapacity = Integer.MAX_VALUE;
          for (int i = 0; i < trucks.size(); i++) {
              int truckCapacity = trucks.get(i);
              if(truckCapacity > item && truckCapacity <minCapacity){
                  minIndex =i;
                  minCapacity = truckCapacity;
              }
          }
          result.add(minIndex);
      }
      return result;
  }

    public static void main(String[] args) {
        List<Integer> trucks = Arrays.asList(4,5,7,2);
        List<Integer> items = Arrays.asList(1,2,5);
        System.out.println(getTrucksFortems(trucks, items));
    }


}
