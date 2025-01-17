CREATE TABLE drugstore(
     id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     address VARCHAR(255) NOT NULL
);

CREATE TABLE drug(
      id SERIAL PRIMARY KEY,
      title VARCHAR(255) NOT NULL,
      description TEXT,
      drugstore_id INTEGER NOT NULL,
      FOREIGN KEY (drugstore_id) REFERENCES drugstore(id) ON DELETE CASCADE
);