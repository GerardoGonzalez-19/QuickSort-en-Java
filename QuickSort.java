public class QuickSort {

    // Método principal que ejecuta el algoritmo QuickSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Obtener el índice del pivote
            int pivotIndex = partition(array, low, high);

            // Ordenar recursivamente los elementos antes y después del pivote
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Tomamos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (array[j] <= pivot) {
                i++;
                // Intercambiar array[i] y array[j]
                swap(array, i, j);
            }
        }

        // Intercambiar el pivote a su posición correcta
        swap(array, i + 1, high);

        return i + 1;
    }

    // Método auxiliar para intercambiar dos elementos
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método para imprimir el arreglo
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método main
    public static void main(String[] args) {
        int[] numbers = {34, 7, 23, 32, 5, 62, 32, 2, 78, 1};

        System.out.println("Arreglo antes de ordenar:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("Arreglo después de ordenar:");
        printArray(numbers);
    }
}