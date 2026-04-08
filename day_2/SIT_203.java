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

        for(int i = 0; i < n1; i++){
            leftArray[i] = orders[left + i];
        }
        for(int j = 0; j < n2; j++){
            rightArray[j] = orders[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(leftArray[i].customerType.equals("Prime") && rightArray[j].customerType.equals("Regular")){
                orders[k++] = leftArray[i++];
            } else if(leftArray[i].customerType.equals("Regular") && rightArray[j].customerType.equals("Prime")){
                orders[k++] = rightArray[j++];
            } else {
                if(leftArray[i].orderValue > rightArray[j].orderValue){
                    orders[k++] = leftArray[i++];
                } else if(leftArray[i].orderValue < rightArray[j].orderValue){
                    orders[k++] = rightArray[j++];
                } else {
                    if(leftArray[i].deliveryTime < rightArray[j].deliveryTime){
                        orders[k++] = leftArray[i++];
                    } else {
                        orders[k++] = rightArray[j++];
                    }
                }
            }
        }
        while(i < n1){
            orders[k++] = leftArray[i++];
        }
        while(j < n2){
            orders[k++] = rightArray[j++];
        }
    }
}
