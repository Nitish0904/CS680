package edu.umb.cs680.hw16;

public interface Observer<StockEvent> {
	void update(Observable<edu.umb.cs680.hw16.StockEvent> sender, edu.umb.cs680.hw16.StockEvent event);

	public void update(Observable<StockEvent> sender, StockEvent event);
}
