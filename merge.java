public class merge {


//    int[] merge(int[] a, int[] b, int la, int lb)
//{
//	return a;
//}

    public int[] mergeArrays(int[] a, int[] b, int la, int lb){

        int[] res = new int[la + lb];
        int i=0, j=0, k=0;
        while(i< la && j< lb){
            if(a[i] < b[j]){
                res[k++] = a[i];
                i++;
            }else{
                res[k++] = b[j];
                j++;
            }
        }

        while(i < la){
            res[k++] = a[i++];
        }
        while(j< lb){
            res[k++] = b[j++];
        }

        return res;
    }

    public int[] merge2(int[] a, int[] b, int la, int lb){
        int i = la -1 , j = lb - 1;
        int k = la + lb -1;
        while(i >= 0 && j >= 0){
            if(a[i] >= b[j]){
                a[k--] = a[i--];

            }
            else {
                a[k--] = b[j--];
            }
        }

        while(j >= 0){
            a[k--] = b[j--];
        }
        return  a;

    }

    public static

}
