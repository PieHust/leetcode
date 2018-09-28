//Given the coordinates of four points in 2D space, return whether the four points could construct a square.
//
//The coordinate (x,y) of a point is represented by an integer array with two integers.
//
//Example:
//Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//Output: True
//Note:
//
//All the input integers are in the range [-10000, 10000].
//A valid square has four equal sides with positive length and four equal angles (90-degree angles).
//Input points have no order.
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] l1 = new int[2];
        int[] l2 = new int[2];
        l1[0] = p2[0] - p1[0];
        l1[1] = p2[1] - p1[1];
        l2[0] = p4[0] - p3[0];
        l2[1] = p4[1] - p3[1];
        if(isPara(l1, l2)) {
            int[] l3 = new int[2];
            l3[0] = p3[0] - p2[0];
            l3[1] = p3[1] - p2[1];
            
            int[] l4 = new int[2];
            l4[0] = p4[0] - p2[0];
            l4[1] = p4[1] - p2[1];
            return (isPerp(l1, l3) && isEqual(l1, l3)) ||
                (isPerp(l1, l4) && isEqual(l1, l4));
        } 
        return isPerp(l1,l2) && isEqual(l1,l2);
        
    }
    
    private boolean isEqual(int[] l1, int[] l2) {
        if (isZero(l1) || isZero(l2)) return false;
        return (l1[1]*l1[1] + l1[0]*l1[0]) == (l2[1]*l2[1] + l2[0]*l2[0]);
    }
    
    private boolean isPerp(int[] l1, int[] l2) {
        if (isZero(l1) || isZero(l2)) return false;
        return l1[0]*l2[0] + l1[1]*l2[1] == 0;
    }
    
    private boolean isPara(int[] l1, int[] l2) {
        if (isZero(l1) || isZero(l2)) return false;
        return l1[0]*l2[1] == l1[1]*l2[0];
    }
    
    private boolean isZero(int[] p) {
        return p[0] == 0 && p[1] == 0;
    }
    
}
