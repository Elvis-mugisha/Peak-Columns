import java.util.Scanner;

public class Checker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        // Read the matrix elements
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Find and display peak-columns
        System.out.println("Peak-columns found:");
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPeakColumn(matrix, i, j)) {
                    System.out.printf("(%d,%d) = %d%n", i, j, matrix[i][j]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No peak-columns found.");
        }
    }

    // Method to check if the element at matrix[row][col] is a peak-column
    private static boolean isPeakColumn(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        
        // Check if it's the maximum in its row
        for (int j = 0; j < matrix[row].length; j++) {
            if (matrix[row][j] > value) {
                return false;
            }
        }
        
        // Check if it's the minimum in its column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] < value) {
                return false;
            }
        }
        
        return true;
    }
}
