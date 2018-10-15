//In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
//
//When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)
//
//Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
//
// 
//
//Example 1:
//
//Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//Output: [null,0,9,4,2,null,5]
//Explanation:
//ExamRoom(10) -> null
//seat() -> 0, no one is in the room, then the student sits at seat number 0.
//seat() -> 9, the student sits at the last seat number 9.
//seat() -> 4, the student sits at the last seat number 4.
//seat() -> 2, the student sits at the last seat number 2.
//leave(4) -> null
//seat() -> 5, the student sits at the last seat number 5.
//​​​​​​​
//
//Note:
//
//1 <= N <= 10^9
//ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
//Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
class ExamRoom {

    int N;
    ArrayList<Integer> L = new ArrayList<>();
    public ExamRoom(int n) {
        N = n;
    }

    public int seat() {
        if (L.size() == 0) {
            L.add(0);
            return 0;
        }
        int d = Math.max(L.get(0), N - 1 - L.get(L.size() - 1));
        for (int i = 0; i < L.size() - 1; ++i) d = Math.max(d, (L.get(i + 1) - L.get(i)) / 2);
        if (L.get(0) == d) {
            L.add(0, 0);
            return 0;
        }
        for (int i = 0; i < L.size() - 1; ++i)
            if ((L.get(i + 1) - L.get(i)) / 2 == d) {
                L.add(i + 1, (L.get(i + 1) + L.get(i)) / 2);
                return L.get(i + 1);
            }
        L.add(N - 1);
        return N - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < L.size(); ++i) if (L.get(i) == p) L.remove(i);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
