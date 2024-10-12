package example;

public class binaryTransfer {
    public static int binary_fill (int n) {
        // write code here
        String binary = Integer.toBinaryString(n);
        int firstOne = binary.indexOf("1");
        int lastOne = binary.lastIndexOf("1");

        if(firstOne == -1 || lastOne == -1){
            return 0;
        }

        char[] chars = binary.toCharArray();
        for(int i = firstOne; i < lastOne; i++){
            chars[i] = '1';
        }
        String modified = new String(chars);
        return Integer.parseInt(modified, 2);






    }

    public static void main(String[] args) {
        int n = 18;
        int mod = binary_fill(n);
        System.out.println(mod);
    }

}
