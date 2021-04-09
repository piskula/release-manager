-- CREATE TABLE system_version
-- (
--     id             INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--     version_number INT UNSIGNED UNIQUE NOT NULL,
-- );
--
-- CREATE TABLE service_version
-- (
--     system_version INT UNSIGNED AUTO_INCREMENT,
--     version_number INT UNSIGNED NOT NULL,
--     name           VARCHAR(255) NOT NULL,
--     PRIMARY KEY (system_version, version_number, name)
-- );

CREATE TABLE system_version
(
    id             INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    version_number INT UNSIGNED UNIQUE NOT NULL,
    start_date     DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3)
);

CREATE TABLE service_version
(
    name       VARCHAR(255) NOT NULL,
    version     INT UNSIGNED NOT NULL,
    start_date DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3),
    PRIMARY KEY (name, version)
)
