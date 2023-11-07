package Functionality;
import java.util.*;

public class StopLimitOrder extends Order {
	double priceLimit,lossLimit;
	Scanner sc = new Scanner(System.in);

	public int placeOrder(String username,Stock ob,boolean isBuyOrder, int quantity, String timeInforce) {
		System.out.println("Enter Stop Loss");
		int quantityPlaced = 0;
		priceLimit = sc.nextDouble();
		if((isBuyOrder && ob.getPrice()>=priceLimit) || (!isBuyOrder && ob.getPrice()<=priceLimit)){
		//When stoploss is triggered,it becomes Limit order
		Order orderObj = new LimitOrder();
		quantityPlaced = orderObj.placeOrder(username, ob, isBuyOrder, quantity, timeInforce);
		
		if(quantityPlaced == quantity) {
			this.status = "filled";
		}else {
			this.status = "working";
		}
		}
		return quantityPlaced;
	}

	public String getStatus() {
		return (this.status);
	}

}