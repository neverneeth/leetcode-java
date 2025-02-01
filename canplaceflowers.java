/*
SCROLL DOWN FOR CODE

Problem description
605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.


Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
*/

/*Solution Description
Use a greedy algorithm to check every valid position of placing a flower. If valid, change the value of the position to one and increment the counter.
If counter equals or exceeds the required n at any point return true. Else returns false.
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean l = (i == 0 || flowerbed[i - 1] == 0);
                boolean r = (i == len - 1 || flowerbed[i + 1] == 0);
                
                if (l && r) {
                    flowerbed[i] = 1; 
                    count++;
                    
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        
        return count >= n;
    }
}

