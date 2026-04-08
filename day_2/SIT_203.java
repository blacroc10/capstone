class Order{
    int orderID;
    String customerType;
    double orderValue;
    int deliveryTime;

    public Order(int orderID, String customerType, double orderValue, int deliveryTime) {
        this.orderID = orderID;
        this.customerType = customerType;
        this.orderValue = orderValue;
        this.deliveryTime = deliveryTime;
    }

    

}
public class SIT_203 {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Regular", 500.0, 5),
            new Order(102, "Prime", 300.0, 3),
            new Order(103, "Regular", 700.0, 4),
            new Order(104, "Prime", 500.0, 2),
            new Order(105, "Regular", 700.0, 2)
        };
        mergeSort(orders, 0, orders.length - 1);
    }
    static void mergeSort(Order[] orders, int left, int right){
        if(left < right){ //divide the array till we get single element
            int mid = (left + right) / 2;
            //recursion
            mergeSort(orders, left, mid);
            mergeSort(orders, mid + 1, right);
            merge(orders, left, mid, right);
        }
    }

    static void merge(Order[] orders, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Order[] leftArray = new Order[n1];
        Order[] rightArray = new Order[n2];

        int leftIndex = 0;
        for (Order order : java.util.Arrays.copyOfRange(orders, left, mid + 1)) {
            leftArray[leftIndex++] = order;
        }

        int rightIndex = 0;
        for (Order order : java.util.Arrays.copyOfRange(orders, mid + 1, right + 1)) {
            rightArray[rightIndex++] = order;
        }

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(compare(leftArray[i], rightArray[j]) <= 0){
                orders[k++] = leftArray[i++];
            } else {
                orders[k++] = rightArray[j++];
            }
        }
        while(i < n1){
            orders[k++] = leftArray[i++];
        }
        while(j < n2){
            orders[k++] = rightArray[j++];
        }
    }

    static int compare(Order first, Order second) {
        if (!first.customerType.equals(second.customerType)) {
            return first.customerType.equals("Prime") ? -1 : 1;
        }

        if (first.orderValue != second.orderValue) {
            return Double.compare(second.orderValue, first.orderValue);
        }

        return Integer.compare(first.deliveryTime, second.deliveryTime);
    }
}
