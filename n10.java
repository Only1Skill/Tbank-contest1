package алгосы;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10{

    private static double calculateSum(int numRows, int numCols, int cutLength, boolean isVertical) {
        if (isVertical) {
            double sumOfFirstCut = ((1.0 + cutLength) / 2.0) * cutLength;
            double startOfLastCut = numCols * (numRows - 1) + 1;
            double endOfLastCut = numCols * (numRows - 1) + cutLength;
            double sumOfLastCut = ((startOfLastCut + endOfLastCut) / 2.0) * cutLength;

            return (sumOfFirstCut + sumOfLastCut) * numRows / 2.0;
        } else {
            return ((1.0 + numCols * cutLength) / 2.0) * numCols * cutLength;
        }
    }

    private static OptimalCut findBestCut(int numRows, int numCols) {
        double targetSum = ((1.0 + numRows * numCols) / 4.0) * numRows * numCols;
        double minDifference = Double.MAX_VALUE;
        OptimalCut bestCut = new OptimalCut('V', 0);

        bestCut = performBinarySearch(numRows, numCols, targetSum, true, minDifference, bestCut);
        minDifference = bestCut.getDifference();

        bestCut = performBinarySearch(numRows, numCols, targetSum, false, minDifference, bestCut);

        return bestCut;
    }

    private static OptimalCut performBinarySearch(int numRows, int numCols, double targetSum, boolean isVertical, double minDifference, OptimalCut currentBest) {
        int low = 0;
        int high = numRows + numCols + 1;
        OptimalCut bestCut = currentBest;
        double bestDiff = minDifference;

        while (low <= high) {
            int mid = (low + high) / 2;
            double currentSum = calculateSum(numRows, numCols, mid, isVertical);
            double difference = Math.abs(currentSum - targetSum);

            if (difference < bestDiff) {
                bestDiff = difference;
                bestCut = new OptimalCut((isVertical ? 'V' : 'H'), mid, difference);
            }

            if (currentSum < targetSum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bestCut;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numTestCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numTestCases; i++) {
            String[] dimensions = reader.readLine().split(" ");
            int numRows = Integer.parseInt(dimensions[0]);
            int numCols = Integer.parseInt(dimensions[1]);

            OptimalCut result = findBestCut(numRows, numCols);
            writer.write(result.getType() + " " + (result.getPosition() + 1) + "\n");
        }

        writer.close();
        reader.close();
    }

    static class OptimalCut {
        private char type;
        private int position;
        private double difference;

        public OptimalCut(char type, int position) {
            this.type = type;
            this.position = position;
            this.difference = Double.MAX_VALUE;
        }

        public OptimalCut(char type, int position, double difference) {
            this.type = type;
            this.position = position;
            this.difference = difference;
        }

        public char getType() {
            return type;
        }

        public int getPosition() {
            return position;
        }

        public double getDifference() {
            return difference;
        }
    }
}
