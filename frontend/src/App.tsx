import { useState } from "react";

interface OrderItem {
  id: number;
  itemName: string;
  quantity: number;
  price: number;
}

interface Order {
  id: number;
  userId: string;
  items: OrderItem[];
  totalAmount: number;
}

function App() {
  const [userId, setUserId] = useState("");
  const [orders, setOrders] = useState<Order[]>([]);
  const [error, setError] = useState("");

  const fetchOrders = async () => {
    setError("");
    try {
      const response = await fetch(`http://localhost:8080/api/orders?userId=${userId}`);
      if (!response.ok) throw new Error("Failed to fetch orders");
      const data: Order[] = await response.json();
      setOrders(data);
    } catch (err) {
      setError("Error fetching orders. Please try again.");
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h2>Order Lookup</h2>
      <input
        type="text"
        placeholder="Enter User ID"
        value={userId}
        onChange={(e) => setUserId(e.target.value)}
        style={{ padding: "10px", marginRight: "10px" }}
      />
      <button onClick={fetchOrders} style={{ padding: "10px" }}>Fetch Orders</button>

      {error && <p style={{ color: "red" }}>{error}</p>}

      <h3>Orders:</h3>
      {orders.length === 0 ? <p>No orders found.</p> : (
        orders.map(order => (
          <div key={order.id} style={{ border: "1px solid #ddd", padding: "10px", marginBottom: "10px" }}>
            <p><strong>Order ID:</strong> {order.id}</p>
            <p><strong>Total Amount:</strong> ${order.totalAmount.toFixed(2)}</p>
            <h4>Items:</h4>
            <ul>
              {order.items.map(item => (
                <li key={item.id}>{item.itemName} - {item.quantity} x ${item.price.toFixed(2)}</li>
              ))}
            </ul>
          </div>
        ))
      )}
    </div>
  );
}

export default App;
