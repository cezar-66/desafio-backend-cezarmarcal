-- a. Retornar os nomes de todos os Salespersons que não têm nenhum pedido com Samsonic
SELECT s.Name
FROM Salesperson s
WHERE s.ID NOT IN (
    SELECT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.Name = 'Samsonic'
);

-- b. Atualizar os nomes dos Salespersons que têm 2 ou mais pedidos, adicionando um '*' no final do nome
UPDATE Salesperson
SET Name = CONCAT(Name, '*')
WHERE ID IN (
    SELECT o.salesperson_id
    FROM Orders o
    GROUP BY o.salesperson_id
    HAVING COUNT(o.ID) >= 2
);

-- c. Deletar todos os Salespersons que colocaram pedidos para a cidade de Jackson
DELETE FROM Orders
WHERE salesperson_id IN (
    SELECT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.City = 'Jackson'
);

DELETE FROM Salesperson
WHERE ID IN (
    SELECT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.City = 'Jackson'
);

-- D. Retornar o total de vendas de cada Salesperson. Se o Salesperson não tiver vendido nada, retornar zero
SELECT s.Name, COALESCE(SUM(o.Amount), 0) AS TotalSales
FROM Salesperson s
LEFT JOIN Orders o ON s.ID = o.salesperson_id
GROUP BY s.ID;
