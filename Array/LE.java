package Array;

public class LE {

    public static void main(String[] args) {


        int cardNum = 2021;
        int[] remainCard = new int[10];

        for (int i = 0; i < 10; i++) {
            remainCard[i] = cardNum;
        }

        int totalNum = 0;
        boolean newNum = true;
        while (newNum){

            String currentNum = String.valueOf(totalNum + 1);
            boolean thisNum = true;
            for(int i = 0; i < currentNum.length(); i++){
                int digit = currentNum.charAt(i) - '0';
                if(remainCard[digit] > 0){
                    remainCard[digit]--;
                }else{
                    thisNum = false;
                    break;
                }
            }

            if(thisNum){
                totalNum++;
            }else{
                newNum = false;
            }

        }

        System.out.println(totalNum);
    }



}
