CREATE TABLE sector
(
    id               INTEGER NOT NULL PRIMARY KEY,
    parent_sector_id INTEGER,
    depth INTEGER,
    text             VARCHAR(128) NOT NULL,
    CONSTRAINT fk_parent_sector
        FOREIGN KEY (parent_sector_id)
            REFERENCES sector (id)
            ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE registration
(
    id               INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(128) NOT NULL,
    terms            BOOLEAN DEFAULT FALSE
);

CREATE TABLE saved_sector
(
    id               INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    registration_id INTEGER NOT NULL,
    sector_id INTEGER NOT NULL,
    CONSTRAINT fk_registration
        FOREIGN KEY (registration_id)
            REFERENCES registration (id)
            ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_sector
        FOREIGN KEY (sector_id)
            REFERENCES sector (id)
            ON DELETE CASCADE ON UPDATE CASCADE
);