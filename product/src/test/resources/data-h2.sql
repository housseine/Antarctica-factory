BEGIN TRANSACTION;
DELETE FROM categorie_table;
INSERT INTO categorie_table (categorie_id, label) VALUES
(2, 't-shirt'),
(4, 'Kids'),
(5, 'Men');

INSERT INTO clothes_categorie (clothes_id, categorie_id) VALUES
(2, 1);

INSERT INTO clothes_table (clothes_id, date, description, label) VALUES
(2, '2021-01-19 18:30:03', 'best jean', 'jean');
INSERT INTO hibernate_sequence (next_val)
 SELECT 3 FROM dual UNION ALL 
 SELECT 3 FROM dual;
COMMIT;