When running in Docker on exposed port 8081

Test add order

curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{
    "userId": "user123",
    "totalAmount": 100.0,
    "items": [
        {
            "itemName": "Item A",
            "quantity": 2,
            "price": 20.0
        },
        {
            "itemName": "Item B",
            "quantity": 1,
            "price": 60.0
        }
    ]
}'



Test get orders by userId

curl -X GET "http://localhost:8081/orders?userId=123"

