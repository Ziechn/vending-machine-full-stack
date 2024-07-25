-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER vending_machine_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO vending_machine_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO vending_machine_owner;

CREATE USER vending_machine_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO vending_machine_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO vending_machine_appuser;
