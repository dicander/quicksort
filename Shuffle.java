public class Shuffle {

    // Main creates a list of 10 elements, 1 to 10. If the program was fed unfair
    // a biased shuffler will be used. Otherwise a fair shuffler (Fisher-Yates) will be used.

    public static void main(String[] args) {
        int[] list = new int[3];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }

        boolean unfair = false;
        if (args.length > 0) {
            if (args[0].equals("unfair"))
                unfair = true;
        }

        if (unfair) {
            unfairShuffle(list);
        } else {
            fairShuffle(list);
        }

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    // Fisher-Yates shuffle
    public static void fairShuffle(int[] list) {
        for (int i = list.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            swap(list, i, j);
        }
    }

    // Biased shuffle
    public static void unfairShuffle(int[] list) {
        //System.out.println("Unfair shuffle");
        for (int i = 0; i < list.length; i++) {
            int j = (int) (Math.random() * list.length);
            swap(list, i, j);
        }
    }
    
    // Swap the elements at indices i and j in the array list.
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}