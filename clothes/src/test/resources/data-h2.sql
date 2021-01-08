BEGIN TRANSACTION;
DELETE FROM categorie_table;
INSERT INTO categorie_table (categorie_id, label) VALUES
(2, 't-shirt'),
(4, 'Kids'),
(5, 'Men');

INSERT INTO hibernate_sequence (next_val) VALUES
(6),
(6);
COMMIT;