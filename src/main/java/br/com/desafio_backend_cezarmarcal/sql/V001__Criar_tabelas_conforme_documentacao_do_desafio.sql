-- Optei por utilizar o banco H2 para demonstrações e testes das operações CRUD.
-- Todos os scripts SQL foram criados com base no H2, para facilitar a execução e testes localmente.
--
-- Passos para Verificação de Funcionamento:
-- 1. Inicie a aplicação "Crud Plantas".
-- 2. Acesse o console H2 no navegador, preferencialmente pelo endereço:
--    http://localhost:8080/h2-console
-- 3. Verificar se as operações SQL estão funcionando corretamente no banco de dados.

-- Criação da tabela Salesperson
CREATE TABLE Salesperson (
    ID INT PRIMARY KEY,
    Name VARCHAR(100),
    Age INT,
    Salary DECIMAL(10, 2)
);

-- Criação da tabela Customer
CREATE TABLE Customer (
    ID INT PRIMARY KEY,
    Name VARCHAR(100),
    City VARCHAR(100),
    IndustryType CHAR(1)
);

-- Criação da tabela Orders
CREATE TABLE Orders (
    ID INT PRIMARY KEY,
    order_date DATE,
    customer_id INT,
    salesperson_id INT,
    Amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES Customer(ID),
    FOREIGN KEY (salesperson_id) REFERENCES Salesperson(ID)
);