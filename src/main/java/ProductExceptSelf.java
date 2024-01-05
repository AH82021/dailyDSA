public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int prefixProduct =1;
        int suffixProduct = 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] =prefixProduct;
            prefixProduct *= nums[i];
        }

        for (int i = len -1; i >=0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }


        return result;
    }
}
