CREATE TABLE IF NOT EXISTS PRODUCT (
    code VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    stock INTEGER,
    unitPrice DECIMAL
);