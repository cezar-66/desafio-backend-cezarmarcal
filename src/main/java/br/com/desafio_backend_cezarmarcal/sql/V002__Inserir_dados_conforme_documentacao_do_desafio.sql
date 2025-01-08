-- Inserir dados na tabela Salesperson
INSERT INTO Salesperson (ID, Name, Age, Salary) VALUES
(1, 'Abe', 61, 140000),
(2, 'Bob', 34, 44000),
(5, 'Chris', 34, 40000),
(7, 'Dan', 41, 52000),
(8, 'Ken', 57, 115000),
(11, 'Joe', 38, 38000);

-- Inserir dados na tabela Customer
INSERT INTO Customer (ID, Name, City, IndustryType) VALUES
(4, 'Samsonic', 'Pleasant', 'J'),
(6, 'Panasung', 'Oaktown', 'J'),
(7, 'Samony', 'Jackson', 'B'),
(9, 'Orange', 'Jackson', 'B');

-- Inserir dados na tabela Orders
INSERT INTO Orders (ID, order_date, customer_id, salesperson_id, Amount) VALUES
(10, '1996-08-02', 4, 2, 540),
(20, '1999-01-30', 4, 8, 1800),
(30, '1995-07-14', 9, 1, 460),
(40, '1998-01-29', 7, 2, 2400),
(50, '1998-02-03', 6, 7, 600),
(60, '1998-03-02', 6, 7, 720),
(70, '1998-05-06', 9, 7, 150);