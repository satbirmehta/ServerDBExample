CREATE TABLE person (
    id INTEGER PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INTEGER
);

CREATE TABLE pet (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50),
    breed VARCHAR(50),
    age INTEGER,
    dead INTEGER
);

CREATE TABLE person_pet (
    person_id INTEGER,
    pet_id INTEGER
);


INSERT INTO person (id, first_name, last_name, age)
    VALUES (0, 'Dave', 'Wolfe', 25);
    
    INSERT INTO pet (id, name, breed, age, dead)
    VALUES (0, 'Fluffy', 'Unicorn', 1000, 0);
    
    INSERT INTO pet VALUES (1, 'Gigantor', 'Robot', 1, 1);
    
    INSERT INTO person_pet (person_id, pet_id) VALUES (0, 0);
INSERT INTO person_pet VALUES (0, 1);

select * from person;
select * from pet;
select * from person_pet;
