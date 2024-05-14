CREATE TABLE IF NOT EXISTS ids (
    table_name varchar(100) NOT NULL,
    next_id varchar(10) NULL
);

CREATE TABLE IF NOT EXISTS testdb (
    testid varchar(255) NULL,
   "name" varchar(255) NULL,
   phonenumber varchar(20) NULL
);