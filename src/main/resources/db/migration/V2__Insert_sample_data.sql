INSERT INTO PERSONS (name, surname, age, phone_number, city_of_living)
VALUES ('Ivan', 'Ivanov', 30, '+79001234567', 'MOSCOW'),
       ('Maria', 'Petrova', 25, '+79009876543', 'SAINT-PETERSBURG'),
       ('Alexey', 'Sidorov', 35, '+79001112233', 'MOSCOW'),
       ('Olga', 'Kuznetsova', 28, '+79004445566', 'NOVOSIBIRSK'),
       ('Dmitry', 'Smirnov', 40, '+79007778899', 'MOSCOW') ON CONFLICT (name, surname, age) DO NOTHING;