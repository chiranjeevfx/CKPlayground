package array;

public class BITTest {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BIT bit = new BIT(a);
        for (int i = 0; i < a.length; i++) {
            //bit.update(i+1,a[i]);
            int sum = bit.query(i + 1);
            System.out.println("i: " + i + ", sum: " + sum);
        }
    }
}

class BIT {
    int arr[];
    int n;

    BIT(int a[]) {
        n = a.length;
        arr = new int[n + 1];
        //arr = Arrays.copyOf(a, n);
        for (int i = 0; i < n; i++) {
            //arr[i+1] = a[i];
        }//print();

        for (int i = 0; i < n; i++) {
            update(i + 1, a[i]);
        }
        print();
    }

    public void createBIT(int a[]) {
        for (int i = 0; i < n; i++) {
            update(i + 1, a[i]);
        }
    }

    public void print() {
        for (int i = 0; i <= n; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public int query(int idx) {
        int ans = 0;
        while (idx > 0) {
            //System.out.println(idx);
            ans += arr[idx];
            idx -= lsb(idx);
        }
        return ans;
    }

    public void update(int idx, int val) {
        for (int i = idx; i <= n; i += lsb(i)) {
            //System.out.println(i);
            arr[i] += val;
        }
    }

    public int lsb(int x) {
        return x & (-x);
    }
}