public class assignment3 {

    // Computes the total water trapped after rainfall on the given elevation map.
    // For each index: water = min(maxWallLeft, maxWallRight) - height[i]
    public static int trappedRainwater(int[] height) 
    {
        int n = height.length; // Number of elevation points
        if (n == 0) 
        {
            return 0; // No elevation means no trapped water
        }

        // leftMax[i] = tallest wall at or to the left of index i
        int[] leftMax = new int[n];
        leftMax[0] = height[0]; // First element's left max is itself
        for (int i = 1; i < n; i++) 
        {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]); // Compare current height with max to the left
        }

        // rightMax[i] = tallest wall at or to the right of index i
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1]; // Last element's right max is itself
        for (int i = n - 2; i >= 0; i--) 
        {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]); // Compare current height with max to the right
        }

        // Sum up water held above each cell
        int totalWater = 0;
        for (int i = 0; i < n; i++)
        {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i]; // Water above current cell is min of left and right max minus current height
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] elevationMap = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};

        int result = trappedRainwater(elevationMap);
        System.out.println("Total trapped rainwater: " + result + " units");
        // Expected: 26 units
    }
}
