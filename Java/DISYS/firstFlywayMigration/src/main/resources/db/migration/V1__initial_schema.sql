CREATE TABLE Customer (
                          customer_id INT PRIMARY KEY,
                          name VARCHAR(100),
                          email VARCHAR(100) UNIQUE
);

CREATE TABLE ChargingStation (
                                 station_id INT PRIMARY KEY,
                                 location VARCHAR(100)
);

CREATE TABLE ChargingSession (
                                 session_id INT PRIMARY KEY,
                                 start_time TIMESTAMP,
                                 end_time TIMESTAMP,
                                 kWh_used DECIMAL(10, 2),
                                 customer_id INT,
                                 station_id INT,
                                 FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
                                 FOREIGN KEY (station_id) REFERENCES ChargingStation(station_id)
);

CREATE TABLE Invoice (
                         invoice_id INT PRIMARY KEY,
                         total_amount DECIMAL(10, 2),
                         invoice_date DATE,
                         customer_id INT,
                         FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE Payment (
                         payment_id INT PRIMARY KEY,
                         amount DECIMAL(10, 2),
                         payment_date DATE,
                         payment_method VARCHAR(50),
                         customer_id INT,
                         FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

--  relationship between Invoice and Payment
CREATE TABLE Invoice_Payment (
                                 invoice_id INT,
                                 payment_id INT,
                                 PRIMARY KEY (invoice_id, payment_id),
                                 FOREIGN KEY (invoice_id) REFERENCES Invoice(invoice_id),
                                 FOREIGN KEY (payment_id) REFERENCES Payment(payment_id)
);
